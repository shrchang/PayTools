package com.pay.entity.hftx.user.enchashment.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.constant.BankEnum;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 解绑取现银行卡 
 * 
 * @ClassName Hftx_BankEnchashmentRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:05:57
 *
 */
public class Hftx_BankEnchashmentUnBindRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -439297965502972589L;

	/**
	 * 用户客户号 可选 如果有客户id需要传递 否则是重新开户
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;

	/**
	 * 银行卡编号 {@link BankEnum}
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bank_id")
	private String bankId;

	/**
	 * 绑定的银行Id
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_id")
	private String cardId;

	/**
	 * 绑定的银行卡号 银行卡绑定ID与银行卡号不能同时为空
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_no")
	private String cardNo;

	/**
	 * 预留的手机号码
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_mobile")
	private String cardMobile;

	/**
	 * 卡业务类型 0:取现，1：代扣，2：快捷
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_buss_type")
	private String cardBussType="0";

	/**
	 * 短信验证码日期 与sms_code对应的验证码发送订单日期
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "sms_order_date")
	private String smsOrderDate;

	/**
	 * 短信验证码订单号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "sms_order_id")
	private String smsOrderId;

	/**
	 * 短信验证码
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "sms_code")
	private String smsCode;

	/**
	 * 通过后台异步通知，商户应在应答接收的响应中输出RECV_ORD_ID字样的字符串，表明商户已经收到该笔交易结果。 注意：1)
	 * URL应使用UTF-8字符集URLEncode编码后传入；2)URL中请不要包含特殊字符 ；3) 必须是外网地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	@PayRequestParamLabel(isRequired = false, isSign = true, name = "mer_priv")
	private String merPriv;

	@PayRequestParamLabel(isRequired = false, isSign = true, name = "extension")
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

	public String getCardMobile() {
		return cardMobile;
	}

	public void setCardMobile(String cardMobile) {
		this.cardMobile = cardMobile;
	}

	public String getCardBussType() {
		return cardBussType;
	}

	public void setCardBussType(String cardBussType) {
		this.cardBussType = cardBussType;
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
	public String getCmdId() {
		if (this.cmdId != null)
			this.cmdId = "105";
		return this.cmdId;
	}

}
