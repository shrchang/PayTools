package com.pay.test.jl;

import java.net.URL;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.entity.jl.pay.JL_PayRequestParam;
import com.pay.handler.payment.jl.JL_PayHandler;
import com.pay.util.DateUtil;
import com.pay.util.text.JsonUtil;

/**
 * 佳联微信测试
 * 
 * @ClassName PayHandlerTest
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月28日 下午3:31:01
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
	
	
	public static void testPay()throws Exception{
		Date now = new Date();
		JL_PayRequestParam param = new JL_PayRequestParam();
		param.setOrderInfo("测试支付订单");
		param.setMerchantSeq("A00012017050000000545"+(now.getTime()));
		param.setTransDate(DateUtil.getStrByDate(now, "yyyyMMdd"));
		param.setTransTime(DateUtil.getStrByDate(now, "yyyyMMddHHmmssSSS"));
		String paramStr = JsonUtil.getJsonStrByObj(param);
		logger.info("传入的参数：" + paramStr);
		JL_PayHandler handler = new JL_PayHandler();
		handler.payMent(paramStr);
	}
	

	public static void main(String[] args) throws Exception {
//		String json = "{\"businessContext\":\"MIIDuAYKKoEcz1UGAQQCA6CCA6gwggOkAgECMYGdMIGaAgECgBS1x/e/puEJbLQnTtwm2y/"
//				+ "+fP1b2jANBgkqgRzPVQGCLQMFAARwRtCWtpHR3M5LzpCHgWIbNlUUDCrDSieJxfAX3W2scQ9XqvmHrhNClIUzq07HQ8ik/77bJpW"
//				+ "V6K63m3I5zYwId8u7RJ3TwGjeArx1xJoVndAogOBprp7ZoNCmGMxgqYRfDcHFKlH3SfntxT0kDq7CRTCCAv0GCiqBHM9VBgEEAgEw"
//				+ "GwYHKoEcz1UBaAQQtTgyY6lCO3Yuk2ynb2+ViICCAtAqLwsS3NpjIgPJsFA/h54mNIdKcHrgBOeTrYwC3eKyKND2ZZRh6JPbpCXz4Q"
//				+ "MO5Wfq9MpdE7zn53Xr/NBcdNKo+m1mNlbuI/Fugb60ydpctuxZNfICpTO7gPmsX5BqW+kxaov1xFXjUWUyS+ZX3tBtZHxCtzuB1/L+qVuI"
//				+ "4kR7lPUDES7EJY8oVGUON2d096l6WUFUJ1GrDua4Qk6TaMOS1gJDVAM7pjncvDjDfAhe3OPuWzxeSDaOVXolBwT8j+gPSckNUPc8YtsQaTM"
//				+ "Xksm5xycJwp1q81ZTyp5ncJDUPnR4V7TJ4kZJTK1b5T6cS4oP3n0uAIsDw9VwZgdkDcc1zYkTAT4Z+h3+9o376QPGo3rhv8/11Q3iIJdmSU"
//				+ "1lqETA6wr1Zaphyxn9pe+EpbofiZa3vpuzyTAxJQTDlUwujfeUv4/tCUVEPwYc9Q/TQxZf0r7+VJBoFV/6Ipb06zTv1mLGBW/EHt2GqNkfVk"
//				+ "soiho8jK4nnnJc6KtI3f7ADgDX2IqEpwrTkKElOXVWQZB5HXNmVnsnTM9a7YeGyyIbdC5kA/RuPxvCukaK4fq30R0FtaUKopXV1PSgcjhskbD"
//				+ "8SqRdnLrlge5jJPeJPo9yJ7IpW9tXSxVJJ+xSjrSbPUe0yVDgEEgJbI2+9KVMVdiOfr59bMoZ55jaQOnfkzs+lS/prWRbIBPkXar0NJpD"
//				+ "hQOmvTcKeDdERGi0q9vycVR45XNWmGuLBRbC2WOUGDfqrjOTbSvFoE/yr4XDi/0PjtyGPFt2JVD2qaSFNjD2r6BxU05pGmfjE3ByIRE"
//				+ "3PaWQKfL6yPaBEQ5G87p3JTt3Gw557h/a9bsVYN+q3ReD0mw1UfePswnsMCHjKzZokPbsv2K0REjBDrdbhpVyCQ6gwRkeJwksVVMKF0I"
//				+ "tReqhL0kfMHZqCYV05iKpGAXBsHtdSpg1p1CAV1GBlU7QgW6fTkM=\"}";
//		String url = "http://wxpay.cmbc.com.cn:1080/mobilePlatform/appserver/lcbpPay.do";
//		String retStr = HttpsUtil.sendHttpsRequestWithParam(url, json, "UTF-8");
//		System.out.println(retStr);
		testPay();
	}

}
