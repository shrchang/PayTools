package com.pay.entity.hftx.user.bank.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;


/**
 * 快捷银行卡绑定 一定需要短信验证码
 * @ClassName Hftx_BindBankCard
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:15:24
 *
 */
public class Hftx_BindBankCardRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3603515528022176582L;

	/**
	 * 用户客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 开户银行代号 可输入具体见附件：开户银行代号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "bank_id")
	private String bankId;

	/**
	 * 借贷标记 0–借记，储蓄卡 1–贷记，信用卡
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "dc_flag")
	private String dcFlag = "0";

	/**
	 * 银行卡号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_no")
	private String cardNo;

	/**
	 * 银行预留手机号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_mobile")
	private String cardMobile;

	/**
	 * 银行卡开户省份 可选
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_prov")
	private String cardProv;

	/**
	 * 银行卡开户地区
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_area")
	private String cardArea;

	/**
	 * 短信验证码
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_area")
	private String smsCode;

	/**
	 * 商户后台应答地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	/**
	 * 页面返回URL 可选
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "ret_url")
	private String retUrl;

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

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getDcFlag() {
		return dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardMobile() {
		return cardMobile;
	}

	public void setCardMobile(String cardMobile) {
		this.cardMobile = cardMobile;
	}

	public String getCardProv() {
		return cardProv;
	}

	public void setCardProv(String cardProv) {
		this.cardProv = cardProv;
	}

	public String getCardArea() {
		return cardArea;
	}

	public void setCardArea(String cardArea) {
		this.cardArea = cardArea;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
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

	@Override
	public String getCmdId() {
		if(this.cmdId == null)
			this.cmdId = "103";
		return this.cmdId;
	}

}
