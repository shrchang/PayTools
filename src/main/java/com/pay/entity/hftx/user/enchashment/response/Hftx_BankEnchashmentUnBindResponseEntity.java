package com.pay.entity.hftx.user.enchashment.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 解绑取现卡响应数据
 * 
 * @ClassName Hftx_BankEnchashmentBindResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:36:52
 *
 */
public class Hftx_BankEnchashmentUnBindResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8053967282727555556L;

	/**
	 * 用户id
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 银行代码
	 */
	@JSONField(name = "bank_id")
	private String bankId;

	/**
	 * 银行卡绑定ID
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 银行卡号
	 */
	@JSONField(name = "card_no")
	private String cardNo;

	/**
	 * 银行卡绑定ID 这个是要保存到数据库的
	 */
	@JSONField(name = "card_no")
	private String cardo;

	/**
	 * 卡业务类型
	 */
	@JSONField(name = "cardBussType")
	private String cardBussType;

	/**
	 * 银行卡预留手机号
	 */
	@JSONField(name = "card_mobile")
	private String cardMobile;

	/**
	 * 短信验证码日期
	 */
	@JSONField(name = "sms_order_date")
	private String smsOrderDate;

	/**
	 * 短信验证码订单号
	 */
	@JSONField(name = "sms_order_id")
	private String smsOrderId;

	/**
	 * 短信验证码
	 */
	@JSONField(name = "sms_code")
	private String smsCode;

	/**
	 * 后台通知地址
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

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardo() {
		return cardo;
	}

	public void setCardo(String cardo) {
		this.cardo = cardo;
	}

	public String getCardBussType() {
		return cardBussType;
	}

	public void setCardBussType(String cardBussType) {
		this.cardBussType = cardBussType;
	}

	public String getCardMobile() {
		return cardMobile;
	}

	public void setCardMobile(String cardMobile) {
		this.cardMobile = cardMobile;
	}

	public String getSmsOrderDate() {
		return smsOrderDate;
	}

	public void setSmsOrderDate(String smsOrderDate) {
		this.smsOrderDate = smsOrderDate;
	}

	public String getSmsOrderId() {
		return smsOrderId;
	}

	public void setSmsOrderId(String smsOrderId) {
		this.smsOrderId = smsOrderId;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
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
		if("105000".equals(this.getRespCode()))
			return true;
		return false;
	}

}
