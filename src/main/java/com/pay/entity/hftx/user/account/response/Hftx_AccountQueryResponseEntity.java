package com.pay.entity.hftx.user.account.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

public class Hftx_AccountQueryResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4991284826430803897L;

	/**
	 * 用户id
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 用户子账户id
	 */
	@JSONField(name = "acct_id")
	private String acctId;

	/**
	 * 可用余额
	 */
	private String balance;

	/**
	 * 账户余额
	 */
	@JSONField(name = "acct_balance")
	private String acctBalance;

	/**
	 * 冻结余额
	 */
	@JSONField(name = "freeze_balance")
	private String freezeBalance;

	/**
	 * 账户状态
	 */
	@JSONField(name = "acct_stat")
	private String acctStat;

	public String getUserCustId() {
		return userCustId;
	}

	public String getAcctId() {
		return acctId;
	}

	public String getBalance() {
		return balance;
	}

	public String getAcctBalance() {
		return acctBalance;
	}

	public String getFreezeBalance() {
		return freezeBalance;
	}

	public String getAcctStat() {
		return acctStat;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setAcctBalance(String acctBalance) {
		this.acctBalance = acctBalance;
	}

	public void setFreezeBalance(String freezeBalance) {
		this.freezeBalance = freezeBalance;
	}

	public void setAcctStat(String acctStat) {
		this.acctStat = acctStat;
	}

	@Override
	public boolean isSucess() {
		if ("000".equals(this.getRespCode()))
			return true;
		return false;
	}

}
