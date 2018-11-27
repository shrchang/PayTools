package com.pay.entity.poco.pay;

import com.alibaba.fastjson.JSONObject;
import com.pay.entity.poco.Poco_BasicResponseEntity;

public class Poco_PayResponseEntity extends Poco_BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2845749439463940597L;

	private String merchantNo;// merchant_no 商户号

	private String outPayUrl;// 支付url out_pay_url

	private String resultCode;// 返回凑得 result_code

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOutPayUrl() {
		if(outPayUrl == null){
			if("0".equals(this.getErrcode())){
				JSONObject jsonObject = JSONObject.parseObject(this.getData().replaceAll("\\\\/", "/").replaceAll("\\\\\\\\", "\\\\"));
				if(jsonObject.containsKey("out_pay_url")){
					outPayUrl = jsonObject.getString("out_pay_url");
				}
			}
		}
		return outPayUrl;
	}

	public void setOutPayUrl(String outPayUrl) {
		this.outPayUrl = outPayUrl;
	}

	public String getResultCode() {
		if(resultCode == null){
			if("0".equals(this.getErrcode())){
				JSONObject jsonObject = JSONObject.parseObject(this.getData().replaceAll("\\\\/", "/").replaceAll("\\\\\\\\", "\\\\"));
				if(jsonObject.containsKey("result_code")){
					resultCode = jsonObject.getString("result_code");
				}
			}
		}
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
}
