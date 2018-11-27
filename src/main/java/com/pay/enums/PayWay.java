package com.pay.enums;

/**
 * 支付方式 汇付宝、佳联、poco、易票联
 * @ClassName PayWay
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月3日 上午9:57:13
 *
 */
public enum PayWay {
	
	/**
	 * 汇付宝
	 */
	HFB("hfb"),
	/**
	 * 佳联微信 乐有银
	 */
	JL("jl"),
	/**
	 * poco
	 */
	POCO("poco"),
	/**
	 * 易票联
	 */
	YPL("ypl"),
	
	/**
	 * 青云支付
	 */
	QCLOUD("qincloud"),
	
	/**
	 * 汇潮支付
	 */
	HUICHAO("huichao"),
	
	/**
	 * 中钢银通
	 */
	ZGYT("zgyt"),
	
	/**
	 * 海豚支付
	 */
	KCLOUD("kancloud");
	
	private String payWay;

	PayWay(String payWay) {
        this.payWay = payWay;
    }

    @Override
    public String toString() {
        return payWay;
    }

}
