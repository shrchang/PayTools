package com.pay.entity.aPay.pay;

import com.pay.entity.aPay.APay_BasicRequestParam;
import com.pay.util.sign.aPay.SignUtil;

/**
 * A支付的请求参数
 * @ClassName APay_PayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午5:01:51
 *
 */
public class APay_PayRequestParam extends APay_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8699554566361340188L;

	@Override
	public void validation() throws Exception {
		//TODO 如果需要实现验证则需要验证
		SignUtil.validate(this);
	}

}
