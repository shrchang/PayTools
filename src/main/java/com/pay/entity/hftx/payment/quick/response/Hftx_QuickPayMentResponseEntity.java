package com.pay.entity.hftx.payment.quick.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 快捷支付响应结果
 * 
 * @ClassName Hftx_QuickPayMentResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:52:07
 *
 */
public class Hftx_QuickPayMentResponseEntity extends BasicResponseEntity {

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
	 * 交易金额
	 */
	@JSONField(name = "trans_amt")
	private String transAmt;

	/**
	 * 绑定银行卡ID
	 */
	@JSONField(name = "bind_card_id")
	private String bindCardId;

	/**
	 * 短信验证码
	 */
	@JSONField(name = "sms_code")
	private String smsCode;

	/**
	 * 分账账户串
	 */
	@JSONField(name = "div_detail")
	private String divDetail;

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
	@JSONField(name = "extension")
	private String extension;

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
		return divDetail;
	}

	public void setDivDetail(String divDetail) {
		this.divDetail = divDetail;
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
		if("201000".equals(this.getRespCode())){
			return true;
		}
		return false;
	}

}
