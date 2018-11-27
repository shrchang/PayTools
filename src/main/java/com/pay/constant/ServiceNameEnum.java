package com.pay.constant;

/**
 * 接口参数枚举 中钢银通专用
 * @ClassName ServiceNameEnum
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 上午11:10:33
 *
 */
public enum ServiceNameEnum {

	/**
	 * 支付
	 */
	SUBMITORDER("submit.order"),
	/**
	 * 二维码订单信息查询
	 */
	QUERYQRCODE("query.qrcode"),
	/**
	 * 优惠信息查询
	 */
	QUERYSALE("query.sale"),
	/**
	 * 付款
	 */
	ORDERPAYMENT("order.payment"),
	/**
	 * 消费
	 */
	CONSUMEORDER("consume.order"),
	/**
	 * 二维码申请
	 */
	CODEAPPLY("code.apply"),
	/**
	 * 附加处理通知
	 */
	NOTIFYADDN("notify.addn"),
	
	/**
	 * 附加处理结果
	 */
	RECEIVEADDN("receive.addn"),
	
	/**
	 * 支付结果查询
	 */
	QUERYPAY("query.pay"),
	
	/**
	 * 支付结果通知
	 */
	NOTIFYPAY("notify.pay"),
	
	/**
	 * 退款
	 */
	REFUNDPAY("refund.pay"),
	
	/**
	 * 退款查询
	 */
	QUERYREFUND("query.refund"),
	
	/**
	 * 支付列表查询
	 */
	PAYORDER("pay.order"),
	
	/**
	 * 退款列表查询
	 */
	REFUNDORDER("refund.order");
	
	String name;
	ServiceNameEnum(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
