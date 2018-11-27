package com.pay.util.sign.aPay;

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
import com.pay.util.encrypt.Md5;
import com.pay.util.text.Reflections;

/**
 * A支付的签名帮助类 MD加密
 * @ClassName SignUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午4:38:29
 *
 */
public class SignUtil {
	
	/**
	 * 将参数排序后才开始加密 需要拼接paySecret MD5加密后 转化为大写
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @throws Exception
	 * @date 2018年7月23日 下午4:38:53
	 * @return String
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> String getSign(T t)throws Exception{
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
					if(StringUtils.isNotBlank(value)){
						if(paramLabel.sortIndex() == 0){
							values.add(f.getName() + "=" + value+"&");
						}else{
							//这个地方把paySecret的字段弄成非0即可
							key = value;
						}
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
			sign = sign + "paySecret="+key;
		}
		return Md5.encode(sign).toUpperCase();
	}
	
	/**
	 * 获取请求参数 这个需要测试 post formData的方式
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @date 2018年7月23日 下午4:40:01
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
					if(StringUtils.isNotBlank(value)){
						//后面加的新的逻辑，如果发现配置了name就按照name来传参
						String name = StringUtils.isNotBlank(paramLabel.name())?paramLabel.name():f.getName();
						pairs.add(new BasicNameValuePair(name,value));
					}
				}
			}
		}
		return pairs;
	}
	
	/**
	 * 验证参数开始
	 * @author shrChang.Liu
	 * @param t
	 * @throws Exception
	 * @date 2018年7月23日 下午5:06:20
	 * @return void
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> void validate(T t)throws Exception{
		List<Field> fields = new ArrayList<Field>() ;
		Class c = t.getClass();
		//因为是子类所以要获取所有父类的字段与他对应的字段值
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel label = f.getAnnotation(PayRequestParamLabel.class);
				if(label.isRequired()){
					String keyName = StringUtils.isNotBlank(label.name()) ? label.name() : f.getName();
					Object value = Reflections.getFieldValue(t, f.getName());
					if(value == null || StringUtils.isBlank(String.valueOf(value))){
						throw new Exception("参数【"+keyName+"】不能为空！");
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args)throws Exception {
	}
}
