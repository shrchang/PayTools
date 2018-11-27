package com.pay.handler.payment.hftx;

import java.util.Map;

import org.apache.log4j.Logger;

import com.pay.entity.BaseUrlEntity;
import com.pay.entity.hftx.payment.app.request.Hftx_QuickBackPayMentRequestParam;
import com.pay.entity.hftx.payment.app.response.Hftx_QuickBackPayMentResponseEntity;
import com.pay.entity.hftx.user.account.request.Hftx_AccountQueryRequestParam;
import com.pay.entity.hftx.user.account.response.Hftx_AccountQueryResponseEntity;
import com.pay.entity.hftx.user.bank.request.Hftx_BindBankCashCardRequestParam;
import com.pay.entity.hftx.user.bank.request.Hftx_BindBankQueryRequestParam;
import com.pay.entity.hftx.user.bank.response.Hftx_BindBankCashCardResponseEntity;
import com.pay.entity.hftx.user.bank.response.Hftx_BindBankQueryResponseEntity;
import com.pay.entity.hftx.user.enchashment.request.Hftx_BankEnchashmentBindRequestParam;
import com.pay.entity.hftx.user.enchashment.request.Hftx_BankEnchashmentRequestParam;
import com.pay.entity.hftx.user.enchashment.request.Hftx_BankEnchashmentUnBindRequestParam;
import com.pay.entity.hftx.user.enchashment.response.Hftx_BankEnchashmentBindResponseEntity;
import com.pay.entity.hftx.user.enchashment.response.Hftx_BankEnchashmentResponseEntity;
import com.pay.entity.hftx.user.enchashment.response.Hftx_BankEnchashmentUnBindResponseEntity;
import com.pay.entity.hftx.user.manage.request.Hftx_PersonOpenRequestParam;
import com.pay.entity.hftx.user.manage.response.Hftx_PersonOpenResponseEntity;
import com.pay.entity.hftx.user.transfer.request.Hftx_TransferRequestParam;
import com.pay.entity.hftx.user.transfer.response.Hftx_TransferResponseEntity;
import com.pay.exception.PayException;
import com.pay.handler.payment.PayMentHandler;
import com.pay.util.http.HttpsUtil;
import com.pay.util.sign.hftx.PayUtil;
import com.pay.util.text.JsonUtil;

/**
 * 汇付天下支付集中管理
 * 
 * @ClassName Hftx_PayMentHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午3:00:47
 *
 */
public class Hftx_PayMentHandler implements PayMentHandler {

	private Logger logger = Logger.getLogger(Hftx_PayMentHandler.class);

	@Override
	public BaseUrlEntity personOpen(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_PersonOpenRequestParam param = (Hftx_PersonOpenRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("个人用户开户请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("个人用户开户解密结果：" + ret);
		// 转化对象
		Hftx_PersonOpenResponseEntity entity = JsonUtil.getObjectByJsonStr(ret, Hftx_PersonOpenResponseEntity.class);

		return entity;
	}

	@Override
	public BaseUrlEntity bindBankCard(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_BankEnchashmentBindRequestParam param = (Hftx_BankEnchashmentBindRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("绑定取现卡请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("绑定取现卡解密结果：" + ret);
		// 转化对象
		Hftx_BankEnchashmentBindResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_BankEnchashmentBindResponseEntity.class);

		return entity;
	}

	@Override
	public BaseUrlEntity unBindBankCard(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_BankEnchashmentUnBindRequestParam param = (Hftx_BankEnchashmentUnBindRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("解绑银行卡请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("解绑银行卡解密结果：" + ret);
		// 转化对象
		Hftx_BankEnchashmentUnBindResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_BankEnchashmentUnBindResponseEntity.class);

		return entity;
	}

	@Override
	public BaseUrlEntity transfer(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_TransferRequestParam param = (Hftx_TransferRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("转账请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("转账解密结果：" + ret);
		// 转化对象
		Hftx_TransferResponseEntity entity = JsonUtil.getObjectByJsonStr(ret, Hftx_TransferResponseEntity.class);

		return entity;
	}

	@Override
	public BaseUrlEntity enchashment(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_BankEnchashmentRequestParam param = (Hftx_BankEnchashmentRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("取现请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("取现解密结果：" + ret);
		// 转化对象
		Hftx_BankEnchashmentResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_BankEnchashmentResponseEntity.class);

		return entity;
	}

	@Override
	public BaseUrlEntity queryBindBankList(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_BindBankQueryRequestParam param = (Hftx_BindBankQueryRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("查询绑卡信息请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("查询绑卡信息解密结果：" + ret);
		// 转化对象
		Hftx_BindBankQueryResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_BindBankQueryResponseEntity.class);
		return entity;
	}

	@Override
	public BaseUrlEntity bindEnchashmentCard(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_BindBankCashCardRequestParam param = (Hftx_BindBankCashCardRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("单独绑定取现卡请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("单独绑定取现解密结果：" + ret);
		// 转化对象
		Hftx_BindBankCashCardResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_BindBankCashCardResponseEntity.class);
		return entity;
	}

	@Override
	public BaseUrlEntity rollBackCard(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_QuickBackPayMentRequestParam param = (Hftx_QuickBackPayMentRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("回滚转账请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("回滚转账解密结果：" + ret);
		// 转化对象
		Hftx_QuickBackPayMentResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_QuickBackPayMentResponseEntity.class);
		return entity;
	}

	@Override
	public BaseUrlEntity queryUserBalance(BaseUrlEntity baseUrlEntity) throws PayException {
		// 1.先强制转换
		Hftx_AccountQueryRequestParam param = (Hftx_AccountQueryRequestParam) baseUrlEntity;
		// 2.获取执行的参数
		Map<String, String> paramMap = param.getRequestParam();
		// 打印一下参数
		logger.info("http请求的参数：" + JsonUtil.getJsonStrByObj(paramMap));
		// 执行请求
		String res = HttpsUtil.sendHttpsRequestWithParam(param.getUrl(), paramMap, "UTF-8");
		logger.info("查询用户资金请求结果：" + res);
		// 解密
		String ret = PayUtil.decryptResponse(res, "100001", param.getTrustCerPath());
		logger.info("查询用户资金结果：" + ret);
		// 转化对象
		Hftx_AccountQueryResponseEntity entity = JsonUtil.getObjectByJsonStr(ret,
				Hftx_AccountQueryResponseEntity.class);
		return entity;
	}

	public static void main(String[] args) {
		try {
			Hftx_PayMentHandler handler = new Hftx_PayMentHandler();
			// Hftx_BankEnchashmentUnBindRequestParam param = new
			// Hftx_BankEnchashmentUnBindRequestParam();
			// param.setCmdId("105");
			// param.setCardId("1000003596");
			// param.setCardBussType("2");
			// param.setUserCustId("6666000000054967");
			// param.setCardMobile("13168334636");
			// param.setBankId(BankEnum.getCodeByName("建设银行"));
			// param.setBgRetUrl("http://kkg.kingdst.com/frontWeb/api/hftxQuickWebPay_doAsynRecvNotify.do");
			// handler.unBindBankCard(param);
			// Hftx_TransferRequestParam param = new
			// Hftx_TransferRequestParam();
			// handler.transfer(param);
			// Hftx_BindBankQueryRequestParam param = new
			// Hftx_BindBankQueryRequestParam();
			// param.setCmdId("318");
			// param.setOrderId(null);
			// param.setOrderDate(null);
			// Hftx_BindBankQueryResponseEntity entity =
			// (Hftx_BindBankQueryResponseEntity) handler
			// .queryBindBankList(param);
			// System.out.println(entity.getCardList());

			// Hftx_TransferRequestParam param = new
			// Hftx_TransferRequestParam();
			// param.setBgRetUrl("http://kkg.kingdst.com/frontWeb/api/hftxQuickWebPay_doAsynRecvNotify.do");
			// param.setCmdId("203");
			// param.setOutCustId("6666000000054889");
			// param.setOutAcctId("65186");
			// param.setInCustId("6666000000054967");
			// param.setInAcctId("65303");
			// param.setTransferAmt("1000.00");
			// handler.transfer(param);

			// Hftx_BankEnchashmentRequestParam param = new
			// Hftx_BankEnchashmentRequestParam();
			// param.setUserCustId("6666000000054967");
			// param.setCmdId("202");
			// param.setTransAmt("1000.00");
			// param.setCashBindCardId("76546");
			// param.setFeeAcctId("65186");
			// param.setBgRetUrl("http://kkg.kingdst.com/frontWeb/api/hftxQuickWebPay_doAsynRecvNotify.do");
			// handler.enchashment(param);

			Hftx_QuickBackPayMentRequestParam param = new Hftx_QuickBackPayMentRequestParam();
			param.setUserCustId("6666000000054967");
			param.setUserAcctId("65303");
			param.setTransAmt("500.00");
			param.setMerCustId("6666000000054889");
			param.setInCustId("6666000000054889");
			param.setCmdId("850");
			param.setInAcctId("65186");
			param.setBgRetUrl("http://kkg.kingdst.com/frontWeb/api/hftxQuickWebPay_doAsynRecvNotify.do");
			param.setBizTransId(param.getOrderId());
			handler.rollBackCard(param);
			
//			Hftx_AccountQueryRequestParam param = new Hftx_AccountQueryRequestParam();
//			param.setCmdId("303");
//			param.setUserCustId("6666000000054967");
//			param.setAcctId("65303");
//			handler.queryUserBalance(param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
