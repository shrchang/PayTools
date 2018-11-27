package com.pay.test.ypl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.constant.PayType;
import com.pay.entity.ypl.order.YPL_OrderResponseEntity;
import com.pay.entity.ypl.pay.YPL_PayRequestParam;
import com.pay.entity.ypl.pay.YPL_PayResponseEntity;
import com.pay.entity.ypl.refund.YPL_RefundQueryRequestParam;
import com.pay.entity.ypl.refund.YPL_RefundQueryResponseEntity;
import com.pay.entity.ypl.refund.YPL_RefundRequestParam;
import com.pay.entity.ypl.refund.YPL_RefundResponseEntity;
import com.pay.handler.payment.ypl.YPL_PayHandler;
import com.pay.util.common.ypl.Tool;
import com.pay.util.text.JsonUtil;

/**
 * 易票联测试
 * @ClassName PayHandlerTest
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月24日 上午9:28:38
 *
 */
public class PayHandlerTest {
	
	private static Logger logger = LoggerFactory.getLogger(PayHandlerTest.class);
	
	/**
	 * 加载log4j的日志配置
	 */
	static{
		URL url = Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
		PropertyConfigurator.configure(url);
	}
	
	/**
	 * 暂时测试的是查询订单
	 * @author shrChang.Liu
	 * @date 2018年6月24日 上午9:30:40
	 * @return void
	 * @description
	 */
	public static void testQueryOrder(){
		try {
			Date start = new Date();
			String param = "{\"certId\":\"335902764374016746163578510918738695929360058949\",\"outTradeNo\":\"1516185831821\","
					+ "\"partner\":\"130\",\"sign\":\"mFkRj879FG4BPA/Itpa7XvmhE3i+"
					+ "PG/6bFVjeFR093wWQ6bwmHqs59zZ4hrLrQbVC8QiCzLrpSXtmcAFlULepWrBlRHRbAZid5tfqllf13ZrYe4f"
					+ "L93/0dS6g+2Y8nTBJVbqX8fqaQxHiUEeHyxzN6pjVBzzdna2URN5Edz14Riq6dMS8qOm5DsmtC/Rqty"
					+ "MowmFmBmoMIadJeUNnAkuCY/COfWkFJL712i4zblydxefE2vSyJd7CdHpup9FhznEfp1fBe4kblYahQUG0GQ"
					+ "/XB/2+QQNbzNppemZ8BRTcSmsFf1mOgjjwg+wZNZ2Hq1zMZ28VeD7ExqgGb8k22YnEA==\","
					+ "\"signType\":\"SHA256withRSA\",\"transType\":\"query\",\"version\":\"4.0\"}";
			YPL_PayHandler handler = new YPL_PayHandler();
			YPL_OrderResponseEntity entity = (YPL_OrderResponseEntity)handler.queryOrderContent(param);
			System.out.println("耗时毫秒："+(new Date().getTime()-start.getTime()));
			System.out.println("结果：" + JsonUtil.getJsonStrByObj(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		YPL_PayRequestParam param = new YPL_PayRequestParam();
		param.setBase64Memo(Tool.base64encode("IphoneX"));
		param.setCurrencyType("RMB");
		param.setIsRaw("1");
		param.setNotifyUrl("http://www.baidu.com");
		param.setOutTradeNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		//param.setOutTradeNo("20180627172745970");
		param.setPayId(PayType.WXPAY);
		param.setStoreOiType("0");
		param.setSubAppid("wxdac3dd7ffa21c579");
		param.setSubOpenid("ojKWzt_zSJDSxTmIlNlYEO0wYUCQ");
		Calendar now=Calendar.getInstance();
		now.add(Calendar.MINUTE,30);
		param.setTimeOut(new SimpleDateFormat("yyyyMMddHHmmss").format(now.getTimeInMillis()));
		//param.setTimeOut("20180627175745");
		param.setTotalFee("0.01");
		String paramStr = JsonUtil.getJsonStrByObj(param);
		YPL_PayHandler handler = new YPL_PayHandler();
		YPL_PayResponseEntity entity = (YPL_PayResponseEntity)handler.payMent(paramStr);
		logger.info("结果："+JsonUtil.getJsonStrByObj(entity));
	}
	
	/**
	 * 测试退款 暂时是没有订单可以退款的
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年6月27日 下午6:40:02
	 * @return void
	 * @description
	 */
	public static void testRefund()throws Exception{
		YPL_RefundRequestParam param = new YPL_RefundRequestParam();
		param.setOutTradeNo("1516185831821");
		param.setOutRefundNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		param.setRefundAmount("0.01");
		param.setTotalAmount("0.01");
		String paramStr = JsonUtil.getJsonStrByObj(param);
		YPL_PayHandler handler = new YPL_PayHandler();
		YPL_RefundResponseEntity entity = (YPL_RefundResponseEntity)handler.refund(paramStr);
		logger.info("结果："+JsonUtil.getJsonStrByObj(entity));
	}
	
	/**
	 * 退款查询 暂时没有可查
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年6月27日 下午6:40:11
	 * @return void
	 * @description
	 */
	public static void testRefundQuery()throws Exception{
		YPL_RefundQueryRequestParam param = new YPL_RefundQueryRequestParam();
		param.setOutTradeNo("1516185831821");
		String paramStr = JsonUtil.getJsonStrByObj(param);
		YPL_PayHandler handler = new YPL_PayHandler();
		YPL_RefundQueryResponseEntity entity = (YPL_RefundQueryResponseEntity)handler.refundQuery(paramStr);
		logger.info("结果："+JsonUtil.getJsonStrByObj(entity));
	}
	
	public static void main(String[] args) throws Exception{
//		testQueryOrder();
//		testPay();
//		testRefund();
		testRefundQuery();
	}

}
