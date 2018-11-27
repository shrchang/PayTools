package com.pay.entity.hfb.pay;

import com.pay.entity.hfb.HFB_BasicResponeEntity;

/**
 * 聚合支付返回的对象
 * 
 * @ClassName HFB_PayRetResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午4:35:45
 *
 */
public class HFB_PayRetResponseEntity extends HFB_BasicResponeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2632567796558404736L;

	private String version = "";// 版本号

	private String subMerchantId = "";// 子商户id

	private String payUrl = "";// 支付的链接

	private String merchantBillNo = "";// 商户订单号

	private PayInfo payInfo;// tradeType为weixin_pub,qq_pub时，且qrCodeStatus=Y时，返回此参数

	class PayInfo {
		// 微信公众号
		private String appId;// 公众号id
		private String timeStamp;// 时间戳
		private String signType;// 签名方式
		// private String package;//订单详情扩展字符串
		private String nonceStr;// 随机字符串
		private String paySign;// 签名
		// qq钱包
		private String tokenId;// qq公众号订单号
		private String pubAcc;// 公众帐号uin
		private String pubAccHint;

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}

		public String getSignType() {
			return signType;
		}

		public void setSignType(String signType) {
			this.signType = signType;
		}

		public String getNonceStr() {
			return nonceStr;
		}

		public void setNonceStr(String nonceStr) {
			this.nonceStr = nonceStr;
		}

		public String getPaySign() {
			return paySign;
		}

		public void setPaySign(String paySign) {
			this.paySign = paySign;
		}

		public String getTokenId() {
			return tokenId;
		}

		public void setTokenId(String tokenId) {
			this.tokenId = tokenId;
		}

		public String getPubAcc() {
			return pubAcc;
		}

		public void setPubAcc(String pubAcc) {
			this.pubAcc = pubAcc;
		}

		public String getPubAccHint() {
			return pubAccHint;
		}

		public void setPubAccHint(String pubAccHint) {
			this.pubAccHint = pubAccHint;
		}// 公众帐号关注提示语
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}

	public String getMerchantBillNo() {
		return merchantBillNo;
	}

	public void setMerchantBillNo(String merchantBillNo) {
		this.merchantBillNo = merchantBillNo;
	}

	public PayInfo getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PayInfo payInfo) {
		this.payInfo = payInfo;
	}
}
