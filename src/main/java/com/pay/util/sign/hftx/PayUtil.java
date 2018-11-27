package com.pay.util.sign.hftx;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.huifu.saturn.cfca.CFCASignature;
import com.huifu.saturn.cfca.SignResult;
import com.huifu.saturn.cfca.VerifyResult;
import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.hftx.BasicRequestParam;
import com.pay.exception.PayException;
import com.pay.util.text.JsonUtil;
import com.pay.util.text.Reflections;

import cfca.sadk.org.bouncycastle.asn1.ocsp.Signature;

/**
 * 汇付天下支付的帮助类 包含加密，解密，验证，组装请求参数
 * @ClassName PayUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 上午10:44:10
 *
 */
public class PayUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PayUtil.class);
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PayUtil.class);
	
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
	public static <T extends BasicRequestParam> String getSign(T t)throws PayException{
		List<Field> fields = new ArrayList<Field>() ;
		Class c = t.getClass();
		//因为是子类所以要获取所有父类的字段与他对应的字段值
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		Map<String,String> param = new HashMap<String,String>();
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel paramLabel = f.getAnnotation(PayRequestParamLabel.class);
				if(paramLabel.isSign()){
					Object obj = Reflections.getFieldValue(t, f.getName());
					String value = (obj!=null ? String.valueOf(obj+"") : "");
					
					String name = StringUtils.isNoneBlank(paramLabel.name())?paramLabel.name() : f.getName();
					//必须是不为空才可以参与签名
					if(StringUtils.isNotBlank(value)){
						param.put(name, value);
					}
				}
			}
		}
		//获取参数的JSON格式
		String paramJson = JsonUtil.getJsonStrByObj(param);
		try {
			logger.info("***********汇付天下支付需要加密的参数**************：" + paramJson);
			log.info("***********汇付天下支付需要加密的参数**************：" + paramJson);
			String base64RequestParams = Base64.encodeBase64String(paramJson.getBytes(Charset.forName("utf-8")));
			log.info("***************汇付天下支付Base64后参数：**"+base64RequestParams + "*******加密文件路径：" + t.getPfxFilePath() + "***文件密码：" + t.getPfxFilePwd());
			SignResult signResult = CFCASignature.signature(t.getPfxFilePath(), t.getPfxFilePwd(), base64RequestParams, "utf-8");
			logger.info("***********加密结果**************：" + signResult.getSign());
			log.info("***********加密结果**************：" + JsonUtil.getJsonStrByObj(signResult));
			if ("000".equals(signResult.getCode())) {
				return signResult.getSign();
			} else {
				throw new PayException("加密失败！");
			}
		} catch (Exception e) {
			log.error("加密错误：",e);
			new PayException(e.getLocalizedMessage());
		}
		return null;
	}
	
	/**
	 * 获取http调用的执行参数
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @date 2018年9月29日 上午11:07:03
	 * @return Map<String,String>
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> Map<String,String> getHttpPostParam(T t){
		Map<String,String> pairs = new HashMap<String,String>();
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
				if(paramLabel.isParam()){
					Object obj = Reflections.invokeGetter(t, f.getName());
					String value = (obj!=null ? String.valueOf(obj+"") : "");
					//这里保证值不能为空？ TODO 暂时有疑问 后面处理
					if(StringUtils.isNotBlank(value)){
						//后面加的新的逻辑，如果发现配置了name就按照name来传参
						String name = StringUtils.isNotBlank(paramLabel.name())?paramLabel.name():f.getName();
						pairs.put(name,value);
					}
				}
			}
		}
		return pairs;
	}
	
	
	/**
	 * 验证参数是否存在
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
					String filed = label.signField();
					//这个地方要判断是不是包含这个字段 如果有则需要判断 是不是符合规则 否则跳过即可
					if(StringUtils.isNotBlank(filed)){
						String[] signOptions = label.signOptions();
						Object filedValue = Reflections.getFieldValue(t, filed);
//						Object filedValue = Reflections.invokeGetter(t, filed);
						//发现这个没有设置值，或者这个不在里面的话 就直接跳过验证 否则必须验证这个是不是为空
						if(filedValue == null || !Arrays.asList(signOptions).contains(filedValue)){
							continue;
						}
					}
					String keyName = StringUtils.isNotBlank(label.name()) ? label.name() : f.getName();
					Object value = Reflections.invokeGetter(t, f.getName());
					if(value == null || StringUtils.isBlank(String.valueOf(value))){
						throw new Exception("参数【"+keyName+"】不能为空！");
					}
				}
			}
		}
	}
	
	/**
	 * 对http请求返回的内容进行解密
	 * @author shrChang.Liu
	 * @param res 需要解密的内容
	 * @param merId 商户号 id 固定100001
	 * @param trustCerPath cer证书完整路径
	 * @return
	 * @date 2018年9月29日 上午11:23:21
	 * @return String
	 * @description
	 */
	public static String decryptResponse(String res,String merId,String trustCerPath)throws PayException{
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("check_value")){
			String checkValue = json.getString("check_value");
			VerifyResult verifyResult = CFCASignature.verifyMerSign(merId, checkValue, "utf-8", trustCerPath);
			if(!"000".equals(verifyResult.getCode())){
				throw new PayException("验签失败:" + verifyResult.getMessage());
			}
			String content = new String(verifyResult.getContent(), Charset.forName("utf-8"));
			String ret = new String(Base64.decodeBase64(content),Charset.forName("utf-8"));
			logger.info("****************解密后打印出来的响应结果*****************：" + ret);
			return ret;
		}
		return null;
	}

}
