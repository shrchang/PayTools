package com.pay.entity.huichao.pay;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 微信支付返回的数据
 * 
 * @ClassName HC_ScanPayResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月4日 下午4:27:05
 *
 */
@XmlAlias(name = "ScanPayResponse")
public class HC_ScanPayResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5551293018716386575L;

	/**
	 * 0000 是同步请求响应成功 88是支付成功
	 */
	@XmlField(name="respCode")
	private String respCode;

	/**
	 * 返回的信息
	 */
	@XmlField(name="respMsg")
	private String respMsg;

	/**
	 * 二维码
	 */
	@XmlField(name="qrCode")
	private String qrCode;

	/**
	 * 汇潮订单号
	 */
	@XmlField(name="orderNo")
	private String orderNo;

	/**
	 * 平台订单号
	 */
	@XmlField(name="BillNo")
	private String BillNo;

	/**
	 * 金额
	 */
	@XmlField(name="Amount")
	private String Amount;

	/**
	 * 商户号
	 */
	@XmlField(name="MerNo")
	private String MerNo;

	/**
	 * 支付方式
	 */
	@XmlField(name="payType")
	private String payType;

	/**
	 * 产品描述
	 */
	@XmlField(name="products")
	private String products;

	/**
	 * 备注
	 */
	@XmlField(name="remark")
	private String remark;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBillNo() {
		return BillNo;
	}

	public void setBillNo(String billNo) {
		BillNo = billNo;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getMerNo() {
		return MerNo;
	}

	public void setMerNo(String merNo) {
		MerNo = merNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
