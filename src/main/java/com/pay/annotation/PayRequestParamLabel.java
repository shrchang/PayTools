package com.pay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 支付接口请求参数的标注
 * @ClassName PayRequestParamLabel
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 上午10:42:09
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface PayRequestParamLabel {
	
	/**
	 * 参数是否必须，这个用于最终解析出来的请求参数链，可以用于判断的 因为某些时候不会传递这个参数过来 可能存在空值的情况，如果发现这个为null的时候应该转义成空的字符串
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月21日上午10:43:37
	 * @return boolean
	 * @descption
	 */
	public boolean isRequired() default false;
	
	/**
	 * 是否需要签名，默认是如果是非必须的参数，不需要签名
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月21日上午10:43:48
	 * @return boolean
	 * @descption
	 */
	public boolean isSign() default false;
	
	/**
	 * 签名档的顺序，目前这个应该是是待使用，只用于特定情况下使用 当前值必须全部大于0的时候
	 * @author shrChang.Liu
	 * @param @return
	 * @date 2018年6月21日上午10:44:16
	 * @return int
	 * @descption
	 */
	public int sortIndex() default 0;
	
	/**
	 * 传递参数需要用到的字段
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年6月23日 下午10:31:38
	 * @return String
	 * @description
	 */
	public String name() default "";
	
	/**
	 * 当前参数是验证是否需要签名，如果这个参数不为空的时候 必须比较可能确认是不是需要加入到签名 必须满足isRequired=true
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年6月25日 上午9:29:09
	 * @return String
	 * @description
	 */
	public String signField() default "";
	
	/**
	 * 验证那个字段的值是不是在这个集合中  {@link PayRequestParamLabel#signField()}不能为空的情况下才生效
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年6月25日 上午9:32:07
	 * @return String[]
	 * @description
	 */
	public String[] signOptions() default {};
	
	/**
	 * 是否是需要传递的参数 默认否
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年9月29日 上午10:36:44
	 * @return boolean
	 * @description
	 */
	public boolean isParam() default false;
	
	/**
	 * 是否是加密的key
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年10月10日 上午11:07:40
	 * @return boolean
	 * @description
	 */
	public boolean isKey() default false;

}
