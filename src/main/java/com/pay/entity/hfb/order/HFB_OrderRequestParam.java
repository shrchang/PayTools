package com.pay.entity.hfb.order;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hfb.HFB_BasicRequestParam;
import com.pay.util.DateUtil;

/**
 * 汇付宝查询订单的请求参数
 * 
 * @ClassName HFB_OrderRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午6:00:51
 *
 */
public class HFB_OrderRequestParam extends HFB_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1408421950334185665L;

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String requestTime = DateUtil.getStrByNow("yyyyMMddHHmmss");// 时间，默认格式是yyyyMMddHHmmss

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String merchantBillNo = "";// 订单号

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getMerchantBillNo() {
		return merchantBillNo;
	}

	public void setMerchantBillNo(String merchantBillNo) {
		this.merchantBillNo = merchantBillNo;
	}

	@Override
	public void validation() throws Exception {
		
	}

}
