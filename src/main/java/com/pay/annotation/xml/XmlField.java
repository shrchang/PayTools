package com.pay.annotation.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * xml的字段
 * @ClassName XmlField
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午4:17:16
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface XmlField {

	/**
	 * 对应的节点名称
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午4:17:55
	 * @return String
	 * @description
	 */
	public String name() default "";
	
	/**
	 * 默认值
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午4:18:28
	 * @return String
	 * @description
	 */
	public String defaultValue() default "";
}
