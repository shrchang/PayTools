package com.pay.handler.payment.kancloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.annotation.Handler;
import com.pay.entity.BaseUrlEntity;
import com.pay.entity.kancloud.pay.KCloud_PayRequestParam;
import com.pay.entity.kancloud.pay.KCloud_PayResponseEntity;
import com.pay.enums.PayWay;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.sign.kancloud.SignUtil;
import com.pay.util.text.JsonUtil;

/**
 * 海豚支付处理
 * @ClassName KCloud_PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月24日 上午9:47:13
 *
 */
@Handler(PayWay.KCLOUD)
public class KCloud_PayHandler implements PayHandler {
	
	private Logger logger = LoggerFactory.getLogger(KCloud_PayHandler.class);

	@Override
	public BaseUrlEntity payMent(String requestParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseUrlEntity pay(BaseUrlEntity urlEntity) throws Exception {
		try {
			logger.info("******确认参数******");
			//先转化为具体实体
			KCloud_PayRequestParam param = (KCloud_PayRequestParam)urlEntity;
			logger.info("******获取参数签名******");
			//获取签名
			param.getSign();
			logger.info("******验证参数是否合法******");
			//验证参数
			param.validate();
			//获取执行参数
			String jsonParam = SignUtil.getHttpPostParam(param);
			logger.info("获取执行参数："+jsonParam);
			//执行方法
			String result = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), jsonParam, "UTF-8");
			logger.info("返回请求响应结果：" + result);
			//转化为最终对象
			return JsonUtil.getObjectByJsonStr(result, KCloud_PayResponseEntity.class);
		} catch (Exception e) {
			logger.error("海豚支付失败：",e);
			throw new PayException(e.getLocalizedMessage());
		}
	}

	@Override
	public BaseUrlEntity queryOrderContent(String requestParam) throws Exception {
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

	@Override
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
