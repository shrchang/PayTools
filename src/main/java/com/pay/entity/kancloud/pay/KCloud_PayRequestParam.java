package com.pay.entity.kancloud.pay;

import com.pay.entity.kancloud.KCloud_BasicRequestParam;
import com.pay.util.sign.kancloud.SignUtil;

/**
 * 海豚支付请求参数
 * @ClassName KCloud_PayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月24日 上午9:41:47
 *
 */
public class KCloud_PayRequestParam extends KCloud_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5239699984592117654L;

	@Override
	public void validate() throws Exception {
		//使用这个进行验证
		SignUtil.validate(this);
	}

}
