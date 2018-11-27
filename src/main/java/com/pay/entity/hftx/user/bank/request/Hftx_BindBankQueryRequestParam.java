package com.pay.entity.hftx.user.bank.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;

public class Hftx_BindBankQueryRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8799079016967817853L;

	@PayRequestParamLabel(isSign = true, isRequired = true, name = "user_cust_id")
	private String userCustId;

	@PayRequestParamLabel(isSign = true, name = "bind_card_id")
	private String bindCardId;

	@Override
	public String getCmdId() {
		return "318";
	}

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getBindCardId() {
		return bindCardId;
	}

	public void setBindCardId(String bindCardId) {
		this.bindCardId = bindCardId;
	}
}
