package com.pay.entity.zgyt.pay;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 支付body返回的参数
 * @ClassName PayResponseBody
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 下午2:46:09
 *
 */
public class PayResponseBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121859013869583107L;

	/**
	 * 随即串
	 */
	@JSONField(name="nonce_str")
	private String nonceStr;
	
	/**
	 * 处理结果只有=0是成功 其余失败
	 */
	@JSONField(name="result_code")
	private String resultCode;
	
	/**
	 * 失败的编码
	 */
	@JSONField(name="err_code")
	private String errCode;
	
	/**
	 * 失败描述
	 */
	@JSONField(name="err_code_des")
	private String errCodeDes;
	
	/**
	 * 设备号
	 */
	@JSONField(name="device_info")
	private String deviceInfo;
	
	/**
	 * 扩展字段
	 */
	private String ext;
	
	/**
	 * 订单号
	 */
	@JSONField(name="out_trade_no")
	private String outTradeNo;
	
	/**
	 * 支付流水号
	 */
	@JSONField(name="order_no")
	private String orderNo;
	
	/**
	 * 原生的路径 需要另外封装
	 */
	@JSONField(name="code_url")
	private String codeUrl;
	
	@JSONField(name="code_img_url")
	private String codeImgUrl;

	public String getNonceStr() {
		return nonceStr;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public String getExt() {
		return ext;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public String getCodeImgUrl() {
		return codeImgUrl;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public void setCodeImgUrl(String codeImgUrl) {
		this.codeImgUrl = codeImgUrl;
	}
}
