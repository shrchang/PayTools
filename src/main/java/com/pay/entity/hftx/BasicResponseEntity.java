package com.pay.entity.hftx;

import com.alibaba.fastjson.annotation.JSONField;
import com.pay.entity.BaseUrlEntity;

/**
 * 基础的响应结果返回
 * @ClassName BasicResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 上午10:03:39
 *
 */
public abstract class BasicResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9061487804383462593L;
	
	/**
	 * 消息类型
	 */
	@JSONField(name="cmd_id")
	private String cmdId;
	
	/**
	 * 应答返回码	
	 */
	@JSONField(name="resp_code")
	private String respCode;
	
	/**
	 * 应答返回描述	
	 */
	@JSONField(name="resp_desc")
	private String respDesc;
	
	/**
	 * 商户客户号
	 */
	@JSONField(name="mer_cust_id")
	private String merCustId;
	
	/**
	 * 订单号
	 */
	@JSONField(name="order_id")
	private String orderId;
	
	/**
	 * 订单日期
	 */
	@JSONField(name="order_date")
	private String orderDate;

	public String getCmdId() {
		return cmdId;
	}

	public void setCmdId(String cmdId) {
		this.cmdId = cmdId;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getMerCustId() {
		return merCustId;
	}

	public void setMerCustId(String merCustId) {
		this.merCustId = merCustId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public abstract boolean isSucess();
}
