package com.pay.entity.hfb.refund;

import com.pay.entity.hfb.HFB_BasicResponeEntity;

/**
 * 汇付宝退款返回的数据
 * 
 * @ClassName HFB_RefundQueryResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 上午9:26:19
 *
 */
public class HFB_RefundQueryResponseEntity extends HFB_BasicResponeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222122626982361259L;

	private String subMerchantId;// 自商户id

	private String refundMerchantBillNo;// 商户退单号

	private String refundAmt;// 支付金额

	private String remark;// 附加数据

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public String getRefundMerchantBillNo() {
		return refundMerchantBillNo;
	}

	public void setRefundMerchantBillNo(String refundMerchantBillNo) {
		this.refundMerchantBillNo = refundMerchantBillNo;
	}

	public String getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(String refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
