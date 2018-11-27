package com.pay.entity.ypl.order;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.ypl.YPL_BasicResponseEntity;

/**
 * 易票联查询订单返回实体
 * @ClassName YPL_OrderResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午3:39:32
 *
 */
@XmlAlias(name="root")
public class YPL_OrderResponseEntity extends YPL_BasicResponseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7037692151661044053L;

	@XmlField(name="curr_code")
	private String currCode;//货币代码 人民币：RMB；港币：HKD；美元：USD
	
	@XmlField(name="amount")
	private Double amount;//金额 格式：元.角分，单位是元
	
	@XmlField(name="pay_no")
	private Long payNo;//支付单号
	
	@XmlField(name="pay_result")
	private Integer payResult;//1支付成功，0未支付，2支付失败
	
	@XmlField(name="pay_time")
	private String payTime;//支付 时间格式：YYYYMMDDHHMISS

	
	@XmlField(name="sett_date")
	private String settDate;//清算日期 格式：YYYYMMDD
	
	@XmlField(name="sett_time")
	private String settTime;//清算时间 HHMISS
	
	@XmlField(name="channel_id")
	private String channelId;//支付渠道
	
	@XmlField(name="dec_fee_rate")
	private String decFeeRate;//费率
	
	@XmlField(name="dec_fee")
	private String Double;//手续费 格式：元.角分，单位是元

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getPayNo() {
		return payNo;
	}

	public void setPayNo(Long payNo) {
		this.payNo = payNo;
	}

	public Integer getPayResult() {
		return payResult;
	}

	public void setPayResult(Integer payResult) {
		this.payResult = payResult;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getSettDate() {
		return settDate;
	}

	public void setSettDate(String settDate) {
		this.settDate = settDate;
	}

	public String getSettTime() {
		return settTime;
	}

	public void setSettTime(String settTime) {
		this.settTime = settTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getDecFeeRate() {
		return decFeeRate;
	}

	public void setDecFeeRate(String decFeeRate) {
		this.decFeeRate = decFeeRate;
	}

	public String getDouble() {
		return Double;
	}

	public void setDouble(String d) {
		Double = d;
	}
}
