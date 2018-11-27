package com.pay.entity.kancloud;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.kancloud.SignUtil;

/**
 * 海豚付支付基础请求参数
 * 
 * @ClassName KCloud_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月24日 上午9:16:00
 *
 */
public abstract class KCloud_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 124369630111789368L;

	/**
	 * 平台分配商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_id")
	private String userId;

	/**
	 * 上送订单号唯一
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "out_trade_no")
	private String outTradeNo;

	/**
	 * 支付产品ID
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "product_id")
	private String productId;

	/**
	 * 同步返回地址，HTTP/HTTPS开头字符串
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "return_url")
	private String returnUrl;

	/**
	 * 服务器主动通知商户服务器里指定的页面http/https路径
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "notify_url")
	private String notifyUrl;

	/**
	 * 订单标题
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String subject;

	/**
	 * 订单描述
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String body;

	/**
	 * 备注
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String remark;

	/**
	 * 此字段在返回时按原样返回 （中文需要url编码）
	 */
	@PayRequestParamLabel(isRequired = false, isSign = false)
	private String attach;

	/**
	 * 订单金额 单位元 保留2位小数
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "pay_amount")
	private String payAmount;

	/**
	 * 提交时间
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String applydate;

	/**
	 * 加密密钥
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, sortIndex = 1)
	private String apikey;

	/**
	 * 请求的路径
	 */
	@PayRequestParamLabel(isRequired = true, sortIndex = 1)
	private String url;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSign() {
		try {
			if (this.sign == null)
				this.sign = SignUtil.getSign(this);
			return this.sign;
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
	 * 验证参数的正确性
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年7月24日 上午9:49:36
	 * @return void
	 * @description
	 */
	public abstract void validate()throws Exception;

}
