package com.pay.entity.hftx.payment.quick.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 快捷支付WEb版三合一 异步的通知
 * @ClassName Hftx_QuickPayMentWebRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午10:33:38
 *
 */
public class Hftx_QuickPayMentWebRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8551472403527390804L;

	/**
	 * 用户客户号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 交易金额 金额格式是###.00
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_amt")
	private String transAmt;

	/**
	 * 分账账户串
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "div_detail")
	private String divDetail;

	/**
	 * 入账客户号 默认商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_cust_id")
	private String inCustId;

	/**
	 * 入账账户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_acct_id")
	private String inAcctId;

	/**
	 * 设备号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "device_info")
	private String deviceInfo;

	/**
	 * IP地址
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "ip_addr")
	private String ipAddr;

	/**
	 * 经纬度
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "location_val")
	private String locationVal;

	/**
	 * 页面返回URL
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "ret_url")
	private String retUrl;

	/**
	 * 商户后台应答地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	/**
	 * 商户私有域
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "mer_priv")
	private String merPriv;

	/**
	 * 扩展域
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "extension")
	private String extension;

	/**
	 * 二级商户号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "secondary_mer_id")
	private String secondaryMerId;

	/**
	 * 付款方交易终端类型
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "payer_term_type")
	private String payerTermType;

	/**
	 * 付款方交易终端编码
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "payer_term_no")
	private String payerTermNo;

	/**
	 * 收款方交易终端类型
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "payee_term_type")
	private String payeeTermType;

	/**
	 * 收款方交易终端编码
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "payee_term_no")
	private String payeeTermNo;

	/**
	 * 商品简称
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "goods_short_name")
	private String goodsShortName;

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getDivDetail() {
		return divDetail;
	}

	public void setDivDetail(String divDetail) {
		this.divDetail = divDetail;
	}

	public String getInCustId() {
		return inCustId;
	}

	public void setInCustId(String inCustId) {
		this.inCustId = inCustId;
	}

	public String getInAcctId() {
		return inAcctId;
	}

	public void setInAcctId(String inAcctId) {
		this.inAcctId = inAcctId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getLocationVal() {
		return locationVal;
	}

	public void setLocationVal(String locationVal) {
		this.locationVal = locationVal;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getSecondaryMerId() {
		return secondaryMerId;
	}

	public void setSecondaryMerId(String secondaryMerId) {
		this.secondaryMerId = secondaryMerId;
	}

	public String getPayerTermType() {
		return payerTermType;
	}

	public void setPayerTermType(String payerTermType) {
		this.payerTermType = payerTermType;
	}

	public String getPayerTermNo() {
		return payerTermNo;
	}

	public void setPayerTermNo(String payerTermNo) {
		this.payerTermNo = payerTermNo;
	}

	public String getPayeeTermType() {
		return payeeTermType;
	}

	public void setPayeeTermType(String payeeTermType) {
		this.payeeTermType = payeeTermType;
	}

	public String getPayeeTermNo() {
		return payeeTermNo;
	}

	public void setPayeeTermNo(String payeeTermNo) {
		this.payeeTermNo = payeeTermNo;
	}

	public String getGoodsShortName() {
		return goodsShortName;
	}

	public void setGoodsShortName(String goodsShortName) {
		this.goodsShortName = goodsShortName;
	}

	@Override
	public String getCmdId() {
		if (this.cmdId == null)
			this.cmdId = "206";
		return this.cmdId;
	}

}
