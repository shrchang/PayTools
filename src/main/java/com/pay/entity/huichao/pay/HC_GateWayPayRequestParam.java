package com.pay.entity.huichao.pay;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.huichao.BasicRequestParam;

/**
 * 汇潮支付请求参数
 * 
 * @ClassName HC_PayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月3日 下午3:57:53
 *
 */
public class HC_GateWayPayRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1443336115018138734L;

	/**
	 * 商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String MerNo = "45627";

	/**
	 * 订单号 N19245025450245
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String BillNo = "N1234546";

	/**
	 * 该笔订单的资金总额，单位为：RMB。取值范围[1，1000000.00]精确到小数点后两位。
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String Amount = "0.01";

	/**
	 * 支付完成后web页面跳转显示支付结果
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String ReturnURL = "http://www.baidu.com";

	/**
	 * 汇潮服务器主动异步通知商户网站指定的路径
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String AdviceURL = "http://www.baidu.com";

	/**
	 * 交易时间，格式：YYYYMMDDHHMMSS
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String OrderTime = "201809031605";

	/**
	 * 银行代码(见银行编码表)，可为空传递对应编码表中的值，直接跳转到对应的银行网银界面
	 */
	@PayRequestParamLabel(isSign = true)
	private String defaultBankNumber;

	/**
	 * 支付方式，联系业务员开通 B2CCredit：B2C信用卡 B2CDebit: B2C借记卡 noCard： 银联快捷支付 quickPay：
	 * 快捷支付 B2B：企业网银支付
	 */
	@PayRequestParamLabel(isSign = true)
	private String payType;

	/**
	 * 备注
	 */
	@PayRequestParamLabel(isSign = true)
	private String Remark;

	/**
	 * 物品信息
	 */
	@PayRequestParamLabel(isSign = true)
	private String products;

	public String getMerNo() {
		return MerNo;
	}

	public void setMerNo(String merNo) {
		MerNo = merNo;
	}

	public String getBillNo() {
		return BillNo;
	}

	public void setBillNo(String billNo) {
		BillNo = billNo;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getReturnURL() {
		return ReturnURL;
	}

	public void setReturnURL(String returnURL) {
		ReturnURL = returnURL;
	}

	public String getAdviceURL() {
		return AdviceURL;
	}

	public void setAdviceURL(String adviceURL) {
		AdviceURL = adviceURL;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getDefaultBankNumber() {
		return defaultBankNumber;
	}

	public void setDefaultBankNumber(String defaultBankNumber) {
		this.defaultBankNumber = defaultBankNumber;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	@Override
	public void validate() throws Exception {
		System.out.println("验证参数成功！");
	}
}
