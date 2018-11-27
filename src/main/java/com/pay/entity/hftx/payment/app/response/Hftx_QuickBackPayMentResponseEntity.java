package com.pay.entity.hftx.payment.app.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 快捷支付后台版响应结果 仅仅用于转账回滚
 * 
 * @ClassName Hftx_QuickPayMentResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:52:07
 *
 */
public class Hftx_QuickBackPayMentResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7442831612824473175L;

	/**
	 * 用户客户号
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 本平台交易唯一标识号
	 */
	@JSONField(name = "platform_seq_id")
	private String platformSeqId;
	
	/**
	 * 业务类型	
	 */
	@JSONField(name = "trans_type")
	private String transType;
	
	/**
	 * 充值类型	
	 */
	@JSONField(name = "recharge_type")
	private String rechargeType;

	/**
	 * 交易金额
	 */
	@JSONField(name = "trans_amt")
	private String transAmt;

	/**
	 * 入账客户号	
	 */
	@JSONField(name="in_cust_id")
	private String inCustId;

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
	@JSONField(name = "extension")
	private String extension;
	
	/**
	 * 银行卡号	
	 */
	@JSONField(name = "card_no")
	private String cardNo;
	
	/**
	 * 阶段标志	
	 */
	@JSONField(name = "step_flag")
	private String stepFlag;
	
	/**
	 * 业务请求流水	
	 */
	@JSONField(name = "biz_trans_id")
	private String bizTransId;

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

	public String getTransType() {
		return transType;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public String getInCustId() {
		return inCustId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getStepFlag() {
		return stepFlag;
	}

	public String getBizTransId() {
		return bizTransId;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public void setInCustId(String inCustId) {
		this.inCustId = inCustId;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setStepFlag(String stepFlag) {
		this.stepFlag = stepFlag;
	}

	public void setBizTransId(String bizTransId) {
		this.bizTransId = bizTransId;
	}

	@Override
	public boolean isSucess() {
		if("201000".equals(this.getRespCode())){
			return true;
		}
		return false;
	}

}
