package com.pay.constant;

import com.pay.enums.PayWay;

/**
 * 返回参数常量类
 * @ClassName RetCodeConstant
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午1:38:51
 *
 */
public class RetCodeConstant {
	
	/*********************************汇付宝的返回状态码********************************/
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 未知异常
	 */
	public static final Integer UNKNOW_CODE                  = -1;//未知异常
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 成功
	 */
	public static final Integer SUCCESS_CODE                 = 1000;//成功
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 交易已经完成
	 */
	public static final Integer TRADE_COMPLETED_CODE         = 1001;//交易已经完成
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 参数不合法
	 */
	public static final Integer PARAM_WRONGFUL_CODE          = 4001;//参数不合法
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 商户不存在
	 */
	public static final Integer MERCHANT_NOEXIST_CODE        = 3019;//商户不存在
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 产品校验失败
	 */
	public static final Integer ITEM_VALIDATE_FAILED_CODE    = 3002;//产品校验失败
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 产品禁用
	 */
	public static final Integer ITEM_DISABLE_CODE            = 4110;//产品禁用
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * ip校验失败
	 */
	public static final Integer IP_VALIDATE_FAILED_CODE      = 3003;//ip校验失败
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * /签名校验失败
	 */
	public static final Integer SIGN_VALIDATE_FAILED_CODE    = 3004;//签名校验失败
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 内部服务器错误
	 */
	public static final Integer SERVER_ERROR_CODE            = 1003;//内部服务器错误
	
	/**
	 * {@link PayWay#HFB} 汇付宝状态码
	 * 退款金额错误
	 */
	public static final Integer REFUND_SUM_ERROR_CODE        = 3016;//退款金额错误
	/*********************************汇付宝的返回状态码********************************/
	 
}
