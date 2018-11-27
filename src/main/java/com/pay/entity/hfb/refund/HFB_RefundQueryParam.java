package com.pay.entity.hfb.refund;

import com.pay.entity.hfb.HFB_BasicRequestParam;

/**
 * 汇付宝退款查询的参数
 * 
 * @ClassName HFB_RefundQueryParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 上午9:24:18
 *
 */
public class HFB_RefundQueryParam extends HFB_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8695476868382091891L;
	
	private String refundMerchantBillNo = "";// 退款单号

	public String getRefundMerchantBillNo() {
		return refundMerchantBillNo;
	}

	public void setRefundMerchantBillNo(String refundMerchantBillNo) {
		this.refundMerchantBillNo = refundMerchantBillNo;
	}

	@Override
	public void validation() throws Exception {
		
	}

}
