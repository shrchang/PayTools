package com.pay.entity.qingcloud.pay;

import com.pay.entity.qingcloud.QCloud_BasicRequestParam;
import com.pay.util.sign.qingcloud.SignUtil;

/**
 * 支付请求参数
 * @ClassName QCloud_PayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月23日 下午5:42:13
 *
 */
public class QCloud_PayRequestParam extends QCloud_BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5070514385734015419L;

	/**
	 * 验证参数是否正确
	 */
	@Override
	public void validate() throws Exception {
		SignUtil.validate(this);
	}

}
