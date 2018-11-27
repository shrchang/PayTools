package com.pay.handler.payment.huichao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.huichao.order.HC_OrderQueryRequestParam;
import com.pay.entity.huichao.order.HC_OrderQueryResponseEntity;
import com.pay.entity.huichao.pay.HC_ScanPayRequestParam;
import com.pay.entity.huichao.pay.HC_ScanPayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.common.poco.Base64;
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.JsonUtil;
import com.pay.util.text.XmlUtil;

/**
 * 汇潮支付
 * @ClassName Hc_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月3日 下午4:38:55
 *
 */
@Handler(PayWay.HUICHAO)
public class Hc_PayHandler implements PayHandler {
	
	private static Logger logger = LoggerFactory.getLogger(Hc_PayHandler.class);

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		return null;
	}

	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			// 强制转化
			logger.info("获取支付参数");
			HC_ScanPayRequestParam param = (HC_ScanPayRequestParam)urlEntity;
			// 获取签名
			logger.info("获取支付参数签名");
			param.getSignInfo();
			// 验证参数
			logger.info("验证支付参数");
			param.validate();
			// 获取需要执行的参数
			String xmlBody = XmlUtil.covertToXML(param);
			logger.info("最终请求参数：" + xmlBody);
			System.out.println("最终请求参数：" + xmlBody);
			List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
			valuePairs.add(new BasicNameValuePair("requestDomain", Base64.encode(xmlBody.getBytes())));
			// 执行命令
			String result = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), valuePairs, "UTF-8");
			// 打印这个数据
			logger.info("响应结果：" + result);
			System.out.println("响应结果："+result);
			HC_ScanPayResponseEntity entity = XmlUtil.convertToBean(result, HC_ScanPayResponseEntity.class);
			logger.info("最后的结果：" + JsonUtil.getJsonStrByObj(entity));
			System.out.println("最后的结果：" + JsonUtil.getJsonStrByObj(entity));
			return entity;
		} catch (Exception e) {
			logger.error("汇潮支付报错：", e.getMessage());
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
		try {
			HC_OrderQueryRequestParam param = (HC_OrderQueryRequestParam)urlEntity;
			param.getSign();
			param.validate();
			String xmlBody = XmlUtil.covertToXML(param);
			List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
			valuePairs.add(new BasicNameValuePair("requestDomain", Base64.encode(xmlBody.getBytes())));
			String result = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), valuePairs, "UTF-8");
			System.out.println("响应结果：" + result);
			HC_OrderQueryResponseEntity entity = XmlUtil.convertToBean(result, HC_OrderQueryResponseEntity.class);
			System.out.println("执行结果：" + JsonUtil.getJsonStrByObj(entity));
			return entity;
		} catch (Exception e) {
			throw new PayException(e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) throws Exception {
		Hc_PayHandler handler = new Hc_PayHandler();
		HC_ScanPayRequestParam param = new HC_ScanPayRequestParam();
		handler.pay(param);
//		HC_OrderQueryRequestParam param = new HC_OrderQueryRequestParam();
//		handler.queryOrderContent(param);
	}

}
