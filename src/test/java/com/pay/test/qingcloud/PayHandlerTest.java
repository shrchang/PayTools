package com.pay.test.qingcloud;

import java.net.URL;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;

import com.pay.constant.Const;
import com.pay.entity.qingcloud.pay.QCloud_PayRequestParam;
import com.pay.enums.PayWay;
import com.pay.factory.PayHandlerFactory;
import com.pay.handler.payment.PayHandler;
import com.pay.util.encrypt.Md5;

/**
 * 青云支付
 * @ClassName PayHandlerTest
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月24日 上午9:28:38
 *
 */
public class PayHandlerTest {
	
	/**
	 * 加载log4j的日志配置
	 */
	static{
		URL url = Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
		PropertyConfigurator.configure(url);
	}
	
	
	/**
	 * 测试了微信支付 其余的一样
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年6月27日 下午6:39:49
	 * @return void
	 * @description
	 */
	public static void testPay()throws Exception{
		QCloud_PayRequestParam param = new QCloud_PayRequestParam();
		param.setAmount("100");
		param.setBankCardName("");
		param.setBankCardNo("");
		param.setBankCode("");
		param.setBody("测试");
		param.setCardId("");
		param.setChannelId(Const.QCLOUD_ALIPAY_WAP);
		param.setClientIp("127.0.0.1");
		param.setKey("ec8a4c44ab8c13ee037dae634255812f");
		param.setMchId("10000056");
		param.setMchOrderNo(new Date().getTime()+"");
		param.setNotifyUrl("http://www.baidu.com");
		param.setPhone("");
		param.setRedirectUrl("http://www.baidu.com");
		param.setSubject("测试");
		param.setUid("");
		param.setUrl("http://47.106.77.144:3020/api/pay/create_order");
		PayHandler handler = PayHandlerFactory.getPayHandler(PayHandler.class, PayWay.QCLOUD);
		handler.pay(param);
	}
	
	public static void main(String[] args) throws Exception{
//		testPay();
		String str = "amount=2000&mchOrderNo=R2009222018032720294075694&payOrderId=P0020180327202940000001&status=3&key=ec8a4c44ab8c13ee037dae634255812f";
		System.out.println(Md5.encode(str).toUpperCase());
	}

}
