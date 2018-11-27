package com.pay.entity.ypl.pay;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.ypl.YPL_BasicResponseEntity;

/**
 * 支付返回的对象
 * @ClassName YPL_PayResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月27日 下午4:26:42
 *
 */
@XmlAlias(name="root")
public class YPL_PayResponseEntity extends YPL_BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3884127008082158327L;
	
	@XmlField(name="curr_code")
	private String currCode;
	
	@XmlField(name="amount")
	private String amount;
	
	@XmlField(name="pay_no")
	private String payNo;
	
	@XmlField(name="pay_info")
	private String payInfo;

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}
}
