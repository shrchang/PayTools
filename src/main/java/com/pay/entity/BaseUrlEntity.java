package com.pay.entity;

import java.io.Serializable;

/**
 * 支付涉及的请求与返回基类
 * @ClassName PayBaseRequestParam
 * @author shrChang.Liu
 * @Description 用于支付请求的基础
 * @date 2018年6月21日 上午10:28:58
 *
 */
public abstract class BaseUrlEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8755864840166763861L;
	
//	@PayRequestParamLabel(isRequired=true)
//	@XmlField(name="sign")
//	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
//
//	/**
//	 * 每个不同的对应的签名也不一样，需要自己去实现对应的签名
//	 * @author shrChang.Liu
//	 * @param @return
//	 * @date 2018年6月21日下午2:49:02
//	 * @return String
//	 * @description
//	 */
//	public abstract String getSign();
//
//	public void setSign(String sign) {
//		this.sign = sign;
//	}
}
