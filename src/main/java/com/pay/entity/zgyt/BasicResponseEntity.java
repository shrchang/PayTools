package com.pay.entity.zgyt;

import com.pay.entity.BaseUrlEntity;

/**
 * 中钢银通响应的基础类
 * @ClassName BasicResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 下午1:51:42
 *
 */
public abstract class BasicResponseEntity extends BaseUrlEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 969819448399924501L;

	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 请求号
	 */
	private String requestId;
	
	/**
	 * 请求时间
	 */
	private String requestTime;
	
	/**
	 * 响应code 0000处理成功 具体的是否成功还要去里面查看才知道
	 */
	protected String responseCode;
	
	/**
	 * 响应消息
	 */
	private String responseMsg;
	
	/**
	 * 响应时间
	 */
	private String responseTime;
	
	/**
	 * 服务名
	 */
	private String serviceName;
	
	/**
	 * 签名档
	 */
	private String signData;
	
	/**
	 * 签名方式
	 */
	private String signType;
	
	/**
	 * 返回的body
	 */
	protected String sourceData;
	
	/**
	 * 版本号
	 */
	private String version;

	public String getMerchantNo() {
		return merchantNo;
	}

	public String getRequestId() {
		return requestId;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getSignData() {
		return signData;
	}

	public String getSignType() {
		return signType;
	}

	public String getSourceData() {
		return sourceData;
	}

	public String getVersion() {
		return version;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setSignData(String signData) {
		this.signData = signData;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
