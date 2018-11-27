package com.pay.entity.aPay;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.aPay.SignUtil;

/**
 * A支付基础请求参数
 * 
 * @ClassName APay_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午4:22:24
 *
 */
public abstract class APay_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5429861311879669151L;

	/**
	 * 商户支付Key
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String payKey = "fda8a411670e48108f313787b9926905";// 商户支付Key

	/**
	 * 订单金额，单位：元 保留小数点后两位
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String orderPrice = "10";// 订单金额，单位：元 保留小数点后两位

	/**
	 * 商户支付订单号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String outTradeNo = "1532333459306";

	/**
	 * 产品类型: 40000701 T0
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String productType = "40000502";

	/**
	 * 下单时间，格式：yyyyMMddHHmmss
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String orderTime = "20180723161059";

	/**
	 * 银行卡 可以为空 非必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String payBankAccountNo = "";

	/**
	 * 银行预留手机号码 非必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String payPhoneNo = "";

	/**
	 * 开户人的姓名 非必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String payBankAccountName = "";

	/**
	 * 证件号码 非必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String payCertNo = "";

	/**
	 * 产品的名称
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String productName = "纸巾";

	/**
	 * 下单的IP地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String orderIp = "127.0.0.1";

	/**
	 * 通知返回的URL
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String returnUrl = "http://debug.iexbuy.cn/asynTest/servlet/CallBackServlet";

	/**
	 * 异步通知的URL
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String notifyUrl = "http://debug.iexbuy.cn/test-pay-app-notify/pay/notify";

	/**
	 * 子商户支付Key，大商户时必填
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String subPayKey = "";

	/**
	 * 备注
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String remark = "支付备注";

	/**
	 * 签名加密的字段 sortIndex!=0代表他特殊 加到签名结尾即可 他不需要传入
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, sortIndex = 1)
	private String paySecret = "882bf091bce54a1cb6b7d2a35302dadd";
	
	/**
	 * 请求的url
	 */
	@PayRequestParamLabel(isRequired=true)
	private String url="https://gateway.aabill.net/quickGateWayPay/initPay";

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPayBankAccountNo() {
		return payBankAccountNo;
	}

	public void setPayBankAccountNo(String payBankAccountNo) {
		this.payBankAccountNo = payBankAccountNo;
	}

	public String getPayPhoneNo() {
		return payPhoneNo;
	}

	public void setPayPhoneNo(String payPhoneNo) {
		this.payPhoneNo = payPhoneNo;
	}

	public String getPayBankAccountName() {
		return payBankAccountName;
	}

	public void setPayBankAccountName(String payBankAccountName) {
		this.payBankAccountName = payBankAccountName;
	}

	public String getPayCertNo() {
		return payCertNo;
	}

	public void setPayCertNo(String payCertNo) {
		this.payCertNo = payCertNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderIp() {
		return orderIp;
	}

	public void setOrderIp(String orderIp) {
		this.orderIp = orderIp;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getSubPayKey() {
		return subPayKey;
	}

	public void setSubPayKey(String subPayKey) {
		this.subPayKey = subPayKey;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPaySecret() {
		return paySecret;
	}

	public void setPaySecret(String paySecret) {
		this.paySecret = paySecret;
	}

	/**
	 * 获取签名，MD5加密 需要将需要加密的参数按照ASCII排序，然后在后面加上paySecret=xxx ，然后转成大写
	 */
	public String getSign() {
		if (this.sign != null)
			return sign;
		try {
			return SignUtil.getSign(this);
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
	 * 请求参数验证方法，默认保留
	 * 
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年7月23日 下午4:32:58
	 * @return void
	 * @description
	 */
	public abstract void validation() throws Exception;

}
