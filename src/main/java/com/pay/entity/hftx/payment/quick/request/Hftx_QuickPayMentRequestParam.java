package com.pay.entity.hftx.payment.quick.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;
import com.pay.util.text.JsonUtil;

/**
 * 快捷支付请求实体
 * 
 * @ClassName Hftx_QuickPayMentRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:26:41
 *
 */
public class Hftx_QuickPayMentRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714343249469147028L;

	/**
	 * 用户客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 用户金额 金额格式是###.00
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_amt")
	private String transAmt;

	/**
	 * 绑定银行卡ID
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bind_card_id")
	private String bindCardId;

	/**
	 * 短信验证码
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "sms_code")
	private String smsCode;

	/**
	 * 这个应该默认就是传商户的信息进去 因为默认都要转给商户的 分账账户串 入账客户传，json格式：
	 * [{‘divCustId’:‘6666000000025350’,’divAcctId’:‘78276’,’divAmt’:‘50.00’,’
	 * divFreezeFg’:‘00’},{‘divCustId’:‘6666000000025666’,’divAcctId’:‘78841’,’
	 * divAmt’:‘50.00’,’divFreezeFg’:‘01’}]
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "div_detail")
	private String divDetail;

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
	
	/**
	 * 商户的账户id 用于设置divDetail
	 */
	@PayRequestParamLabel(isRequired=true)
	private String merAcctId;

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

	public String getBindCardId() {
		return bindCardId;
	}

	public void setBindCardId(String bindCardId) {
		this.bindCardId = bindCardId;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getDivDetail() {
		if(divDetail == null){
			Map<String,String> param = new HashMap<String,String>();
			param.put("divCustId", this.getMerCustId());
			param.put("divAcctId", this.merAcctId);
			param.put("divAmt", this.transAmt);
			param.put("divFreezeFg", "00");
			List<Object> objs = new ArrayList<Object>();
			objs.add(param);
			this.divDetail = JsonUtil.getJsonStrByObj(objs);
		}
		return divDetail;
	}

	public void setDivDetail(String divDetail) {
		this.divDetail = divDetail;
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

	public String getMerAcctId() {
		return merAcctId;
	}

	public void setMerAcctId(String merAcctId) {
		this.merAcctId = merAcctId;
	}

	@Override
	public String getCmdId() {
		if (this.cmdId == null)
			this.cmdId = "201";
		return this.cmdId;
	}

}
