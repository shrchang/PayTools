package com.pay.entity.hftx.user.bank.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 绑定取现卡
 * @ClassName Hftx_BindBankCashCardRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月8日 下午5:48:06
 *
 */
public class Hftx_BindBankCashCardRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1002569708625492815L;

	/**
	 * 用户唯一标识号	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 银行代号	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bank_id")
	private String bankId;

	/**
	 * 银行卡号	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_no")
	private String cardNo;

	/**
	 * 借贷标记	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "dc_flag")
	private String dcFlag = "0";

	/**
	 * 银行卡开户省份	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_prov")
	private String cardProv;

	/**
	 * 银行卡开户地区	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_area")
	private String cardArea;

	/**
	 * 后台返回地址	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	@PayRequestParamLabel(isRequired = false, isSign = true, name = "mer_priv")
	private String merPriv;

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

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getDcFlag() {
		return dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
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

	@Override
	public String getCmdId() {
		return "104";
	}

}
