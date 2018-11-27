package com.pay.entity.hftx.user.account.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 查询用户余额
 * @ClassName Hftx_AccountQueryRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月18日 下午3:46:40
 *
 */
public class Hftx_AccountQueryRequestParam extends BasicRequestParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007929395158523897L;

	@PayRequestParamLabel(isRequired=true,isSign=true,name="user_cust_id")
	private String userCustId;
	
	@PayRequestParamLabel(isRequired=true,isSign=true,name="acct_id")
	private String acctId;

	public String getUserCustId() {
		return userCustId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	@Override
	public String getCmdId() {
		return "303";
	}
}
