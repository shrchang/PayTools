package com.pay.entity.hftx.user.manage.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 个人用户/个体户开户的响应结果
 * @ClassName Hftx_PersonOpenResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 上午10:01:55
 *
 */
public class Hftx_PersonOpenResponseEntity extends BasicResponseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 645204417008603592L;

	/**
	 * 用户客户号	
	 */
	@JSONField(name="user_cust_id")
	private String userCustId;
	
	/**
	 * 子账户号	
	 */
	@JSONField(name="acct_id")
	private String acctId;
	
	/**
	 * 手机号	
	 */
	@JSONField(name="user_mobile")
	private String userMobile;
	
	/**
	 * 本平台交易唯一标识号	
	 */
	@JSONField(name="platform_seq_id")
	private String platformSeqId;
	
	/**
	 * 手续费金额	
	 */
	@JSONField(name="fee_amt")
	private String feeAmt;
	
	/**
	 * 手续费子账户号	
	 */
	@JSONField(name="fee_acct_id")
	private String feeAcctId;
	
	/**
	 * 商户后台应答地址	
	 */
	@JSONField(name="bg_ret_url")
	private String bgRetUrl;
	
	/**
	 * 商户私有域	
	 */
	@JSONField(name="mer_priv")
	private String merPriv;
	
	/**
	 * 扩展域	
	 */
	@JSONField(name="extension")
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

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getPlatformSeqId() {
		return platformSeqId;
	}

	public void setPlatformSeqId(String platformSeqId) {
		this.platformSeqId = platformSeqId;
	}

	public String getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
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
		if("101000".equals(this.getRespCode()))
			return true;
		return false;
	}
	
}
