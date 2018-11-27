package com.pay.entity.hftx.user.bank.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.hftx.BasicResponseEntity;

/**
 * 快捷绑定银行卡响应
 * 
 * @ClassName Hftx_BindBankCardResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:18:10
 *
 */
public class Hftx_BindBankCardResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3174289837562621811L;

	/**
	 * 用户客户号
	 */
	@JSONField(name = "user_cust_id")
	private String userCustId;

	/**
	 * 本平台交易唯一标识号
	 */
	@JSONField(name = "platform_seq_id")
	private String platformSeqId;

	/**
	 * 开户银行代号
	 */
	@JSONField(name = "bank_id")
	private String bankId;

	/**
	 * 银行卡号
	 */
	@JSONField(name = "card_no")
	private String cardNo;

	/**
	 * 这个必须保存 快捷支付需要用到的银行卡标识
	 */
	@JSONField(name = "bind_card_id")
	private String bindCardId;

	/**
	 * 商户后台应答地址
	 */
	@JSONField(name = "bg_ret_url")
	private String bgRetUrl;

	/**
	 * 页面返回URL
	 */
	@JSONField(name = "ret_url")
	private String retUrl;

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

	public String getBindCardId() {
		return bindCardId;
	}

	public void setBindCardId(String bindCardId) {
		this.bindCardId = bindCardId;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
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
		if("103000".equals(this.getRespCode())){
			return true;
		}
		return false;
	}

}
