package com.pay.entity.ypl.refund;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.ypl.YPL_BasicResponseEntity;

/**
 * 退款查询响应返回数据
 * 
 * @ClassName YPL_RefundResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月27日 下午6:17:45
 *
 */
@XmlAlias(name = "root")
public class YPL_RefundQueryResponseEntity extends YPL_BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5968769959527918596L;

	/**
	 * 版本号
	 */
	@XmlField(name = "version")
	private String version;

	/**
	 * 填写签名私钥证书的Serial Number
	 */
	@XmlField(name = "certId")
	private String certId;

	/**
	 * 商户系统退款单号
	 */
	@XmlField(name = "out_refund_no")
	private String outRefundNo;

	/**
	 * 易票联网关系统退款单号
	 */
	@XmlField(name = "refund_id")
	private String refundId;

	/**
	 * 格式：元.角分，单位是元。可以做部分退款，累计退款总金额不能超过订单总金额。
	 */
	@XmlField(name = "refund_amount")
	private String refundAmount;

	/**
	 * 0未处理，1退款成功，2退款失败
	 */
	@XmlField(name = "refund_result")
	private String refundResult;

	/**
	 * 格式：YYYYMMDDHHMISS
	 */
	@XmlField(name = "refund_time")
	private String refundTime;

	/**
	 * 格式：YYYYMMDDHHMISS
	 */
	@XmlField(name = "create_time")
	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundResult() {
		return refundResult;
	}

	public void setRefundResult(String refundResult) {
		this.refundResult = refundResult;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

}
