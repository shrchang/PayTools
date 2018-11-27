package com.pay.handler.payment.hfb;

import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.hfb.order.HFB_OrderRequestParam;
import com.pay.entity.hfb.order.HFB_OrderResponseEntity;
import com.pay.entity.hfb.pay.HFB_PayBaseRequestParam;
import com.pay.entity.hfb.pay.HFB_PayRetResponseEntity;
import com.pay.entity.hfb.refund.HFB_RefundQueryParam;
import com.pay.entity.hfb.refund.HFB_RefundQueryResponseEntity;
import com.pay.entity.hfb.refund.HFB_RefundRequestParam;
import com.pay.entity.hfb.refund.HFB_RefundResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.sign.hfb.SignUtil;
import com.pay.util.text.JsonUtil;

/**
 * 付汇宝支付处理方法
 * 
 * @ClassName HFB_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午4:37:32
 *
 */
@Handler(PayWay.HFB)
public class HFB_PayHandler implements PayHandler {

	private Logger logger = LoggerFactory.getLogger(HFB_PayHandler.class);

	private static final String REQUEST_PAY_URL = "https://open.heepay.com/aggrPay.do";// 请求路径，因为需要请求http
	private static final String REQUEST_QEUERY_URL = "https://open.heepay.com /aggrMerPayQuery.do";// 查询
	private static final String REQUEST_REFUND_URL = "https://open.heepay.com /aggrRefund.do";// 退款
	private static final String REQUEST_REFUND_QUERY_URL = "https://open.heepay.com /aggrRefundQuery.do";// 退款查询

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		try {
			// 第一步将请求参数转化成我们的对象
			HFB_PayBaseRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, HFB_PayBaseRequestParam.class);
			if (param == null) {
				throw new Exception("请求参数不正确，请验证！");
			}
			// 第二部是验证对象是否存在
			// TODO
			param.validation();
			// 第三步获取最终的签名拼接的url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, pairs);
			// 转化为最终的对象返回
			return JsonUtil.getObjectByJsonStr(retStr, HFB_PayRetResponseEntity.class);
		} catch (Exception e) {
			logger.error("汇付宝支付报错：", e.getLocalizedMessage());
			throw new PayException("汇付宝支付报错：" + e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(String requestParam) throws Exception {
		try {
			// 第一步 请请求参数转化
			HFB_OrderRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, HFB_OrderRequestParam.class);
			if (param == null) {
				throw new Exception("请求参数不正确，请验证！");
			}
			// 第二步 验证参数是不是对
			// TODO
			// 第三步
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 第四步 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_QEUERY_URL, pairs);
			// 返回对象
			return JsonUtil.getObjectByJsonStr(retStr, HFB_OrderResponseEntity.class);
		} catch (Exception e) {
			logger.error("汇付宝查询订单错误：", e.getLocalizedMessage());
			throw new PayException("汇付宝查询订单错误：" + e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity refund(String requestParam) throws Exception {
		try {
			// 第一步 请请求参数转化
			HFB_RefundRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, HFB_RefundRequestParam.class);
			if (param == null) {
				throw new Exception("请求参数不正确，请验证！");
			}
			// 第二步 验证参数是不是对
			// TODO
			// 第三步
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 第四步 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_REFUND_URL, pairs);
			// 返回对象
			return JsonUtil.getObjectByJsonStr(retStr, HFB_RefundResponseEntity.class);
		} catch (Exception e) {
			logger.error("汇付宝退款错误", e.getLocalizedMessage());
			throw new PayException("汇付宝退款错误：" + e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity refundQuery(String requestParam) throws Exception {
		try {
			// 第一步 请请求参数转化
			HFB_RefundQueryParam param = JsonUtil.getObjectByJsonStr(requestParam, HFB_RefundQueryParam.class);
			if (param == null) {
				throw new Exception("请求参数不正确，请验证！");
			}
			// 第二步 验证参数是不是对
			// TODO
			// 第三步
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 第四步 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_REFUND_QUERY_URL, pairs);
			// 返回对象
			return JsonUtil.getObjectByJsonStr(retStr, HFB_RefundQueryResponseEntity.class);
		} catch (Exception e) {
			logger.error("退款查询错误：", e.getLocalizedMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	/**
	 * 汇付宝支付
	 * 
	 * @param BaseUrlEntity
	 *            对应汇付宝的请求参数 {@link HFB_PayBaseRequestParam}
	 */
	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			// 第一步将请求参数转化成我们的对象
			HFB_PayBaseRequestParam param = (HFB_PayBaseRequestParam) urlEntity;
			if (param == null) {
				throw new Exception("请求参数不正确，请验证！");
			}
			// 第二部是验证对象是否存在
			// TODO
			param.validation();
			// 第三步获取最终的签名拼接的url参数集合
			List<NameValuePair> pairs = SignUtil.getHttpPostParam(param);
			// 执行http请求，这里不管是http还是https都是post
			String retStr = HttpsUtil.sendHttpsRequestWithParam(REQUEST_PAY_URL, pairs);
			// 转化为最终的对象返回
			return JsonUtil.getObjectByJsonStr(retStr, HFB_PayRetResponseEntity.class);
		} catch (Exception e) {
			logger.error("汇付宝支付报错：", e.getLocalizedMessage());
			throw new PayException("汇付宝支付报错：" + e.getLocalizedMessage());
		}
	}
	
	public class A{
		
	}

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
