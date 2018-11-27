package com.pay.util.sign.zgyt;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.exception.PayException;
import com.pay.util.encrypt.Md5;
import com.pay.util.text.Reflections;

/**
 * 签名帮助
 * @ClassName SignUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月3日 下午4:05:59
 *
 */
public class SignUtil {
	
	private static Logger logger = Logger.getLogger(SignUtil.class);
	
	/**
	 * 获取具体的签名这个会根据注解来进行解析，目前只针对中钢银通
	 * @author shrChang.Liu
	 * @param @param t
	 * @param @return
	 * @date 2018年6月21日下午2:15:20
	 * @return String
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> String getSign(T t,String key)throws Exception{
		List<Field> fields = new ArrayList<Field>() ;
		Class c = t.getClass();
		//因为是子类所以要获取所有父类的字段与他对应的字段值
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		List<String> values = new ArrayList<String>();
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel paramLabel = f.getAnnotation(PayRequestParamLabel.class);
				if(paramLabel.isSign()){
					Object obj = Reflections.getFieldValue(t, f.getName());
					if(obj != null){
						String value =  String.valueOf(obj+"");
						values.add(f.getName() + "=" + value+"&");
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
		sign = sign+"key="+key;
		logger.info("需要加密的参数：" + sign);
		String signStr = Md5.encode(sign.getBytes("UTF-8")).toUpperCase();
		logger.info("加密后的值：" + signStr);
		return signStr;
	}
	
	/**
	 * 获取参数值Map
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @date 2018年9月3日 下午6:13:44
	 * @return Map<String,String>
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> Map<String,String> getHttpPostParamMap(T t){
		Map<String,String> param = new HashMap<String, String>();
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
						param.put(name, value);
					}
				}
			}
		}
		return param;
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
	public static <T extends BaseUrlEntity> void validate(T t)throws PayException{
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
						throw new PayException("参数【"+keyName+"】不能为空！");
					}
				}
			}
		}
	}
	
}
