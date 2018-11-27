package com.pay.entity.poco;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 响应返回的基类
 * @ClassName Poco_BasicResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月30日 下午4:49:25
 *
 */
public abstract class Poco_BasicResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1522933325541345945L;

	private String errcode;

	private String msg;

	private String data;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
