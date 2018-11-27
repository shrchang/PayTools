package com.pay.entity.hftx.payment.quick.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 快捷支付web版三合一结果
 * @ClassName Hftx_QuickPayMentWebResponseEntity
 * @author shrChang.Liu 206000代表成功
 * @Description TODO
 * @date 2018年10月1日 下午10:33:13
 *
 */
public class Hftx_QuickPayMentWebResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2477574049630202110L;

	/**
	 * 用户客户号
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 子账户号
	 */
	@JSONField(name = "acct_id")
	private String acctId;

	/**
	 * 本平台交易唯一标识号
	 */
	@JSONField(name = "platform_seq_id")
	private String platformSeqId;

	/**
	 * 开户银行代号
	 */
	@JSONField(name = "bank_id")
	private String bankId;

	/**
	 * 银行卡号
	 */
	@JSONField(name = "card_no")
	private String cardNo;

	/**
	 * 绑定银行卡ID
	 */
	@JSONField(name = "bind_card_id")
	private String bindCardId;

	/**
	 * 交易金额
	 */
	@JSONField(name = "trans_amt")
	private String transAmt;

	/**
	 * 借贷标记
	 */
	@JSONField(name = "dc_flag")
	private String dcFlag;

	/**
	 * 分账账户串
	 */
	@JSONField(name = "div_detail")
	private String divDetail;

	/**
	 * 分账客户号
	 */
	@JSONField(name = "divCustId")
	private String divCustId;

	/**
	 * 分账账户号
	 */
	@JSONField(name = "divAcctId")
	private String divAcctId;

	/**
	 * 分账金额
	 */
	@JSONField(name = "divAmt")
	private String divAmt;

	/**
	 * 是否冻结标志
	 */
	@JSONField(name = "divFreezeFg")
	private String divFreezeFg;

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
	 * 手续费子账户号
	 */
	@JSONField(name = "fee_acct_id")
	private String feeAcctId;

	/**
	 * 页面返回URL
	 */
	@JSONField(name = "ret_url")
	private String retUrl;

	/**
	 * 商户后台应答地址
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
	private String extension;

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getPlatformSeqId() {
		return platformSeqId;
	}

	public void setPlatformSeqId(String platformSeqId) {
		this.platformSeqId = platformSeqId;
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

	public String getBindCardId() {
		return bindCardId;
	}

	public void setBindCardId(String bindCardId) {
		this.bindCardId = bindCardId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getDcFlag() {
		return dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getDivDetail() {
		return divDetail;
	}

	public void setDivDetail(String divDetail) {
		this.divDetail = divDetail;
	}

	public String getDivCustId() {
		return divCustId;
	}

	public void setDivCustId(String divCustId) {
		this.divCustId = divCustId;
	}

	public String getDivAcctId() {
		return divAcctId;
	}

	public void setDivAcctId(String divAcctId) {
		this.divAcctId = divAcctId;
	}

	public String getDivAmt() {
		return divAmt;
	}

	public void setDivAmt(String divAmt) {
		this.divAmt = divAmt;
	}

	public String getDivFreezeFg() {
		return divFreezeFg;
	}

	public void setDivFreezeFg(String divFreezeFg) {
		this.divFreezeFg = divFreezeFg;
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

	@Override
	public boolean isSucess() {
		//因为206 208都是支付 只是对应的是web和app
		if("206000".equals(this.getRespCode()) || "208000".equals(this.getRespCode())){
			return true;
		}
		return false;
	}
}
