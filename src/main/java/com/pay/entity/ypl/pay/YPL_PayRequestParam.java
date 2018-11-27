package com.pay.entity.ypl.pay;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.constant.PayType;
import com.pay.entity.ypl.YPL_BasicRequestParam;

/**
 * 易票联支付请求类 api提示如果字段为空则不参与签名
 * 
 * @ClassName YPL_PayBasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月25日 上午9:21:23
 *
 */
public class YPL_PayRequestParam extends YPL_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1912928224424174736L;
	
	/**
	 * 商品名称 base64编码
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "base64_memo")
	private String base64Memo;

	/**
	 * 银行直连参数 {@link PayType}
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "pay_id")
	private String payId;

	/**
	 * 超时时间
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "time_out")
	private String timeOut;

	/**
	 * 支付金额 到分
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "total_fee")
	private String totalFee;

	/**
	 * 选填参数 网关类型 支付接口收单类型，分web网页版和手机wap版 0：网页版（默认） 1：手机版
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "store_oi_type")
	private String storeOiType = "0";

	/**
	 * 公众账号appid
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "sub_appid", signField = "payId", signOptions = PayType.WXPAY)
	private String subAppid;

	/**
	 * 用户openid
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "sub_openid", signField = "payId", signOptions = PayType.WXPAY)
	private String subOpenid;

	/**
	 * 条码支付授权码，例如支付宝的条码支付、微信的刷卡支付
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "auth_code", signField = "payId", signOptions = {
			PayType.WXH5PAY, PayType.WXMICRO, PayType.ALIPAYPREPAY, PayType.ALIPAYQRCODE, PayType.ALIPAYBARCODE })
	private String authCode;

	/**
	 * 货币代码 人民币：RMB 港币：HKD 美元：USD
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "currency_type")
	private String currencyType;

	/**
	 * 用于接收易票联后台发送的支付结果通知的URL
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "notify_url")
	private String notifyUrl;

	/**
	 * 支付网关通过商户编码和这个订单号，保证网关系统的订单唯一性
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_trade_no")
	private String outTradeNo;

	/**
	 * 二维码失效时间，需大于60秒。
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "time_limit")
	private String timeLimit;

	/**
	 * 交易完成后跳转的URL，需给绝对路径
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "return_url")
	private String returnUrl;

	/**
	 * 订单生成的机器IP，指用户浏览器端IP，不是商户服务器IP
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "order_create_ip")
	private String orderCreateIp;

	/**
	 * 公众号支付时，为必填，并且固定填写1
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "is_raw", signField = "payId", signOptions = PayType.WXPAY)
	private String isRaw;

	/**
	 * 支持卡类型，0：借记卡 1：信用卡，当银行直连编码参数pay_id传网银直连编码（如：gonghang）时，该参数必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_type", signField = "payId", signOptions = {
			PayType.ABC, PayType.ABCENS, PayType.BOB, PayType.BOC, PayType.BOCENS, PayType.BOCOM, PayType.CBC,
			PayType.CBCENS, PayType.CCB, PayType.CEB, PayType.CGB, PayType.CIB, PayType.CMB, PayType.CMBC,
			PayType.CMBENS, PayType.HKBEA, PayType.HXB, PayType.ICBC, PayType.ICBCENS, PayType.NJCB, PayType.PSBC,
			PayType.SDB, PayType.SPDB, PayType.SHRCB })
	private String cardType;

	/**
	 * 部分银行（如：工行）支持卡号传递到银行网银支付页面，如本字段填上，卡号将会显示在网银卡号输入框 当前不知道
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "merchant_account")
	private String merchantAccount;

	public String getBase64Memo() {
		return base64Memo;
	}

	public void setBase64Memo(String base64Memo) {
		this.base64Memo = base64Memo;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getStoreOiType() {
		return storeOiType;
	}

	public void setStoreOiType(String storeOiType) {
		this.storeOiType = storeOiType;
	}

	public String getSubAppid() {
		return subAppid;
	}

	public void setSubAppid(String subAppid) {
		this.subAppid = subAppid;
	}

	public String getSubOpenid() {
		return subOpenid;
	}

	public void setSubOpenid(String subOpenid) {
		this.subOpenid = subOpenid;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getOrderCreateIp() {
		return orderCreateIp;
	}

	public void setOrderCreateIp(String orderCreateIp) {
		this.orderCreateIp = orderCreateIp;
	}

	public String getIsRaw() {
		return isRaw;
	}

	public void setIsRaw(String isRaw) {
		this.isRaw = isRaw;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getMerchantAccount() {
		return merchantAccount;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}

	@Override
	public void validate() throws Exception {
		// 这是验证参数是否正确，暂时未实现
	}

}
