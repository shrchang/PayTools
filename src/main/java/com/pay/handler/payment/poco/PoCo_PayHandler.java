package com.pay.handler.payment.poco;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.poco.pay.Poco_PayRequestParam;
import com.pay.entity.poco.pay.Poco_PayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.common.poco.Base64;
import com.pay.util.common.poco.RSAUtils;
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.JsonUtil;

/**
 * poco支付入口
 * 
 * @ClassName PoCo_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月30日 下午12:18:36
 *
 */
@Handler(PayWay.POCO)
public class PoCo_PayHandler implements PayHandler {

	private static Logger logger = LoggerFactory.getLogger(PoCo_PayHandler.class);

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		try {
			// 获取参数
			Poco_PayRequestParam param = JsonUtil.getObjectByJsonStr(requestParam, Poco_PayRequestParam.class);
			// 第二部获取签名
			param.getSignStr();
			// 第一步验证参数是否完整
			param.validate();
			logger.info("签名字符串：" + param.getSign());
			// 第三步加密并且封装请求
			String url = param.getUrl() + "?method=" + param.getMethod() + "&pid=" + param.getPid() + "&randstr="
					+ param.getRandstr() + "&sign=" + param.getSign() + "&timestamp=" + param.getTimestamp();
			logger.info("poco请求url地址：" + url);
			String data = param.getData().replaceAll("\\\\/", "/").replaceAll("\\\\\\\\", "\\\\");
			byte[] encryptData = RSAUtils.encryptByPublicKey(data.getBytes(), param.getPublicKey()); // 加密数据
			data = Base64.encode(encryptData).replaceAll("\r\n", "");
			logger.info("签名后：" + data);
			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("data", data);
			String retStr = HttpsUtil.sendHttpsRequestWithParam(url, dataMap, "UTF-8");
			logger.info("响应结果：" + retStr);
			Poco_PayResponseEntity entity = JsonUtil.getObjectByJsonStr(retStr, Poco_PayResponseEntity.class);
			return entity;
		} catch (Exception e) {
			logger.error("poco支付报错：", e.getMessage());
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

	/**
	 * poco单独的支付 后续整改
	 * 
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 *            请传入这个Poco_PayRequestParam 最好是调用上面的方法{@link #payMent(String)}
	 * @return
	 * @date 2018年6月30日 下午1:14:06
	 * @return String
	 * @description
	 */
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws PayException {
		try {
			Poco_PayRequestParam param = (Poco_PayRequestParam) urlEntity;
			// 第二部获取签名
			param.getSignStr();
			// 第一步验证参数是否完整
			param.validate();
			logger.info("签名字符串：" + param.getSign());
			// 第三步加密并且封装请求
			String url = param.getUrl() + "?method=" + param.getMethod() + "&pid=" + param.getPid() + "&randstr="
					+ param.getRandstr() + "&sign=" + param.getSign() + "&timestamp=" + param.getTimestamp();
			logger.info("poco请求url地址：" + url);
			String data = param.getData().replaceAll("\\\\/", "/").replaceAll("\\\\\\\\", "\\\\");
			byte[] encryptData = RSAUtils.encryptByPublicKey(data.getBytes(), param.getPublicKey()); // 加密数据
			data = Base64.encode(encryptData).replaceAll("\r\n", "");
			logger.info("签名后：" + data);
			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("data", data);
			String retStr = HttpsUtil.sendHttpsRequestWithParam(url, dataMap, "UTF-8");
			logger.info("响应结果：" + retStr);
			Poco_PayResponseEntity entity = JsonUtil.getObjectByJsonStr(retStr, Poco_PayResponseEntity.class);
			return entity;
		} catch (Exception e) {
			throw new PayException(e.getMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
