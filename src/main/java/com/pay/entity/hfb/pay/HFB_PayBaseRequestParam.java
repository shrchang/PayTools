package com.pay.entity.hfb.pay;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hfb.HFB_BasicRequestParam;

/**
 * 汇付宝的聚合支付参数
 * @ClassName HFB_PayBaseRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 上午10:48:01
 *
 */
public class HFB_PayBaseRequestParam extends HFB_BasicRequestParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8023582048036216156L;
	
	private String subMerchantId="";//子商户的id
	
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String requestTime;// 时间，默认格式是yyyyMMddHHmmss 必须传的
	
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String merchantBillNo = "";// 订单号
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String tradeType="";//支付的方式 需要列出枚举或者常量
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private Double payAmt=0d;//支付金额 单位是元
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String notifyUrl="";//异步通知的url 必填
	
	private String returnUrl="";//同步通知的URL
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String userIp="";//用户终端的ip地址，
	
	@PayRequestParamLabel(isRequired=true)
	private String goodsName="测试商品";//商品名称
	
	private String goodsDetail="";//商品的描述 当是微信付款的适合 必填格式：{“n”:”汇元网”, “id”:” http://www.9186.com/index.aspx”} n是网站名，id是网址
	
	private String goodsNote="";//支付说明
	
	private String qrCodeStatus="Y";//返回二维码跳转Y 返回支付界面N
	
	private String merchantSubNo="";//子商户号码
	
	private Integer level=0;//级别 默认是数字0-9 没有子商户不需要这个参数
	
	private String subOpenid="";//微信用户关注商家公众号的openid
	
	private String subAppid="";//微信公众平台基本配置中的AppID(应用ID)
	
	public String getMerchantBillNo() {
		return merchantBillNo;
	}

	public void setMerchantBillNo(String merchantBillNo) {
		this.merchantBillNo = merchantBillNo;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public Double getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getGoodsNote() {
		return goodsNote;
	}

	public void setGoodsNote(String goodsNote) {
		this.goodsNote = goodsNote;
	}

	public String getQrCodeStatus() {
		return qrCodeStatus;
	}

	public void setQrCodeStatus(String qrCodeStatus) {
		this.qrCodeStatus = qrCodeStatus;
	}

	public String getMerchantSubNo() {
		return merchantSubNo;
	}

	public void setMerchantSubNo(String merchantSubNo) {
		this.merchantSubNo = merchantSubNo;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSubOpenid() {
		return subOpenid;
	}

	public void setSubOpenid(String subOpenid) {
		this.subOpenid = subOpenid;
	}

	public String getSubAppid() {
		return subAppid;
	}

	public void setSubAppid(String subAppid) {
		this.subAppid = subAppid;
	}

	@Override
	public void validation() throws Exception {
		
	}
}
