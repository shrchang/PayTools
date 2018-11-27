package com.pay.entity.hfb;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 汇付宝请求返回基础实体
 * 
 * @ClassName HFB_BasicResponeEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 上午9:41:05
 *
 */
public abstract class HFB_BasicResponeEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6367094810342762906L;

	private Integer retCode;// 返回的code @link RetCodeConstant

	private String retMsg;// 返回的信息

	private String merchantId = "";// 商户的id

	private String tradeType = "";// 支付类型

	private String transNo;// 汇付宝的订单号

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	
	/**
	 * MD5加密，而且需要区别的事情是paySecret是最后排序完成后加到最后面的
	 */
	public String getSign() {
		return this.sign;
	}
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
	
	public void setSign(String sign) {
		this.sign = sign;
	}
}
