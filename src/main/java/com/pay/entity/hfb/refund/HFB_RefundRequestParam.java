package com.pay.entity.hfb.refund;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hfb.HFB_BasicRequestParam;

/**
 * 汇付宝退款请求实体
 * 
 * @ClassName HFB_RefundRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午6:05:21
 *
 */
public class HFB_RefundRequestParam extends HFB_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5653888679131305022L;

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String amount;// 退款金额 精确到分 单位应该是元

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String oriMerchantBillNo;// 原始订单号

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String refundMerchantBillNo;// 商户退单号

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String notifyUrl;// 异步通知地址

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOriMerchantBillNo() {
		return oriMerchantBillNo;
	}

	public void setOriMerchantBillNo(String oriMerchantBillNo) {
		this.oriMerchantBillNo = oriMerchantBillNo;
	}

	public String getRefundMerchantBillNo() {
		return refundMerchantBillNo;
	}

	public void setRefundMerchantBillNo(String refundMerchantBillNo) {
		this.refundMerchantBillNo = refundMerchantBillNo;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	@Override
	public void validation() throws Exception {
		
	}
}
