package com.pay.util.text;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * json处理工具 采用fastJson
 * @ClassName JsonUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午3:38:14
 *
 */
public class JsonUtil {
	
	/**
	 * 将一个对象直接转化成json字符串
	 * @author shrChang.Liu
	 * @param @param t
	 * @param @return
	 * @date 2018年6月21日下午3:38:58
	 * @return String
	 * @description
	 */
	public static <T> String getJsonStrByObj(T t){
		return JSON.toJSONString(t);
	}
	
	/**
	 * 支持导出为空的字符，如果是NULL就默认导出空字符串
	 * @author shrChang.Liu
	 * @param t
	 * @param isExportNull
	 * @return
	 * @date 2018年6月28日 下午4:34:18
	 * @return String
	 * @description
	 */
	public static<T> String getJsonStrByObj(T t,boolean isExportNull){
		if(isExportNull){
			return JSON.toJSONString(t,SerializerFeature.WriteNullStringAsEmpty);
		}
		return getJsonStrByObj(t);
	}
	
	/**
	 * 将一个字符创转化为一个对象
	 * @author shrChang.Liu
	 * @param @param str
	 * @param @return
	 * @date 2018年6月21日下午3:51:23
	 * @return T
	 * @description
	 */
	public static <T> T getObjectByJsonStr(String str,Class<T> t){
		return JSON.parseObject(str, t);
	}
	
	/**
	 * 将字符创转化为列表对象
	 * @author shrChang.Liu
	 * @param @param str
	 * @param @param t
	 * @param @return
	 * @date 2018年6月21日下午3:57:34
	 * @return List<T>
	 * @description
	 */
	public static <T> List<T> getListObjectByJsonStr(String str,Class<T> t){
		return JSON.parseArray(str, t);
	}

}
