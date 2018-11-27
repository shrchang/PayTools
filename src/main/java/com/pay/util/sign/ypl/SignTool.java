package com.pay.util.sign.ypl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.ypl.YPL_BasicRequestParam;
import com.pay.entity.ypl.YPL_BasicResponseEntity;
import com.pay.util.common.ypl.Parameters;
import com.pay.util.common.ypl.SecurityUtil;
import com.pay.util.encrypt.SHA256Util;
import com.pay.util.text.Reflections;

import sun.misc.BASE64Decoder;

/**
 * 易票联的sign加密方式
 * @ClassName SignTool
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午11:07:34
 *
 */
@SuppressWarnings("rawtypes")
public class SignTool {
	/** 商户密钥 */
	private static String key = Parameters.getProperty("key");
	
	private static Logger logger = LoggerFactory.getLogger(SignTool.class);
	
	/**
	 * 报文签名
	 * @param map
	 * @return
	 */
	public static <T extends YPL_BasicRequestParam> String makeSign(T t) {
        String sign = "";
        try {
        	StringBuffer sb = getClassBeforeString(t);
        	logger.error("需要加密的字串：" + sb.toString());
            if("SHA256withRSA".equals(t.getSignType())){
            	String str = sb.toString();
            	str = str.substring(0 ,str.length()-1);
                sign = SecurityUtil.signForBase64(str.getBytes(Parameters.getProperty("encoding")));
            }else{
            	sb.append("key="+key);
            	String str = sb.toString();
                sign = SHA256Util.SHA256Encode(str, Parameters.getProperty("encoding"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("加密的结果：" + sign);
        return sign;
    }

	/**
	 * 获取签名前的字符串
	 * @author shrChang.Liu
	 * @param t
	 * @return
	 * @date 2018年6月23日 下午11:41:09
	 * @return StringBuffer
	 * @description
	 */
	private static <T extends BaseUrlEntity> StringBuffer getClassBeforeString(T t) {
		List<Field> fields = new ArrayList<Field>();//获取所有的签名
		Class c = t.getClass();
		while(c.getSuperclass() != null){
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		List<String> values = new ArrayList<String>();
		for(Field f : fields){
			if(f.isAnnotationPresent(PayRequestParamLabel.class)){
				PayRequestParamLabel paramLabel = f.getAnnotation(PayRequestParamLabel.class);
				if(paramLabel.isSign()){
					Object obj = Reflections.getFieldValue(t, f.getName());
					String value = (obj!=null ? String.valueOf(obj+"") : "");
					if(paramLabel.sortIndex() == 0){
						if(StringUtils.isNotBlank(value)){
							//如果可以的话 还是用默认的会比较好
							String keyName = StringUtils.isNoneBlank(paramLabel.name())?paramLabel.name() : f.getName();
							values.add(keyName + "=" + value+"&");
						}
					}else{
						key = value;
					}
				}
			}
		}
		Collections.sort(values);
		StringBuffer sb = new StringBuffer("");
		for(String s : values){
			sb.append(s);
		}
		return sb;
	}
	
	/**
	 * 使用SHA256算法验证签名。规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * @return boolean
	 */
	public static <T extends YPL_BasicResponseEntity> boolean verifySign(T t) throws Exception{
		StringBuffer sb = getClassBeforeString(t);
		if("SHA256withRSA".equals(t.getSignType())){
        	String str = sb.toString();
        	str = str.substring(0 ,str.length()-1);
            byte[]signData = str.getBytes(Parameters.getProperty("encoding"));
            byte[]sign = new BASE64Decoder().decodeBuffer(t.getSign());
            return SecurityUtil.verify(signData, sign);
        }else{
        	sb.append("key="+ key);
        	String str = sb.toString();
    		//算出摘要
    		String sign = SHA256Util.SHA256Encode(str, Parameters.getProperty("encoding")).toLowerCase();
    		return t.getSign().toLowerCase().equals(sign);
        }
	}
}
