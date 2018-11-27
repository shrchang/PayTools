package com.pay.entity.hftx.user.enchashment.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 银行取现 预估是异步的
 * 
 * @ClassName Hftx_BankEnchashmentRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:05:57
 *
 */
public class Hftx_BankEnchashmentRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -439297965502972589L;

	/**
	 * 用户客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 交易金额
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_amt")
	private String transAmt;

	/**
	 * 取现绑定银行卡ID
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "cash_bind_card_id")
	private String cashBindCardId;

	/**
	 * 用户商户指定取现手续费的收取对象，优先级别高于商户配置的收取对象 02050200：向商户收取 02050201：向用户收取 空白默认为向商户收取
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "fee_obj")
	private String feeObj;

	/**
	 * 向商户收取必填 向用户收取可忽略 手续费收取子账户
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "fee_acct_id")
	private String feeAcctId;

	/**
	 * 取现方式 02030000：T+0取现；02030010：T+1取现
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "cash_type")
	private String cashType = "02030000";

	/**
	 * 商户后台应答地址
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

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getCashBindCardId() {
		return cashBindCardId;
	}

	public void setCashBindCardId(String cashBindCardId) {
		this.cashBindCardId = cashBindCardId;
	}

	public String getFeeObj() {
		return feeObj;
	}

	public void setFeeObj(String feeObj) {
		this.feeObj = feeObj;
	}

	public String getFeeAcctId() {
		return feeAcctId;
	}

	public void setFeeAcctId(String feeAcctId) {
		this.feeAcctId = feeAcctId;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
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
		if (this.cmdId != null)
			this.cmdId = "202";
		return this.cmdId;
	}

}
