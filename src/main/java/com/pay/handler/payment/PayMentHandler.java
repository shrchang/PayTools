package com.pay.handler.payment;

import com.pay.entity.BaseUrlEntity;
import com.pay.exception.PayException;

/**
 * 定义全新的支付接口
 * @ClassName PayMentHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:58:15
 *
 */
public interface PayMentHandler {
	
	/**
	 * 用户开户
	 * @author shrChang.Liu
	 * @return
	 * @throws PayException
	 * @date 2018年9月29日 下午2:59:39
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity personOpen(BaseUrlEntity baseUrlEntity)throws PayException;
	
	
	/**
	 * 绑定取现银行卡
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月1日 下午9:37:57
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity bindBankCard(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 解绑行用卡
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月1日 下午10:11:39
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity unBindBankCard(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 商户用户之间转账
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月1日 下午10:30:41
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity transfer(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 取现接口
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月1日 下午10:50:22
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity enchashment(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 查询绑定的银行卡
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月8日 上午10:45:19
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity queryBindBankList(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 单独绑定取现卡
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月8日 下午5:59:52
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity  bindEnchashmentCard(BaseUrlEntity baseUrlEntity)throws PayException;
	
	
	/**
	 * 回滚转账
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月18日 下午3:25:58
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity rollBackCard(BaseUrlEntity baseUrlEntity)throws PayException;
	
	/**
	 * 查询用户资金
	 * @author shrChang.Liu
	 * @param baseUrlEntity
	 * @return
	 * @throws PayException
	 * @date 2018年10月18日 下午4:00:12
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity queryUserBalance(BaseUrlEntity baseUrlEntity)throws PayException;

}
