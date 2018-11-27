package com.pay.entity.zgyt.pay;

import org.apache.commons.lang.StringUtils;

import com.pay.entity.zgyt.BasicResponseEntity;
import com.pay.util.text.JsonUtil;

/**
 * 中钢银通的请求数据
 * @ClassName Zgyt_WxOnlinePayResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月10日 下午2:19:29
 *
 */
public class Zgyt_WxOnlinePayResponseEntity extends BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7329574179030845408L;
	/**
	 * 返回的body值
	 */
	public PayResponseBody bodyData;
	

	public PayResponseBody getBodyData() {
		if("0000".equals(this.responseCode)){
			if(StringUtils.isNotBlank(this.sourceData)){
				this.bodyData = JsonUtil.getObjectByJsonStr(this.sourceData, PayResponseBody.class);
			}
		}
		return bodyData;
	}

	public void setBodyData(PayResponseBody bodyData) {
		this.bodyData = bodyData;
	}
}
