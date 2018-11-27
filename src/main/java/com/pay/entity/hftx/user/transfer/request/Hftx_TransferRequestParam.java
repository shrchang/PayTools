package com.pay.entity.hftx.user.transfer.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 转账的请求实体
 * @ClassName Hftx_TransferRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午10:30:02
 *
 */
public class Hftx_TransferRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1803686157061401476L;

	/**
	 * 出账客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_cust_id")
	private String outCustId;

	/**
	 * 出账子账户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_acct_id")
	private String outAcctId;

	/**
	 * 入账客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_cust_id")
	private String inCustId;

	/**
	 * 入账子账户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_acct_id")
	private String inAcctId;

	/**
	 * 转账金额
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "transfer_amt")
	private String transferAmt;

	/**
	 * 后台通知
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	@PayRequestParamLabel(isRequired = false, isSign = true, name = "mer_priv")
	private String merPriv;

	@PayRequestParamLabel(isRequired = false, isSign = true, name = "extension")
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
	public String getCmdId() {
		if (this.cmdId == null)
			this.cmdId = "203";
		return this.cmdId;
	}

}
