package com.pay.constant;

import com.pay.enums.PayWay;

/**
 * 支付用到的常量池
 * @ClassName Const
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月31日 下午5:40:22
 *
 */
public class Const {
	
	//********************poco*************************
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 下单接口
	 */
	public static final String DIRECT_PAY_TRADE="com.post.merchant.pay.directPay.trade";				//下单接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 下单查询接口
	 */
	public static final String OPERATEORDER_VIEW="com.post.merchant.order.operateorder.view";			//下单查询接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 代支付接口
	 */
	public static final String PROXY_PAY="com.post.merchant.proxy.pay.proxypay";						//代支付接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 代支付查询接口
	 */
	public static final String PROXY_QUERY="com.post.merchant.proxy.pay.proxyquery";					//代支付查询接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * wap支付接口
	 */
	public static final String WAP_PAY="com.post.merchant.wap.wapPay.create";							//wap支付接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * wap查询接口
	 */
	public static final String WAP_QUERY="com.post.merchant.wap.wapPay.query";						//wap查询接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 网关支付接口
	 */
	public static final String GATEWAY_PAY="com.post.merchant.gateway.OrderPay.Create";				//网关支付接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 网关查询接口
	 */
	public static final String GATEWAY_QUERY="com.post.merchant.gateway.OrderQuery.Item";				//网关查询接口
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 微信支付方式，暂未用
	 */
	public static final String PMT_TAG_WECHAT="weixin";							//微信支付方式，暂未用
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * qq支付方式
	 */
	public static final String PMT_TAG_TYPE_QQ="qq";							//qq支付方式
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 支付场景，暂未用
	 */
	public static final String PMT_TAG_ALI_PAY = "alipay";
	
	/**
	 * {@link PayWay#POCO} 用于poco支付
	 * 支付场景，暂未用
	 */
	public static final String PAY_TYPE_SWEPT="swept";							//支付场景，暂未用
	
	//********************poco*************************

	//***************************青云支付类型**************************
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 支付宝wap
	 */
	public static final String QCLOUD_ALIPAY_WAP="1201";//支付宝wap
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 支付宝扫码
	 */
	public static final String QCLOUD_ALIPAY_SCAN="1202";//支付宝扫码
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 微信wap
	 */
	public static final String QCLOUD_WEINXI_WAP="1203";//微信wap
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 微信扫码
	 */
	public static final String QCLOUD_WEINXI_SCAN="1204";//微信扫码
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 微信公众号
	 */
	public static final String QCLOUD_WEINXI_PUBLICNUM="1205";//微信公众号
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * qq wap
	 */
	public static final String QCLOUD_QQ_WAP="1206";//qq wap
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 微信条形码
	 */
	public static final String QCLOUD_WEINXI_BAR_CODE="1207";//微信条形码
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 银联快捷
	 */
	public static final String QCLOUD_UNION_PAY_SHORTCUT="1208";//银联快捷
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 网银支付
	 */
	public static final String QCLOUD_NET_SILVER_GATEWAY="1209";//网银支付
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 银联扫码
	 */
	public static final String QCLOUD_UNION_PAY_SCAN="1210";//银联扫码
	
	/**
	 * {@link PayWay#QCLOUD} 青云支付
	 * 京东钱包
	 */
	public static final String QCLOUD_JD_WALLET="1211";//京东钱包
	//***************************青云支付类型**************************
	
	//***************************海豚支付类型**************************
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 微信公众号
	 */
	public static final String KCLOUD_WEINXI_PUBLICNUM="901";//微信公众号
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 微信扫码
	 */
	public static final String KCLOUD_WEINXI_SCAN="902";//微信扫码
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 支付宝扫码
	 */
	public static final String KCLOUD_ALIPAY_SCAN="903";//支付宝扫码
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 支付宝手机
	 */
	public static final String KCLOUD_ALIPAY_PHONE="904";//支付宝手机
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 网银支付
	 */
	public static final String KCLOUD_NET_SILVER_GATEWAY="907";//网银支付
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 微信刷卡
	 */
	public static final String KCLOUD_WEIXIN_CARD="908";//微信刷卡
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 支付宝刷卡
	 */
	public static final String KCLOUD_ALIPAY_CARD="909";//支付宝刷卡
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 银联扫码
	 */
	public static final String KCLOUD_UNION_PAY_SCAN="912";//银联扫码
	
	/**
	 * {@link PayWay#KCLOUD} 海豚支付
	 * 银联快捷
	 */
	public static final String KCLOUD_UNION_PAY_SHORTCUT="915";//银联快捷
	//***************************海豚支付类型**************************
}
