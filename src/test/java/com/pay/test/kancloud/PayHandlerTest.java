package com.pay.test.kancloud;

import java.net.URL;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;

import com.pay.constant.Const;
import com.pay.entity.kancloud.pay.KCloud_PayRequestParam;
import com.pay.entity.kancloud.pay.KCloud_PayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.factory.PayHandlerFactory;
import com.pay.handler.payment.PayHandler;
import com.pay.util.DateUtil;
import com.pay.util.text.JsonUtil;

/**
 * 海豚支付
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
		KCloud_PayRequestParam param = new KCloud_PayRequestParam();
		param.setApikey("dfa3dd62d8b6f1abb9ff0da6908b3434");
		param.setApplydate(DateUtil.getStrByNow("yyyy-MM-dd HH:mm:ss"));
		param.setAttach("xxx");
		param.setBody("测试商品");
		param.setNotifyUrl("http://www.baidu.com");
		param.setOutTradeNo(new Date().getTime()+"");
		param.setPayAmount("30");
		param.setProductId(Const.KCLOUD_UNION_PAY_SHORTCUT);
		param.setRemark("备注");
		param.setReturnUrl("http://www.baidu.com");
		param.setSubject("测试");
		param.setUrl("http://wallet.donggshenke.com/index/pay/gateway");
		param.setUserId("99");
		PayHandler handler = PayHandlerFactory.getPayHandler(PayHandler.class, PayWay.KCLOUD);
		KCloud_PayResponseEntity entity = (KCloud_PayResponseEntity)handler.pay(param);
		System.out.println(JsonUtil.getJsonStrByObj(entity.getData()));
	}
	
	public static void main(String[] args) throws Exception{
		testPay();
	}

}
