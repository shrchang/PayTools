package com.pay.entity.zgyt;

import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.constant.ServiceNameEnum;
import com.pay.entity.BaseUrlEntity;
import com.pay.exception.PayException;
import com.pay.util.DateUtil;
import com.pay.util.sign.zgyt.SignUtil;

/**
 * 中钢银通测试请求主体
 * @ClassName BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 上午10:33:56
 *
 */
public abstract class BasicRequestParam extends BaseUrlEntity {
	
	private Logger logger = Logger.getLogger(BasicRequestParam.class);

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1396820995475484816L;

	/**
	 * 商户
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	private String merchantNo="888888";
	
	/**
	 * 加密的密钥
	 */
	@PayRequestParamLabel(isRequired=true)
	private String key="c5809078fa6d652e0b0232d552a9d06d37fe819c";
	
	/**
	 * 请求的url
	 */
	@PayRequestParamLabel(isRequired=true)
	private String url="https://jh.g-pay.cn/api/order.do";
	
	/**
	 * 服务编码 {@link ServiceNameEnum}
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	protected String serviceName;
	
	/**
	 * 请求的字符编码？
	 */
	private String charset="UTF-8";
	
	/**
	 * 版本号
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	private String version="2.0";
	
	/**
	 * 报文加密方式 暂时无用
	 */
	private String encryptType="NONE";
	
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	private String signType="MD5";
	
	/**
	 * 这是签名 必填但是不是在这个时候
	 */
	@PayRequestParamLabel(isParam=true)
	private String signData;
	
	/**
	 * 报文body实体 必填 但是不是在这个时候
	 */
	@PayRequestParamLabel(isSign=true,isParam=true)
	private String sourceData;
	
	/**
	 * 唯一标识 默认使用uuid
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	private String requestId=UUID.randomUUID().toString();
	
	/**
	 * 请求时间
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,isParam=true)
	private String requestTime=DateUtil.getStrByNow("yyyyMMddHHmmss");

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncryptType() {
		return encryptType;
	}

	public void setEncryptType(String encryptType) {
		this.encryptType = encryptType;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignData() {
		if(this.signData == null){
			try {
				this.signData = SignUtil.getSign(this, this.key);
			} catch (Exception e) {
				logger.error("报文签名失败：",e);
			}
		}
		return signData;
	}

	public void setSignData(String signData) {
		this.signData = signData;
	}

	public String getSourceData() {
		if(sourceData == null)
			try {
				this.sourceData = this.parseBody();
			} catch (Exception e) {
				logger.error("获取报文主体失败:",e);
			}
		return sourceData;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	
	/**
	 * 针对不同的请求去验证参数是否合法
	 * @author shrChang.Liu
	 * @throws PayException
	 * @date 2018年10月10日 上午11:32:11
	 * @return void
	 * @description
	 */
	 public abstract void validate()throws PayException;
	 
	 /**
	  * 获取body的JSON字符串
	  * @author shrChang.Liu
	  * @return
	  * @throws PayException
	  * @date 2018年10月10日 下午12:47:32
	  * @return String
	  * @description
	  */
	 public abstract String parseBody()throws Exception;
	 
	 /**
	  * 这个是获取参数值
	  * @author shrChang.Liu
	  * @return
	  * @date 2018年10月10日 下午12:34:41
	  * @return Map<String,String>
	  * @description
	  */
	 public Map<String,String> getParamMap()throws PayException{
		 //第一步验证参数
		 this.validate();
		 //第二部获取body的值
		 this.getSourceData();
		 //获取签名
		 this.getSignData();
		 //返回最终的执行参数集合
		 return SignUtil.getHttpPostParamMap(this);
	 }
}
