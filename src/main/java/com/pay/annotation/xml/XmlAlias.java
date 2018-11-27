package com.pay.annotation.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * xml里面的别名仅仅用于对象处理比如root
 * @ClassName XmlAlias
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午3:36:14
 *
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface XmlAlias {
	
	/**
	 * 对应xml里面的名称
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月22日 下午3:37:35
	 * @return String
	 * @description
	 */
	public String name();
}
