package com.pay.util.sign.hfb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.hfb.pay.HFB_PayBaseRequestParam;
import com.pay.entity.hfb.pay.HFB_PayRetResponseEntity;
import com.pay.enums.TradeTypeEnum;
import com.pay.util.encrypt.Md5;
import com.pay.util.text.JsonUtil;
import com.pay.util.text.Reflections;

/**
 * 签名获取帮助类
 * @ClassName SignUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午1:33:47
 *
 */
public class SignUtil {
	
	/**
	 * 获取具体的签名这个会根据注解来进行解析，目前只针对汇付宝
	 * @author shrChang.Liu
	 * @param @param t
	 * @param @return
	 * @date 2018年6月21日下午2:15:20
	 * @return String
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> String getHybSign(T t)throws Exception{
		List<Field> fields = new ArrayList<Field>() ;
		Class c = t.getClass();
		//因为是子类所以要获取所有父类的字段与他对应的字段值
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		List<String> values = new ArrayList<String>();
		String key = "";
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel paramLabel = f.getAnnotation(PayRequestParamLabel.class);
				if(paramLabel.isSign()){
					Object obj = Reflections.getFieldValue(t, f.getName());
					String value = (obj!=null ? String.valueOf(obj+"") : "");
					if(paramLabel.sortIndex() == 0){
						values.add(f.getName() + "=" + value+"&");
					}else{
						key = value;
					}
				}
			}
		}
		if(values.size()<1){
			throw new Exception("没有找到需要签名的属性！");
		}
		Collections.sort(values);
		String sign = "";
		for(String v : values){
			sign = sign + v;
		}
		//如果密钥不为空的话将用户密钥加到最后面
		if(StringUtils.isNotBlank(key)){
			sign = sign + "key"+key;
		}
		System.out.println("加密的字段：" + sign);
		return Md5.encode(sign);
	}
	
	
	/**
	 * 返回需要传递的参数，采用getter的方式获取属性值如果去默认在对象中实现签名的获取的话 就可以直接获取到签名
	 * @author shrChang.Liu
	 * @param @param t
	 * @param @return
	 * @date 2018年6月21日下午3:27:43
	 * @return List<NameValuePair>
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> List<NameValuePair> getHttpPostParam(T t){
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		List<Field> fields = new ArrayList<Field>() ;
		Class c = t.getClass();
		//因为是子类所以要获取所有父类的字段与他对应的字段值
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel paramLabel = f.getAnnotation(PayRequestParamLabel.class);
				//这里可能需要添加其他的逻辑 暂时先不管
				if(paramLabel.isRequired()){
					Object obj = Reflections.invokeGetter(t, f.getName());
					String value = (obj!=null ? String.valueOf(obj+"") : "");
					//这里保证值不能为空？ TODO 暂时有疑问 后面处理
					if(obj != null){
						//后面加的新的逻辑，如果发现配置了name就按照name来传参
						String name = StringUtils.isNotBlank(paramLabel.name())?paramLabel.name():f.getName();
						pairs.add(new BasicNameValuePair(name,value));
					}
				}
			}
		}
		return pairs;
	}
	
	public static void main(String[] args)throws Exception {
		HFB_PayBaseRequestParam baseRequestParam = new HFB_PayBaseRequestParam();
		baseRequestParam.setVersion("2.0");
		baseRequestParam.setMerchantId("100001");
		baseRequestParam.setMerchantBillNo("111010");
		baseRequestParam.setRequestTime("20180621144411");//这个不固定就会出现很多种签名出来
		baseRequestParam.setTradeType(TradeTypeEnum.HFB_ALIPAY_QR.getCode());
		baseRequestParam.setPayAmt(100.2d);
		baseRequestParam.setNotifyUrl("https://baidu.com");
		baseRequestParam.setUserIp("192.168.6.111");
		String str = JsonUtil.getJsonStrByObj(getHttpPostParam(baseRequestParam));
		System.out.println("字符串："+str);
		String pStr = JsonUtil.getJsonStrByObj(baseRequestParam);
		System.out.println(pStr);
		HFB_PayRetResponseEntity p = JsonUtil.getObjectByJsonStr(pStr, HFB_PayRetResponseEntity.class);
		System.out.println(p.getVersion()+",type:"+p.getMerchantId());
		/*HFB_PayBaseRequestParam b = JsonUtil.getObjectByJsonStr(str, HFB_PayBaseRequestParam.class);*/
		/*List<NameValuePair> pairs = JsonUtil.getListObjectByJsonStr(str, NameValuePair.class);
		pairs.stream().forEach(p->{
			System.out.println("key:"+p.getName() + ",value:"+p.getValue());
		});*/
	}
}
