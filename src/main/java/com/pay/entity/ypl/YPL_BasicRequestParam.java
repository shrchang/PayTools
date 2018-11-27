package com.pay.entity.ypl;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.common.ypl.SecurityUtil;
import com.pay.util.sign.ypl.SignTool;

/**
 * 易票联支付请求体基类
 * 
 * @ClassName YPL_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午10:13:38
 *
 */
public abstract class YPL_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8481732468535782625L;

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String certId = SecurityUtil.certId;// 密钥

	@PayRequestParamLabel(isRequired = true, isSign = true, name = "sign_type")
	private String signType = "SHA256withRSA";// 密钥类型

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String version = "4.0";// 版本号

	/**
	 * 商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String partner = "130";// 商户号

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSign() {
		if (this.sign != null)
			return sign;
		try {
			return SignTool.makeSign(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
	
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 验证参数是否合理
	 * 
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年6月23日 下午10:29:22
	 * @return void
	 * @description
	 */
	public abstract void validate() throws Exception;

}
