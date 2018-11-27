package com.pay.entity.hftx.user.transfer.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 转账的响应
 * @ClassName Hftx_TransferResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午10:29:50
 *
 */
public class Hftx_TransferResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8310062592783187916L;

	/**
	 * 出账客户号
	 */
	@JSONField(name = "out_cust_id")
	private String outCustId;

	/**
	 * 出账子账户号
	 */
	@JSONField(name = "out_acct_id")
	private String outAcctId;

	/**
	 * 入账客户号
	 */
	@JSONField(name = "in_cust_id")
	private String inCustId;

	/**
	 * 入账子账户号
	 */
	@JSONField(name = "in_acct_id")
	private String inAcctId;

	/**
	 * 转账金额
	 */
	@JSONField(name = "transfer_amt")
	private String transferAmt;

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

	@JSONField(name = "extension")
	private String extension;

	public String getOutCustId() {
		return outCustId;
	}

	public void setOutCustId(String outCustId) {
		this.outCustId = outCustId;
	}

	public String getOutAcctId() {
		return outAcctId;
	}

	public void setOutAcctId(String outAcctId) {
		this.outAcctId = outAcctId;
	}

	public String getInCustId() {
		return inCustId;
	}

	public void setInCustId(String inCustId) {
		this.inCustId = inCustId;
	}

	public String getInAcctId() {
		return inAcctId;
	}

	public void setInAcctId(String inAcctId) {
		this.inAcctId = inAcctId;
	}

	public String getTransferAmt() {
		return transferAmt;
	}

	public void setTransferAmt(String transferAmt) {
		this.transferAmt = transferAmt;
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
		if("203000".equals(this.getRespCode()))
			return true;
		return false;
	}
}
