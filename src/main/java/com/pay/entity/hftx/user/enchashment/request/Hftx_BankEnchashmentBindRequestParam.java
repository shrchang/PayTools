package com.pay.entity.hftx.user.enchashment.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.constant.BankEnum;
import com.pay.entity.hftx.BasicRequestParam;

/**
 * 绑定与开户取现银行卡
 * 异步的通知/绑定取现的银行卡也是异步的通知
 * @ClassName Hftx_BankEnchashmentRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:05:57
 *
 */
public class Hftx_BankEnchashmentBindRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -439297965502972589L;

	/**
	 * 用户客户号 可选 如果有客户id需要传递 否则是重新开户
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "user_cust_id")
//	private String userCustId="6666000000054967";
	private String userCustId;

	/**
	 * 客户用户名 同上
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "user_name")
	private String userName;

	/**
	 * 身份证号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "cert_id")
	private String certId;

	/**
	 * 用户注册的手机号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "user_mobile")
	private String userMobile;

	/**
	 * 银行卡编号 {@link BankEnum}
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bank_id")
//	private String bankId=BankEnum.getCodeByName("兴业银行");
	private String bankId;

	/**
	 * 待绑定的银行卡号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_no")
//	private String cardNo="622909397229839215";
	private String cardNo;

	/**
	 * 借贷标记 D–借记，储蓄卡；C–贷记 只支持D
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "dc_flag")
	private String dcFlag = "D";

	/**
	 * 银行卡开户省份
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_prov")
	private String cardProv;

	/**
	 * 银行卡开户地区
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_area")
	private String cardArea;

	/**
	 * 是否默认取现卡 00000000：非默认取现卡；00000001：默认取现卡
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "is_default")
	private String isDefault = "00000001";

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getDcFlag() {
		return dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getCardProv() {
		return cardProv;
	}

	public void setCardProv(String cardProv) {
		this.cardProv = cardProv;
	}

	public String getCardArea() {
		return cardArea;
	}

	public void setCardArea(String cardArea) {
		this.cardArea = cardArea;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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
		if(this.cmdId != null)
			this.cmdId = "811";
		return this.cmdId;
	}

}
