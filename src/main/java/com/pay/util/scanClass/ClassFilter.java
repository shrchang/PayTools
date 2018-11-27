package com.pay.util.scanClass;

/**
 * 扫描的时候过滤的接口
 * @ClassName ClassFilter
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月3日 下午2:30:53
 *
 */
public interface ClassFilter {
	boolean accept(@SuppressWarnings("rawtypes") Class clazz);
}
