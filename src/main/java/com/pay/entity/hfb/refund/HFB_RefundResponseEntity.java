package com.pay.entity.hfb.refund;

import com.pay.entity.hfb.HFB_BasicResponeEntity;

/**
 * 汇付宝退款请求返回数据
 * @ClassName HFB_RefundResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 上午9:52:51
 *
 */
public class HFB_RefundResponseEntity extends HFB_BasicResponeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824947865848765575L;

	private String version;// 版本号

	private String subMerchantId;// 子商户号

	private String oriMerchantBillNo;// 原支付订单

	private String refundMerchantBillNo;// 退单号

	private String refundAmount;// 退款金额

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
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

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
}
