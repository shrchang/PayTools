package com.pay.exception;

/**
 * 支付异常信息定义
 * @ClassName PayException
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 上午9:56:41
 *
 */
public class PayException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2351613455344718699L;

	/**
	 * 默认构造函数
	 * @author shrChang.Liu
	 */
	public PayException() {
		super();
	}

	/**
	 * 带消息的构造函数
	 * @author shrChang.Liu
	 * @param msg 抛出错误消息
	 */
	public PayException(String msg) {
		super(msg);
	}
	
	/**
	 * 带消息与错误的构造函数
	 * @author shrChang.Liu
	 * @param msg 抛出错误消息
	 * @param cause 具体的异常
	 */
	public PayException(String msg,Throwable cause) {
		super(msg,cause);
	}

}
