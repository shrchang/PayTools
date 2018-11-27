package com.pay.entity.hftx.user.bank.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

public class Hftx_BindBankQueryResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9160841597247633536L;

	@JSONField(name="user_cust_id")
	private String userCustId;
	
	@JSONField(name="card_list")
	private String cardList;
	
	@Override
	public boolean isSucess() {
		return true;
	}

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getCardList() {
		return cardList;
	}

	public void setCardList(String cardList) {
		this.cardList = cardList;
	}

}
