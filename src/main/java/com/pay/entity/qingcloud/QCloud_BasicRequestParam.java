package com.pay.entity.qingcloud;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.constant.Const;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.qingcloud.SignUtil;

/**
 * 青云支付 http://47.106.77.144:3020/api/pay/create_order 10000056
 * 
 * @ClassName QCloud_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午5:21:01
 *
 */
public abstract class QCloud_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1514147539125198808L;

	/**
	 * 商户号
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String mchId = "10000056";

	/**
	 * 订单号
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String mchOrderNo;

	/**
	 * 支付类型 支付通道. 1201:支付宝wap. 1202:支付宝扫码 1203:微信wap 1204:微信扫码 1205:微信公众号
	 * 1206:QQwap 1207:微信条形码 1208:银联快捷 1209:网银网关 1210:银联扫码 1211:京东钱包
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String channelId;

	/**
	 * 单位分
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String amount;

	/**
	 * 支付结果通知地址,由商户提供
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String notifyUrl;

	/**
	 * 支付成功时的跳转地址
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String redirectUrl;

	/**
	 * 商品名称,尽量用英文或拼音,不要用中文
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String subject;

	/**
	 * 商品描述 ,尽量用英文或拼音,不要用中文
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String body;

	/**
	 * 用户真实IP地址,建议传真实IP，不然成功率会大幅度降低
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true)
	private String clientIp;

	/**
	 * 贵方系统中的唯一会员ID 仅在快捷支付时候需要使用
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_UNION_PAY_SHORTCUT)
	private String uid;

	/**
	 * 银行代码,仅在channelId为1209时需要
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_NET_SILVER_GATEWAY)
	private String bankCode;

	/**
	 * 身份证号码,仅在channelId为1208时需要
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_UNION_PAY_SHORTCUT)
	private String cardId;

	/**
	 * 银行卡号,仅在channelId为1208时需要
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_UNION_PAY_SHORTCUT)
	private String bankCardNo;

	/**
	 * 手机号码,仅在channelId为1208时需要
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_UNION_PAY_SHORTCUT)
	private String phone;

	/**
	 * 持卡人姓名,仅在channelId为1208时需要
	 */
	@PayRequestParamLabel(isRequired=true,isSign=true,signField="channelId",signOptions=Const.QCLOUD_UNION_PAY_SHORTCUT)
	private String bankCardName;

	/**
	 * 支付地址 sortIndex不等于0 这个不传入服务端
	 */
	@PayRequestParamLabel(isRequired = true,sortIndex=1)
	private String url;

	/**
	 * 签名密钥
	 */
	@PayRequestParamLabel(isRequired = true,isSign=true,sortIndex=1)
	private String key;

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchOrderNo() {
		return mchOrderNo;
	}

	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
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

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankCardName() {
		return bankCardName;
	}

	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSign() {
		try {
			if(this.sign == null)
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
	 * 验证参数
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年7月23日 下午6:10:05
	 * @return void
	 * @description
	 */
	public abstract void validate()throws Exception;

}
