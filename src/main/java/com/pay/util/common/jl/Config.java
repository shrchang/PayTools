package com.pay.util.common.jl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 服务参数配置文件的加载和获取
 * @author Administrator
 */
public class Config {

	private static final String propsPath = "jl/config.properties";
	private static Properties props = new Properties();
	private static boolean initFlag = false;

	/**
	 * 初始化配置文件
	 */
	private static synchronized void init() {
		if (!initFlag) {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStreamReader in = null;
			try {
				if (cl != null)
					in = new InputStreamReader(cl.getResourceAsStream(propsPath),"UTF-8");
				if(in != null)
					props.load(in);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
			initFlag = true;
		}
	}

	/**
	 * 获取初始化参数
	 * @param propName
	 * @return
	 */
	public static String getProperty(String propName) {
		init();
		return props.getProperty(propName);
	}
}
