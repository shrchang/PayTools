package com.pay.handler.payment;

import com.pay.entity.BaseUrlEntity;

/**
 * 支付接口，所有调用第三方支付都需要实现这个接口
 * @ClassName PayHandler
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午4:38:53
 *
 */
public interface PayHandler {
	
	/**
	 * 用于支付请求的接口，因为目前只实现了汇付宝、易票联，所以只带有一个json字符串的参数集
	 * @author shrChang.Liu
	 * @param @param requestParam
	 * @param @return
	 * @param @throws Exception
	 * @date 2018年6月21日 下午4:41:18
	 * @return BaseRequestParam 请求参数JSON格式字符串
	 * @description
	 */
	public BaseUrlEntity payMent(String requestParam)throws Exception;
	
	/**
	 * 请求返回
	 * @author shrChang.Liu
	 * @param urlEntity 对应不同的请求参数
	 * @return
	 * @throws Exception
	 * @date 2018年7月3日 上午9:05:29
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity pay(BaseUrlEntity urlEntity)throws Exception;
	
	
	/**
	 * 用于查询订单详细信息
	 * @author shrChang.Liu
	 * @param @param requestParam
	 * @param @return
	 * @param @throws Exception
	 * @date 2018年6月21日 下午5:38:27
	 * @return BaseRequestParam
	 * @description
	 */
	public BaseUrlEntity queryOrderContent(String requestParam)throws Exception;
	
	/**
	 * 查询订单
	 * @author shrChang.Liu
	 * @param urlEntity
	 * @return
	 * @throws Exception
	 * @date 2018年9月4日 下午5:28:45
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity queryOrderContent(BaseUrlEntity urlEntity)throws Exception;
	
	/**
	 * 进行退款
	 * @author shrChang.Liu
	 * @param @param requestParam
	 * @param @return
	 * @param @throws Exception
	 * @date 2018年6月21日 下午6:16:03
	 * @return BaseRequestParam
	 * @description
	 */
	public BaseUrlEntity refund(String requestParam)throws Exception;
	
	/**
	 * 退款查询返回
	 * @author shrChang.Liu
	 * @param @param requestParam
	 * @param @return
	 * @param @throws Exception
	 * @date 2018年6月22日 上午9:29:12
	 * @return BaseUrlEntity
	 * @description
	 */
	public BaseUrlEntity refundQuery(String requestParam)throws Exception;
}
