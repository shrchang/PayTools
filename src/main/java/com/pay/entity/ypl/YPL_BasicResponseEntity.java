package com.pay.entity.ypl;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 易票联请求返回基类
 * 
 * @ClassName YPL_BasicResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午3:41:19
 *
 */
public abstract class YPL_BasicResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5357504258770367000L;

	@XmlField(name="resp_code")
	private String respCode;// 返回状态码
	
	@XmlField(name="resp_desc")
	private String respDesc;// 响应描述
	
	@XmlField(name="partner")
	private String partner;// 商户id
	
	@XmlField(name="out_trade_no")
	private String outTradeNo;// 商户系统订单号
	
	@XmlField(name="sign_type")
	private String signType;// 签名类型

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

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
