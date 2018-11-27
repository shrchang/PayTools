package com.pay.constant;

/**
 * 中钢银通支付类型枚举
 * @ClassName PaymentTypeEnum
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 上午11:40:30
 *
 */
public enum PaymentTypeEnum {
	
	/**
	 * 微信扫码支付-线下
	 */
	PAYWXNATIVE("pay-wx-native"),
	/**
	 * 微信扫码支付-线上
	 */
	PAYWXNATIVEONLINE("pay-wx-native-online"),
	/**
	 * 微信公众号支付-线下
	 */
	PAYWXSERVICE("pay-wx-service"),
	
	/**
	 * 微信公众号支付-线上
	 */
	PAYWXSERVICEONLINE("pay-wx-service-online");
	
	String name;
	PaymentTypeEnum(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
