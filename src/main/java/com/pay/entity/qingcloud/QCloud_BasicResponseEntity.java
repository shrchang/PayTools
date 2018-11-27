package com.pay.entity.qingcloud;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 青云支付返回参数
 * 
 * @ClassName QCloud_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午5:21:01
 *
 */
public abstract class QCloud_BasicResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7012317106889218887L;

	/**
	 * 返回状态.200表示成功,其它表示失败
	 */
	private String status;

	/**
	 * 返回状态描述.返回SUCCESS表示响应成功,返回其它表示响应失败
	 */
	private String msg;

	/**
	 * 支付通道
	 */
	private String channelId;

	/**
	 * wap支付链接,当channelId为1201,1203,1208,1209,1211时输出
	 */
	private String payUrl;

	/**
	 * 二维码数据链接,可以此来生成二维码图片,当channelId为1202,1204,1207,1210输出
	 */
	private String qrUrl;

	/**
	 * 二维码图片链接,当channelId为1202,1204,1207,1210输出
	 */
	private String qrImgUrl;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}

	public String getQrUrl() {
		return qrUrl;
	}

	public void setQrUrl(String qrUrl) {
		this.qrUrl = qrUrl;
	}

	public String getQrImgUrl() {
		return qrImgUrl;
	}

	public void setQrImgUrl(String qrImgUrl) {
		this.qrImgUrl = qrImgUrl;
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
