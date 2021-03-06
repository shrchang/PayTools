package com.pay.entity.ypl.refund;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.ypl.YPL_BasicRequestParam;

/**
 * 易票联退款请求参数
 * 
 * @ClassName YPL_RefundQueryParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月27日 下午6:07:20
 *
 */
public class YPL_RefundRequestParam extends YPL_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6113103339831146366L;

	/**
	 * 退款的交易类型代码固定为refund
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_type")
	private String transType = "refund";

	/**
	 * 退款单对应的商家系统支付订单号。
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_trade_no")
	private String outTradeNo;

	/**
	 * 商户系统生成的退款单号。仅可以使用大小写英文字符、数字、下划线、中划线组成。（易票联根据商户编码和这个退款单号，保证其在网关系统的退款单唯一性）
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_refund_no")
	private String outRefundNo;

	/**
	 * 格式：元.角分，单位是元
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "total_amount")
	private String totalAmount;

	/**
	 * 格式：元.角分，单位是元。可以做部分退款，累计退款总金额不能超过订单总金额。
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "refund_amount")
	private String refundAmount;

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Override
	public void validate() throws Exception {

	}

}
