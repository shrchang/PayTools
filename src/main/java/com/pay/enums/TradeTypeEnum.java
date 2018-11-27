package com.pay.enums;


/**
 * 支付方式枚举
 * @ClassName TradeTypeEnum
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午1:54:01
 *
 */
public enum TradeTypeEnum {
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 微信扫码 
	 */
	HFB_WEIXIN_QR("weixin_qr","微信扫码"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 微信公众号
	 */
	HFB_WEIXIN_PUB("weixin_pub","微信公众号"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 微信H5
	 */
	HFB_WEIXIN_H5("weixin_h5","微信H5"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 支付宝扫码
	 */
	HFB_ALIPAY_QR("alipay_qr","支付宝扫码"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 支付宝wap
	 */
	HFB_ALIPAY_WAP("alipay_wap","支付宝wap"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * qq钱包
	 */
	HFB_QQ_QR("qq_qr","qq钱包"),
	
	/**
	 * {@link PayWay#HFB} 汇付宝支付类型<br>
	 * 京东钱包
	 */
	HFB_JD_QR("jd_qr","京东钱包");
	
	private String code;
	private String value;
	private TradeTypeEnum(String code,String value){
		this.code = code;
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return getCode();
	}

}
