package com.pay.entity.zgyt.pay;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 异步通知的body实体
 * @ClassName NotifyResponseBody
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 下午2:56:39
 *
 */
public class NotifyResponseBody implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6538484365500532540L;

	/**
	 * 随即串
	 */
	@JSONField(name="nonce_str")
	private String nonceStr;
	
	/**
	 * 处理结果只有=0是成功 其余失败
	 */
	@JSONField(name="result_code")
	private String resultCode;
	
	/**
	 * 失败的编码
	 */
	@JSONField(name="err_code")
	private String errCode;
	
	/**
	 * 失败描述
	 */
	@JSONField(name="err_code_des")
	private String errCodeDes;
	
	/**
	 * SUCCESS 成功 NOTPAY 未支付  FAILD 失败 REFUND 转入退款 CLOSED订单已关闭
	 */
	@JSONField(name="pay_status")
	private String payStatus;
	
	/**
	 * 支付状态信息
	 */
	@JSONField(name="pay_status_info")
	private String payStatusInfo;
	
	/**
	 * 支付方式
	 */
	@JSONField(name="payment_type")
	private String paymentType;
	
	/**
	 * 订单号
	 */
	@JSONField(name="out_trade_no")
	private String outTradeNo;
	
	/**
	 * 流水号
	 */
	@JSONField(name="order_no")
	private String orderNo;
	
	/**
	 * 币种
	 */
	@JSONField(name="fee_type")
	private String feeType;
	
	/**
	 * 金额分
	 */
	@JSONField(name="total_fee")
	private String totalFee;
	
	/**
	 * 支付金额
	 */
	@JSONField(name="paid_fee")
	private String paidFee;
	
	/**
	 * 现金券支付金额，单位到分
	 */
	@JSONField(name="coupon_fee")
	private String couponFee;
	
	/**
	 * 商品附加信息
	 */
	@JSONField(name="attach")
	private String attach;
	
	/**
	 * 支付完成时间 yyyyMMddHHmmss
	 */
	@JSONField(name="time_end")
	private String timeEnd;
	
	/**
	 * 用户标识,用户在服务商 appid 下的唯一标识
	 */
	@JSONField(name="openid")
	private String openid;
	
	/**
	 * 用户是否关注子公众账号，Y-关注，N-未关注
	 */
	@JSONField(name="is_subscribe")
	private String isSubscribe;
	
	/**
	 * 付款银行类型
	 */
	@JSONField(name="bank_type")
	private String bankType;
	
	/**
	 * 收单机构号(微信或支付宝交易号)
	 */
	@JSONField(name="transaction_id")
	private String transactionId;
	
	/**
	 * 付款银行订单号，若为微信支付则为空
	 */
	@JSONField(name="bank_bill_no")
	private String bankBillNo;
	
	/**
	 * 商户公众号 appid
	 */
	@JSONField(name="sub_appid")
	private String subAppid;
	
	/**
	 * 是否关注子商户公众账号，Y-关注，N-未关注
	 */
	@JSONField(name="sub_is_subscribe")
	private String subIsSubscribe;
	
	/**
	 * 用户在商户公众号 appid 下的唯一标识
	 */
	@JSONField(name="sub_openid")
	private String subOpenid;
	
	/**
	 * 扩展字段，类型为map格式json串
	 */
	@JSONField(name="ext")
	private String ext;

	public String getNonceStr() {
		return nonceStr;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public String getPayStatusInfo() {
		return payStatusInfo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public String getPaidFee() {
		return paidFee;
	}

	public String getCouponFee() {
		return couponFee;
	}

	public String getAttach() {
		return attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public String getOpenid() {
		return openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public String getBankType() {
		return bankType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getBankBillNo() {
		return bankBillNo;
	}

	public String getSubAppid() {
		return subAppid;
	}

	public String getSubIsSubscribe() {
		return subIsSubscribe;
	}

	public String getSubOpenid() {
		return subOpenid;
	}

	public String getExt() {
		return ext;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public void setPayStatusInfo(String payStatusInfo) {
		this.payStatusInfo = payStatusInfo;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public void setPaidFee(String paidFee) {
		this.paidFee = paidFee;
	}

	public void setCouponFee(String couponFee) {
		this.couponFee = couponFee;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setBankBillNo(String bankBillNo) {
		this.bankBillNo = bankBillNo;
	}

	public void setSubAppid(String subAppid) {
		this.subAppid = subAppid;
	}

	public void setSubIsSubscribe(String subIsSubscribe) {
		this.subIsSubscribe = subIsSubscribe;
	}

	public void setSubOpenid(String subOpenid) {
		this.subOpenid = subOpenid;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}
