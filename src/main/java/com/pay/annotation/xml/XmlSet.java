package com.pay.annotation.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个代表是列表数据
 * @ClassName XmlSet
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午4:19:19
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface XmlSet {
	
	/**
	 * 对应节点的名称
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午4:19:40
	 * @return String
	 * @description
	 */
	public String name();
}
