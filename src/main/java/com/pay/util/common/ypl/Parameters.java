package com.pay.util.common.ypl;

import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 获取properties配置文件的内容 当前只针对易票联的配置文件
 * @ClassName Parameters
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午10:54:48
 *
 */
@SuppressWarnings("rawtypes")
public class Parameters {
	private static Properties properties = null;
	static {
		if (properties == null) {
			InputStreamReader inputStream = null;
			try {
				properties = new Properties();
				ClassLoader cl = Thread.currentThread().getContextClassLoader();

				if (cl != null)
					inputStream = new InputStreamReader(cl
							.getResourceAsStream("ypl/paycenter_config.properties"),"UTF-8");

				if (inputStream != null) {
					properties.load(inputStream);
					inputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Enumeration enumeration = properties.keys();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			String value = properties.getProperty(key);
			properties.setProperty(key, wipeOffQuotation(value));
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	/**
	 * 如果传入字符串以'"'双引号开头并结尾，去掉此头尾返回中间；不是，直接返回原始字符串
	 * @param value
	 * @return
	 */
	private static String wipeOffQuotation(String value) {
		if ((value != null) && (value.length() > 0)
				&& (value.indexOf("\"") == 0)
				&& (value.lastIndexOf("\"") == value.length() - 1)) {
			return value.substring(1, value.length() - 1);
		}
		return value;
	}
	/**
	 * 根据转入的key值，得到相应的value，并按照‘；’切割为数组
	 * @param key
	 * @return
	 */
	public static String[] getPropertys(String key) {
		String str = properties.getProperty(key);
		return str.split(";");
	}
}
