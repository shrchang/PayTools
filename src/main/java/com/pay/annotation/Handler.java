package com.pay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pay.enums.PayWay;

/**
 * 仅仅用于支付接口实现定义
 * @ClassName Handler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月3日 上午10:40:36
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface Handler {
	
	/**
	 * 支付选择方式 
	 * </br>
	 * {@link PayWay}
	 */
	PayWay value();
}
