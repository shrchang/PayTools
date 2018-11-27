package com.pay.handler.payment.jl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.jl.pay.JL_PayRequestParam;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.JsonUtil;

/**
 * 佳联支付处理器
 * @ClassName JL_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月28日 下午4:36:09
 *
 */
@SuppressWarnings("unused")
@Handler(PayWay.JL)
public class JL_PayHandler implements PayHandler {
	
	private Logger logger = LoggerFactory.getLogger(JL_PayHandler.class);
	
	private static final String REQUEST_PAY_URL = "http://wxpay.cmbc.com.cn:1080/mobilePlatform/appserver/lcbpPay.do";// 请求路径，因为需要请求http
	private static final String REQUEST_QEUERY_URL = "https://open.heepay.com /aggrMerPayQuery.do";// 查询
	private static final String REQUEST_REFUND_URL = "https://open.heepay.com /aggrRefund.do";// 退款
	private static final String REQUEST_REFUND_QUERY_URL = "https://open.heepay.com /aggrRefundQuery.do";// 退款查询
	
	private static final String DEFAULT_CHARSET="UTF-8";

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		try {
			//第一步转化请求参数
			JL_PayRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, JL_PayRequestParam.class);
			//转码添加参数
			param.setContextJson(JsonUtil.getJsonStrByObj(param,true));
			//第二部验证
			param.validate();
			//第三步获取请求参数
			String json = param.getRequestStringEntity();
			//请求
			String retJson = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, json, DEFAULT_CHARSET);
			logger.info("打印输出结果：" + retJson);
			return null;
		} catch (Exception e) {
			logger.error("乐有银支付报错：",e.getLocalizedMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(String requestParam) throws Exception {
		return null;
	}

	@Override
	public BaseUrlEntity refund(String requestParam) throws Exception {
		return null;
	}

	@Override
	public BaseUrlEntity refundQuery(String requestParam) throws Exception {
		return null;
	}

	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			//第一步转化请求参数
			JL_PayRequestParam param = (JL_PayRequestParam)urlEntity;
			//转码添加参数
			param.setContextJson(JsonUtil.getJsonStrByObj(param,true));
			//第二部验证
			param.validate();
			//第三步获取请求参数
			String json = param.getRequestStringEntity();
			//请求
			String retJson = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, json, DEFAULT_CHARSET);
			logger.info("打印输出结果：" + retJson);
			return null;
		} catch (Exception e) {
			logger.error("乐有银支付报错：",e.getLocalizedMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
