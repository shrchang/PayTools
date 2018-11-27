package com.pay.entity.hfb.order;

import com.pay.entity.hfb.HFB_BasicResponeEntity;

/**
 * 订单返回信息
 * @ClassName HFB_OrderResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午5:42:21
 *
 */
public class HFB_OrderResponseEntity extends HFB_BasicResponeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1278365688387813187L;

	private String subMerchantId;// 子商户id
	
	private String merchantBillNo;//商户订单号

	private Double payAmt;// 金额
	
	private String remark;//附加数据

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public Double getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}

	public String getMerchantBillNo() {
		return merchantBillNo;
	}

	public void setMerchantBillNo(String merchantBillNo) {
		this.merchantBillNo = merchantBillNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
