package com.pay.handler.payment.ypl;

import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.ypl.order.YPL_OrderRequestParam;
import com.pay.entity.ypl.order.YPL_OrderResponseEntity;
import com.pay.entity.ypl.pay.YPL_PayRequestParam;
import com.pay.entity.ypl.pay.YPL_PayResponseEntity;
import com.pay.entity.ypl.refund.YPL_RefundQueryRequestParam;
import com.pay.entity.ypl.refund.YPL_RefundQueryResponseEntity;
import com.pay.entity.ypl.refund.YPL_RefundRequestParam;
import com.pay.entity.ypl.refund.YPL_RefundResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.sign.hfb.SignUtil;
import com.pay.util.text.JsonUtil;
import com.pay.util.text.XmlUtil;

/**
 * 易票联支付
 * 
 * @ClassName YPL_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午10:10:27
 *
 */
@Handler(PayWay.YPL)
public class YPL_PayHandler implements PayHandler {

	private static final Logger logger = LoggerFactory.getLogger(YPL_PayHandler.class);

	private static final String REQUEST_PAY_URL = "http://wx.globalcash.cn/paycenter/v2.0/getoi.do";// 支付请求version4.0
	private static final String REQUEST_QEUERY_URL = "http://wx.globalcash.cn/paycenter/gateways.do";// 查询订单
	private static final String REQUEST_REFUND_URL = "http://wx.globalcash.cn/paycenter/gateways.do";// 退款
	private static final String REQUEST_REFUND_QUERY_URL = "http://wx.globalcash.cn/paycenter/gateways.do";// 退款查询
	private static final String CHAREST_CODE = "GBK";// 默认请求编码

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		try {
			// 第一步转化参数
			YPL_PayRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, YPL_PayRequestParam.class);
			// 第二步验证参数
			param.validate();
			// 第三步获取url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 执行请求
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, pairs, CHAREST_CODE);
			return XmlUtil.convertToBean(retStr, YPL_PayResponseEntity.class);
		} catch (Exception e) {
			logger.error("易票联支付错误：",e.getLocalizedMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(String requestParam) throws Exception {
		try {
			// 第一步转化参数
			YPL_OrderRequestParam orderRequestParam = JsonUtil.getObjectByJsonStr(requestParam,
					YPL_OrderRequestParam.class);
			// 第二部验证参数
			orderRequestParam.validate();
			// 第三步获取最终的签名拼接的url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(orderRequestParam);
			// 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_QEUERY_URL, pairs, CHAREST_CODE);
			// 转化为最终的对象返回
			return XmlUtil.convertToBean(retStr, YPL_OrderResponseEntity.class);
		} catch (Exception e) {
			logger.error("易票联查询订单错误：",e.getLocalizedMessage());
			throw new PayException("易票联查询订单错误："+e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity refund(String requestParam) throws Exception {
		try {
			// 第一步转化参数
			YPL_RefundRequestParam orderRequestParam = JsonUtil.getObjectByJsonStr(requestParam,
					YPL_RefundRequestParam.class);
			// 第二部验证参数
			orderRequestParam.validate();
			// 第三步获取最终的签名拼接的url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(orderRequestParam);
			// 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_REFUND_URL, pairs, CHAREST_CODE);
			// 转化为最终的对象返回
			return XmlUtil.convertToBean(retStr, YPL_RefundResponseEntity.class);
		} catch (Exception e) {
			logger.error("易票联退款错误：",e.getLocalizedMessage());
			throw new PayException("易票联退款错误："+e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity refundQuery(String requestParam) throws Exception {
		try {
			// 第一步转化参数
			YPL_RefundQueryRequestParam orderRequestParam = JsonUtil.getObjectByJsonStr(requestParam,
					YPL_RefundQueryRequestParam.class);
			// 第二部验证参数
			orderRequestParam.validate();
			// 第三步获取最终的签名拼接的url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(orderRequestParam);
			// 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_REFUND_QUERY_URL, pairs, CHAREST_CODE);
			// 转化为最终的对象返回
			return XmlUtil.convertToBean(retStr, YPL_RefundQueryResponseEntity.class);
		} catch (Exception e) {
			logger.error("易票联退款查询错误：",e.getLocalizedMessage());
			throw new PayException("易票联退款查询错误："+e.getLocalizedMessage());
		}
	}

	/**
	 * @param urlEntity {@link YPL_PayRequestParam}
	 */
	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			// 第一步转化参数
			YPL_PayRequestParam param = (YPL_PayRequestParam)urlEntity;
			// 第二步验证参数
			param.validate();
			// 第三步获取url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 执行请求
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, pairs, CHAREST_CODE);
			return XmlUtil.convertToBean(retStr, YPL_PayResponseEntity.class);
		} catch (Exception e) {
			logger.error("易票联支付错误：",e.getLocalizedMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
