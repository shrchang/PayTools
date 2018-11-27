package com.pay.entity.hftx.user.enchashment.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 绑定取现卡响应数据
 * @ClassName Hftx_BankEnchashmentBindResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:36:52
 *
 */
public class Hftx_BankEnchashmentBindResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8053967282727555556L;

	/**
	 * 用户id
	 */
	@JSONField(name="user_cust_id")
	private String userCustId;
	
	/**
	 * 流水号
	 */
	@JSONField(name="platform_seq_id")
	private String platformSeqId;
	
	/**
	 * 银行卡代号
	 */
	@JSONField(name="bank_id")
	private String bankId;
	
	/**
	 * 银行卡号
	 */
	@JSONField(name="card_no")
	private String cardNo;
	
	/**
	 * 银行卡绑定ID	 这个是要保存到数据库的
	 */
	@JSONField(name="cash_bind_card_id")
	private String cashBindCardId;
	
	/**
	 * 借贷标志 默认是D
	 */
	@JSONField(name="dc_flag")
	private String dcFlag;
	
	/**
	 * 银行卡开户省份	
	 */
	@JSONField(name="card_prov")
	private String cardProv;
	
	/**
	 * 银行卡开户地区	
	 */
	@JSONField(name="card_area")
	private String cardArea;
	
	/**
	 * 后台通知地址
	 */
	@JSONField(name="bg_ret_url")
	private String bgRetUrl;
	
	/**
	 * 商户私有域	
	 */
	@JSONField(name="mer_priv")
	private String merPriv;
	
	/**
	 * 扩展域	
	 */
	@JSONField(name="extension")
	private String extension;

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getPlatformSeqId() {
		return platformSeqId;
	}

	public void setPlatformSeqId(String platformSeqId) {
		this.platformSeqId = platformSeqId;
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

	public String getCashBindCardId() {
		return cashBindCardId;
	}

	public void setCashBindCardId(String cashBindCardId) {
		this.cashBindCardId = cashBindCardId;
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
		if("811000".equals(this.getRespCode()))
			return true;
		return false;
	}
}
