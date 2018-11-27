package com.pay.entity.poco;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.poco.RequestBodyUtil;
import com.pay.util.text.UnicodeUtil;

/**
 * poco的基础请求参数
 * 
 * @ClassName Poco_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月30日 下午12:19:43
 *
 */
public abstract class Poco_BasicRequestParam extends BaseUrlEntity {
	
	private static Logger logger = LoggerFactory.getLogger(Poco_BasicRequestParam.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 2705537542425222716L;

	/**
	 * 订单号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_trade_no")
	private String outTradeNo;

	/**
	 * 交易描述
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String body = "xxxxx";

	/**
	 * 交易方式 weixin qq alipay 微信 qq 支付宝
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "pay_type")
	private String payType;

	/**
	 * 交易金额 单位分
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trade_amount")
	private String tradeAmount;

	/**
	 * 回调地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "notify_url")
	private String notifyUrl;

	/**
	 * 支付成功后跳转的地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "sync_url")
	private String syncUrl;

	/**
	 * 客户端的ip地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "client_ip")
	private String clientIp;

	/**
	 * 商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "merchant_no")
	private String merchantNo;

	/**
	 * 随机参数 自己生成即可
	 */
	private String randstr=RequestBodyUtil.createRandom(false, 32);

	/**
	 * 当前的时间错
	 */
	private String timestamp = new Date().getTime() + "";

	/**
	 * 调用的方法
	 */
	@PayRequestParamLabel(isRequired = true)
	private String method;

	/**
	 * 数据签名密钥
	 */
	@PayRequestParamLabel(isRequired = true)
	private String key;

	/**
	 * 用于解析返回的公钥 平台给商户的
	 */
	@PayRequestParamLabel(isRequired = true)
	private String publicKey;

	/**
	 * 商户自己的私钥 对应的公钥要上传给平台才行
	 */
	@PayRequestParamLabel(isRequired = true)
	private String privateKey;

	/**
	 * 商户签约的pid
	 */
	@PayRequestParamLabel(isRequired = true)
	private String pid;

	/**
	 * 请求的url路径 必填
	 */
	@PayRequestParamLabel(isRequired = true)
	private String url;
	
	/**
	 * 这个字段是post请求体里面的字段吧 用于签名 所以这个获取的方式有点恶心
	 */
	private String data;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getBody() {
		return body;
	}

	/**
	 * 这个地方有中文必须转码unicode
	 * @author shrChang.Liu
	 * @param body
	 * @date 2018年7月2日 上午10:12:55
	 * @return void
	 * @description
	 */
	public void setBody(String body) {
		this.body = UnicodeUtil.chineseToUnicode(body);
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getRandstr() {
		return randstr;
	}

	public void setRandstr(String randstr) {
		this.randstr = randstr;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSyncUrl() {
		return syncUrl;
	}

	public void setSyncUrl(String syncUrl) {
		this.syncUrl = syncUrl;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getData() throws Exception{
		if(data == null){
			data = RequestBodyUtil.getPostData(this);
		}
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 首先要返回的是签名 需要将GET POST的参数按照固定顺序A-z排序后转成json格式+签名的密钥进行MD5加密
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年6月30日 下午12:37:20
	 * @return String
	 * @description
	 */
	public void getSignStr()throws Exception{
		String signStr = "{" +
				"\"data\":" + getData().replaceAll("\\\\/", "/").replaceAll("\\\\\\\\", "\\\\") + "," +										//按key字母顺序拼接参数
				"\"method\":\"" + this.method + "\"," +								//接口名
				"\"pid\":\"" + this.pid + "\","+										//商户签约PID
				"\"randstr\":\"" + this.randstr										//随机字符串
				+ "\",\"timestamp\":\"" + this.timestamp + "\"" +
			"}" + this.key;	
		logger.info("签名前post的Data:" + getData());
		logger.info("签名前的字符串：" + signStr);
		this.sign = DigestUtils.md5Hex(signStr);
	}
	
	public String getSign(){
		return this.sign;
	}
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/**
	 * 验证请求参数
	 * @author shrChang.Liu
	 * @date 2018年6月30日 下午1:08:44
	 * @return void
	 * @description
	 */
	public void validate()throws Exception{
		RequestBodyUtil.validate(this);
	}

}
