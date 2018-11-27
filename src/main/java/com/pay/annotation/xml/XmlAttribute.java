package com.pay.annotation.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 必须在XmlAlias下面 否则无效
 * @ClassName XmlAttribute
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午4:14:41
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface XmlAttribute {
	
	/**
	 * 对应属性的名称
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午4:15:56
	 * @return String
	 * @description
	 */
	public String name();
	
	/**
	 * 属性的默认值
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午4:16:18
	 * @return String
	 * @description
	 */
	public String defaultValue() default "";
}
