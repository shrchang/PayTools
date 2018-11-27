package com.pay.entity.kancloud.pay;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.kancloud.KCloud_BasicResponseEntity;

/**
 * 海豚支付返回的参数
 * 
 * @ClassName KCloud_PayResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月24日 上午9:42:35
 *
 */
public class KCloud_PayResponseEntity extends KCloud_BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462029718854261595L;

	private PayData data;

	/**
	 * 支付参数结果
	 * 
	 * @ClassName PayData
	 * @author shrChang.Liu
	 * @Description TODO
	 * @date 2018年7月24日 上午10:21:20
	 *
	 */
	public class PayData implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1203756285522785658L;

		/**
		 * 商户ID
		 */
		@JSONField(name = "user_id")
		private String userId;

		/**
		 * 订单号
		 */
		@JSONField(name = "trade_no")
		private String tradeNo;

		/**
		 * 商户订单号
		 */
		@JSONField(name = "out_trade_no")
		private String outTradeNo;

		/**
		 * 支付产品
		 */
		@JSONField(name = "product_id")
		private String productId;

		/**
		 * 支付渠道
		 */
		@JSONField(name = "channel_id")
		private String channelId;

		/**
		 * 支付金额
		 */
		@JSONField(name = "pay_amount")
		private String payAmount;

		/**
		 * 交易时间
		 */
		@JSONField(name = "datetime")
		private String datetime;

		/**
		 * 支付扩展信息
		 */
		@JSONField(name = "pay_extends")
		private PayExtendObj payExtends;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getTradeNo() {
			return tradeNo;
		}

		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
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

		public String getChannelId() {
			return channelId;
		}

		public void setChannelId(String channelId) {
			this.channelId = channelId;
		}

		public String getPayAmount() {
			return payAmount;
		}

		public void setPayAmount(String payAmount) {
			this.payAmount = payAmount;
		}

		public String getDatetime() {
			return datetime;
		}

		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}

		public PayExtendObj getPayExtends() {
			return payExtends;
		}

		public void setPayExtends(PayExtendObj payExtends) {
			this.payExtends = payExtends;
		}

		/**
		 * 支付详情的内部参数
		 * 
		 * @ClassName PayExtendObj
		 * @author shrChang.Liu
		 * @Description TODO
		 * @date 2018年7月24日 上午9:46:15
		 *
		 */
		public class PayExtendObj implements Serializable {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5807873912677618457L;

			/**
			 * jump表示pay_url为二维码链接，post表示pay_url为跳转页面链接
			 */
			@JSONField(name = "pay_action")
			private String payAction;

			/**
			 * 链接
			 */
			@JSONField(name = "pay_url")
			private String payUrl;

			/**
			 * 支付渠道账号。
			 */
			@JSONField(name = "channel_account_id")
			private String channelAccountId;

			/**
			 * 不知道含义
			 */
			@JSONField(name = "channel_entry_id")
			private String channelEntryId;

			public String getChannelEntryId() {
				return channelEntryId;
			}

			public void setChannelEntryId(String channelEntryId) {
				this.channelEntryId = channelEntryId;
			}

			public String getPayAction() {
				return payAction;
			}

			public void setPayAction(String payAction) {
				this.payAction = payAction;
			}

			public String getPayUrl() {
				return payUrl;
			}

			public void setPayUrl(String payUrl) {
				this.payUrl = payUrl;
			}

			public String getChannelAccountId() {
				return channelAccountId;
			}

			public void setChannelAccountId(String channelAccountId) {
				this.channelAccountId = channelAccountId;
			}
		}
	}

	public PayData getData() {
		return data;
	}

	public void setData(PayData data) {
		this.data = data;
	}
}
