package com.pay.entity.ypl.order;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.ypl.YPL_BasicRequestParam;

/**
 * 易票连查询参数
 * 
 * @ClassName YPL_OrderRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午10:21:20
 *
 */
public class YPL_OrderRequestParam extends YPL_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3737076749488301494L;

	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_trade_no")
	private String outTradeNo = "1516185831821";// 订单号

	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_type")
	private String transType = "query";// 查询方式

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

	@Override
	public void validate() throws Exception {
		return;
	}
}
