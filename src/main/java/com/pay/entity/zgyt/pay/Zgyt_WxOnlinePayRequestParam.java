package com.pay.entity.zgyt.pay;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.constant.PaymentTypeEnum;
import com.pay.constant.ServiceNameEnum;
import com.pay.entity.zgyt.BasicRequestParam;
import com.pay.exception.PayException;
import com.pay.util.DateUtil;
import com.pay.util.sign.zgyt.SignUtil;
import com.pay.util.text.JsonUtil;

/**
 * 微信线上支付的逻辑
 * @ClassName Zgyt_WxOnlinePayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 上午11:33:59
 *
 */
public class Zgyt_WxOnlinePayRequestParam extends BasicRequestParam {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3600246375350305846L;

	/**
	 * 重写部分参数
	 * @author shrChang.Liu
	 */
	public Zgyt_WxOnlinePayRequestParam(){
		super();
		this.serviceName = ServiceNameEnum.SUBMITORDER.toString();
		this.bodyData = new RequestBody();
	}
	
	private RequestBody bodyData;
	
	/**
	 * 这个是参数
	 * @ClassName RequestBody
	 * @author shrChang.Liu
	 * @Description TODO
	 * @date 2018年10月10日 上午11:36:30
	 *
	 */
	class RequestBody{
		
		/**
		 * 支付方式 {@link PaymentTypeEnum}
		 */
		@JSONField(name="payment_type",ordinal=8)
		private String paymentType=PaymentTypeEnum.PAYWXSERVICEONLINE.toString();
		
		/**
		 * 随机字符串
		 */
		@JSONField(name="nonce_str",ordinal=5)
		private String nonceStr=UUID.randomUUID().toString().replace("-","");
		
		/**
		 * 商户订单号 32位以下唯一
		 */
		@JSONField(name="out_trade_no",ordinal=7)
		private String outTradeNo;
		
		/**
		 * 金额到分
		 */
		@JSONField(name="total_fee",ordinal=10)
		private String totalFee;
		
		/**
		 * 币种默认
		 */
		@JSONField(name="fee_type",ordinal=3)
		private String feeType="CNY";
		
		/**
		 * 服务端ip地址
		 */
		@JSONField(name="mch_create_ip",ordinal=4)
		private String mchCreateIp;
		
		/**
		 * 订单时间
		 */
		@JSONField(name="time_start",ordinal=9)
		private String timeStart=DateUtil.getStrByNow("yyyyMMddHHmmss");
		
		/**
		 * 订单通知URL
		 */
		@JSONField(name="notify_url",ordinal=6)
		private String notifyUrl;
		
		/**
		 * 回调的url只针对于公众号支付
		 */
		@JSONField(name="callback_url",ordinal=2)
		private String callbackUrl;
		
		/**
		 * 商品描述
		 */
		@JSONField(name="body",ordinal=1)
		private String body;
		
		public String getPaymentType() {
			return paymentType;
		}

		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		public String getNonceStr() {
			return nonceStr;
		}

		public void setNonceStr(String nonceStr) {
			this.nonceStr = nonceStr;
		}

		public String getOutTradeNo() {
			return outTradeNo;
		}

		public void setOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
		}

		public String getTotalFee() {
			return totalFee;
		}

		public void setTotalFee(String totalFee) {
			this.totalFee = totalFee;
		}

		public String getFeeType() {
			return feeType;
		}

		public void setFeeType(String feeType) {
			this.feeType = feeType;
		}

		public String getMchCreateIp() {
			return mchCreateIp;
		}

		public void setMchCreateIp(String mchCreateIp) {
			this.mchCreateIp = mchCreateIp;
		}

		public String getTimeStart() {
			return timeStart;
		}

		public void setTimeStart(String timeStart) {
			this.timeStart = timeStart;
		}

		public String getNotifyUrl() {
			return notifyUrl;
		}

		public void setNotifyUrl(String notifyUrl) {
			this.notifyUrl = notifyUrl;
		}

		public String getCallbackUrl() {
			return callbackUrl;
		}

		public void setCallbackUrl(String callbackUrl) {
			this.callbackUrl = callbackUrl;
		}
		
		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		/**
		 * 验证
		 * @author shrChang.Liu
		 * @throws PayException
		 * @date 2018年10月10日 下午12:12:13
		 * @return void
		 * @description
		 */
		public void validate()throws PayException{
			if(StringUtils.isBlank(this.outTradeNo)){
				throw new PayException("订单号不能为空！");
			}
			if(StringUtils.isBlank(this.totalFee)){
				throw new PayException("订单金额不能为空！");
			}
			
			if(StringUtils.isBlank(this.mchCreateIp)){
				throw new PayException("客户端IP不能为空！");
			}
			
			if(StringUtils.isBlank(this.notifyUrl)){
				throw new PayException("异步通知地址不能为空！");
			}
			
			if(StringUtils.isBlank(this.callbackUrl)){
				throw new PayException("回调地址不能为空！");
			}
			
			if(StringUtils.isBlank(this.body)){
				throw new PayException("商品描述不能为空！");
			}
		}
	}
	
	/**
	 * 支付类型
	 * @author shrChang.Liu
	 * @param paymentType
	 * @date 2018年10月10日 下午3:09:40
	 * @return void
	 * @description
	 */
	public void setPaymentType(String paymentType) {
		this.bodyData.setPaymentType(paymentType);
	}
	
	/**
	 * 设置订单号
	 * @author shrChang.Liu
	 * @param outTradeNo
	 * @date 2018年10月10日 下午12:08:20
	 * @return void
	 * @description
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.bodyData.setOutTradeNo(outTradeNo);
	}
	
	/**
	 * 设置金额
	 * @author shrChang.Liu
	 * @param totalFee
	 * @date 2018年10月10日 下午12:08:48
	 * @return void
	 * @description
	 */
	public void setTotalFee(String totalFee) {
		this.bodyData.setTotalFee(totalFee);
	}
	
	/**
	 * 设置IP地址
	 * @author shrChang.Liu
	 * @param mchCreateIp
	 * @date 2018年10月10日 下午12:10:01
	 * @return void
	 * @description
	 */
	public void setMchCreateIp(String mchCreateIp) {
		this.bodyData.setMchCreateIp(mchCreateIp);
	}
	
	/**
	 * 设置通知地址
	 * @author shrChang.Liu
	 * @param notifyUrl
	 * @date 2018年10月10日 下午12:10:31
	 * @return void
	 * @description
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.bodyData.setNotifyUrl(notifyUrl);
	}

	/**
	 * 设置回调地址
	 * @author shrChang.Liu
	 * @param callbackUrl
	 * @date 2018年10月10日 下午12:11:07
	 * @return void
	 * @description
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.bodyData.setCallbackUrl(callbackUrl);
	}
	
	/**
	 * 设置商品信息
	 * @author shrChang.Liu
	 * @param body
	 * @date 2018年10月10日 下午1:43:18
	 * @return void
	 * @description
	 */
	public void setBody(String body) {
		this.bodyData.setBody(body);
	}
	

	public RequestBody getBodyData() {
		return bodyData;
	}

	@Override
	public void validate() throws PayException {
		//判断body的参数值
		this.bodyData.validate();
		
		SignUtil.validate(this);
	}

	@Override
	public String parseBody()throws Exception{
		return JsonUtil.getJsonStrByObj(this.getBodyData());
	}
}
