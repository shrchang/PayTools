package com.pay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转化类
 * @ClassName DateUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 上午11:47:42
 *
 */
public class DateUtil {
	
	private static final String DEFAULT_PATTERN="YYYY-MM-dd HHmmss";//默认是的时间格式
	
	
	/**
	 * 根据格式返回对应的时间 如果出现错误直接返回null
	 * @author shrChang.Liu
	 * @param @param dateStr
	 * @param @param pattern
	 * @param @return
	 * @date 2018年6月21日上午11:53:07
	 * @return Date
	 * @description
	 */
	public static Date getDateByStr(String dateStr,String pattern){
		if(pattern == null){
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		try {
			return f.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据时间格式返回对应的字符串
	 * @author shrChang.Liu
	 * @param @param date 传入的时间
	 * @param @param pattern 需要定义的格式
	 * @param @return
	 * @date 2018年6月21日上午11:49:30
	 * @return String
	 * @description
	 */
	public static String getStrByDate(Date date,String pattern){
		if(pattern == null){
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}
	
	/**
	 * 返回当前时间固定格式的数据
	 * @author shrChang.Liu
	 * @param @param pattern
	 * @param @return
	 * @date 2018年6月21日上午11:54:21
	 * @return String
	 * @description
	 */
	public static String getStrByNow(String pattern){
		if(pattern == null){
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println(getStrByNow("YYYYMMddHHmmssSSS"));
	}
}
