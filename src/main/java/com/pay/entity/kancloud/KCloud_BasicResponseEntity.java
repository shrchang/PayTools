package com.pay.entity.kancloud;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 海豚付返回参数的基本说明
 * 
 * @ClassName KCloud_BasicResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月24日 上午9:18:43
 *
 */
public abstract class KCloud_BasicResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175890779361092924L;

	//0代表成功
	private String code;

	//返回的消息
	private String msg;

	//时间
	private String timestamp;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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
