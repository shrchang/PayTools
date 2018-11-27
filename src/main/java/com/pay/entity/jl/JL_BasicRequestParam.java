package com.pay.entity.jl;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.constant.PayType;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.common.jl.SignEncryptDncryptUtil;
import com.pay.util.text.JsonUtil;

/**
 * 佳联微信支付基类(看着修改)
 * 
 * @ClassName JL_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月28日 下午3:59:23
 *
 */
public abstract class JL_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4495018484439750311L;

	/**
	 * 接入平台号 民生银行为接入平台分配的平台编号,与平台证书一一对应
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String platformId="A00012017050000000545";

	/**
	 * 民生商户号 实际交易商户的民生商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String merchantNo="M29002017090000029160";

	/**
	 * 支付类型 {@link PayType}
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String selectTradeType="API_WXQRCODE";

	/**
	 * 交易金额，以分为单位
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String amount="1.01";

	/**
	 * 商户订单内容，商品信息
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String orderInfo="统一下单DEMO-API_WXQRCODE";

	/**
	 * 商户流水号，商户须保证流水唯一，建议是商户平台号+8位日期+商户自定的订单号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String merchantSeq="A00012017050000000545T1615139874";

	/**
	 * 订单日期 yyyyMMdd
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String transDate="20180628";

	/**
	 * 订单时间 yyyyMMddHHmmssSSS
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String transTime="20180628161502538";

	/**
	 * 商户实现的接收异步通知的url地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String notifyUrl="https://wxpay.cmbc.com.cn/cmbcpaydemo/NoticeServlet?name=notice";

	/**
	 * 备注信息 反扫模式下该部分必输，填扫描客户二维码Base64后的值
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, signField = "selectTradeType", signOptions = {
			PayType.API_WXSCAN, PayType.API_ZFBSCAN })
	private String remark;

	/**
	 * 公众号支付API下，该部分必输，填子商户appId
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, signField = "selectTradeType", signOptions = PayType.H5_WXJSAPI)
	private String subAppId="ooEyIjpfMK7SWBfKSe7TM6MiePQE";

	/**
	 * 公众号支付API下，该部分必输，填子商户openId
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, signField = "selectTradeType", signOptions = PayType.H5_WXJSAPI)
	private String subOpenId="wx2b0ad640ef47938b";
	
	/**
	 * 这个是需要注入的参数
	 */
	private String contextJson;
	
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getSelectTradeType() {
		return selectTradeType;
	}

	public void setSelectTradeType(String selectTradeType) {
		this.selectTradeType = selectTradeType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getMerchantSeq() {
		return merchantSeq;
	}

	public void setMerchantSeq(String merchantSeq) {
		this.merchantSeq = merchantSeq;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getSubOpenId() {
		return subOpenId;
	}

	public void setSubOpenId(String subOpenId) {
		this.subOpenId = subOpenId;
	}
	
	@Transient
	public String getContextJson() {
		return contextJson;
	}

	public void setContextJson(String contextJson) {
		this.contextJson = contextJson;
	}

	/**
	 * 返回请求数据最后
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年6月28日 下午4:25:24
	 * @return String
	 * @description
	 */
	public String getRequestStringEntity(){
		String signContext =SignEncryptDncryptUtil.sign(getSign(), this.contextJson);
		String signText = SignEncryptDncryptUtil.encrypt(signContext);
		Map<String,String> map = new HashMap<String,String>();
		map.put("businessContext", signText);
		return JsonUtil.getJsonStrByObj(map);
	}

	public String getSign() {
		if(this.sign == null && this.contextJson != null){
			//暂时默认是不包含空的情况
			this.sign = SignEncryptDncryptUtil.getSign(this.contextJson); 
		}
		return sign;
	}
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/**
	 * 验证
	 * @author shrChang.Liu
	 * @date 2018年6月28日 下午4:38:22
	 * @return void
	 * @description
	 */
	public abstract void validate();
}
