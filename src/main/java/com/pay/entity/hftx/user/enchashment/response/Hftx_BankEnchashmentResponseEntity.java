package com.pay.entity.hftx.user.enchashment.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 取现的响应结果
 * 
 * @ClassName Hftx_BankEnchashmentResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:36:52
 *
 */
public class Hftx_BankEnchashmentResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4629121445894768828L;

	/**
	 * 用户id
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 交易状态
	 */
	@JSONField(name = "trans_stat")
	private String transStat;

	/**
	 * 流水号
	 */
	@JSONField(name = "platform_seq_id")
	private String platformSeqId;

	/**
	 * 交易金额
	 */
	@JSONField(name = "trans_amt")
	private String transAmt;

	/**
	 * 实际到账金额
	 */
	@JSONField(name = "real_trans_amt")
	private String realTransAmt;

	/**
	 * 取现绑定银行卡ID
	 */
	@JSONField(name = "cash_bind_card_id")
	private String cashBindCardId;

	/**
	 * 取现子账户id
	 */
	@JSONField(name = "cash_acct_id")
	private String cashAcctId;

	/**
	 * 开户银行代号
	 */
	@JSONField(name = "bank_id")
	private String bankId;

	/**
	 * 手续费金额
	 */
	@JSONField(name = "fee_amt")
	private String feeAmt;

	/**
	 * 手续费扣款客户号
	 */
	@JSONField(name = "fee_cust_id")
	private String feeCustId;

	/**
	 * 手续费扣款子账户号
	 */
	@JSONField(name = "fee_acct_id")
	private String feeAcctId;

	/**
	 * 后台通知地址
	 */
	@JSONField(name = "bg_ret_url")
	private String bgRetUrl;

	/**
	 * 商户私有域
	 */
	@JSONField(name = "mer_priv")
	private String merPriv;

	/**
	 * 扩展域
	 */
	@JSONField(name = "extension")
	private String extension;

	public String getTransStat() {
		return transStat;
	}

	public void setTransStat(String transStat) {
		this.transStat = transStat;
	}

	public String getCashAcctId() {
		return cashAcctId;
	}

	public void setCashAcctId(String cashAcctId) {
		this.cashAcctId = cashAcctId;
	}

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getPlatformSeqId() {
		return platformSeqId;
	}

	public void setPlatformSeqId(String platformSeqId) {
		this.platformSeqId = platformSeqId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getRealTransAmt() {
		return realTransAmt;
	}

	public void setRealTransAmt(String realTransAmt) {
		this.realTransAmt = realTransAmt;
	}

	public String getCashBindCardId() {
		return cashBindCardId;
	}

	public void setCashBindCardId(String cashBindCardId) {
		this.cashBindCardId = cashBindCardId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
	}

	public String getFeeCustId() {
		return feeCustId;
	}

	public void setFeeCustId(String feeCustId) {
		this.feeCustId = feeCustId;
	}

	public String getFeeAcctId() {
		return feeAcctId;
	}

	public void setFeeAcctId(String feeAcctId) {
		this.feeAcctId = feeAcctId;
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
	public boolean isSucess() {
		if ("202000".equals(this.getRespCode()))
			return true;
		return false;
	}
	
	public boolean isDoing(){
		if("202002".equals(this.getRespCode()))
			return true;
		return false;
	}
}
