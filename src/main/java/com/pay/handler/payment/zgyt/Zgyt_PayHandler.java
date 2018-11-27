package com.pay.handler.payment.zgyt;

import java.util.Map;

import org.apache.log4j.Logger;

import com.pay.annotation.Handler;
import com.pay.constant.PaymentTypeEnum;
import com.pay.constant.ServiceNameEnum;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.zgyt.pay.Zgyt_WxOnlinePayRequestParam;
import com.pay.entity.zgyt.pay.Zgyt_WxOnlinePayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.JsonUtil;

/**
 * 中钢银通的支付处理
 * @ClassName Zgyt_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 下午12:53:32
 *
 */
@Handler(PayWay.ZGYT)
public class Zgyt_PayHandler implements PayHandler {
	
	private Logger logger = Logger.getLogger(Zgyt_PayHandler.class);

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		return null;
	}

	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		//强制转化
		Zgyt_WxOnlinePayRequestParam param = (Zgyt_WxOnlinePayRequestParam)urlEntity;
		//获取参数
		Map<String,String> paramMap = param.getParamMap();
		String body = JsonUtil.getJsonStrByObj(paramMap);
		logger.info("请求参数：" + body);
		//执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), body, param.getCharset());
		logger.info("打印响应结果：" + res);
		Zgyt_WxOnlinePayResponseEntity entity = JsonUtil.getObjectByJsonStr(res, Zgyt_WxOnlinePayResponseEntity.class);
		
		logger.info("打印body结果：" +  JsonUtil.getJsonStrByObj(entity.getBodyData()));
		return entity;
	}

	@Override
	public BaseUrlEntity queryOrderContent(String requestParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseUrlEntity refund(String requestParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseUrlEntity refundQuery(String requestParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args)throws Exception {
		Zgyt_PayHandler handler = new Zgyt_PayHandler();
		Zgyt_WxOnlinePayRequestParam param = new Zgyt_WxOnlinePayRequestParam();
		param.setServiceName(ServiceNameEnum.SUBMITORDER.toString());
		param.setPaymentType(PaymentTypeEnum.PAYWXSERVICE.toString());
		param.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
		param.setMchCreateIp("127.0.0.1");
		param.setTotalFee("2000");
		param.setNotifyUrl("http://www.bejson.com/");
		param.setCallbackUrl("https://www.cnblogs.com/");
		param.setBody("测试商品");
		handler.pay(param);
	}

}
