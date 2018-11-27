package com.pay.handler.payment.qingcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.qingcloud.pay.QCloud_PayRequestParam;
import com.pay.entity.qingcloud.pay.QCloud_PayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.sign.qingcloud.SignUtil;
import com.pay.util.text.JsonUtil;

/**
 * 青云支付对接（客户要求支付宝）
 * 
 * @ClassName QCloud_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午5:24:28
 *
 */
@Handler(PayWay.QCLOUD)
public class QCloud_PayHandler implements PayHandler {

	private Logger logger = LoggerFactory.getLogger(QCloud_PayHandler.class);

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		try {
			// 强制转化
			logger.info("获取支付参数");
			QCloud_PayRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, QCloud_PayRequestParam.class);
			// 获取签名
			logger.info("获取支付参数签名");
			param.getSign();
			// 验证参数
			logger.info("验证支付参数");
			param.validate();
			// 获取需要执行的参数
			String json = SignUtil.getHttpPostParam(param);
			logger.info("最终请求参数：" + json);
			// 执行命令
			String result = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), json, "UTF-8");
			// 打印这个数据
			logger.info("执行结果：" + result);
			return JsonUtil.getObjectByJsonStr(result, QCloud_PayResponseEntity.class);
		} catch (Exception e) {
			logger.error("青云支付报错：", e.getMessage());
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			// 强制转化
			logger.info("获取支付参数");
			QCloud_PayRequestParam param = (QCloud_PayRequestParam) urlEntity;
			// 获取签名
			logger.info("获取支付参数签名");
			param.getSign();
			// 验证参数
			logger.info("验证支付参数");
			param.validate();
			// 获取需要执行的参数
			String json = SignUtil.getHttpPostParam(param);
			logger.info("最终请求参数：" + json);
			// 执行命令
			String result = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), json, "UTF-8");
			// 打印这个数据
			logger.info("执行结果：" + result);
			return JsonUtil.getObjectByJsonStr(result, QCloud_PayResponseEntity.class);
		} catch (Exception e) {
			logger.error("青云支付报错：", e.getMessage());
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
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
