package com.pay.util.sign.poco;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.text.JsonUtil;
import com.pay.util.text.Reflections;

/**
 * 返回请求Post参数里面的data的原始字符串 用于签名与加密
 * @ClassName SignUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月30日 下午12:45:24
 *
 */
public class RequestBodyUtil {
	
	/**
	 * 根据这个对象来进行签名 这个是poco专用的 需要按照字母排序
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @throws Exception
	 * @date 2018年6月30日 下午12:46:10
	 * @return String
	 * @description
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseUrlEntity> String getPostData(T t)throws Exception{
		Map<String,Object> map = new TreeMap<String,Object>(); 
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
				if(label.isSign()){
					String keyName = StringUtils.isNotBlank(label.name()) ? label.name() : f.getName();
					Object value = Reflections.getFieldValue(t, f.getName());
					if(value == null){
						throw new Exception("参数【"+keyName+"】不能为空！");
					}
					map.put(keyName, value);
				}
			}
		}
		if(map.size()>0){
			return JsonUtil.getJsonStrByObj(map);
		}else{
			throw new Exception("没有找到需要请求的参数！");
		}
	}
	
	/**
	 * 验证是否必填 并给出提示
	 * @author shrChang.Liu
	 * @param t
	 * @throws Exception
	 * @date 2018年6月30日 下午1:11:09
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
					if(value == null){
						throw new Exception("参数【"+keyName+"】不能为空！");
					}
				}
			}
		}
	}
	
	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
		return retStr;
	}
}
