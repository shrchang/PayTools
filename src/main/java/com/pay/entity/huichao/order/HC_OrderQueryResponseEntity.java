package com.pay.entity.huichao.order;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;

/**
 * 订单查询
 * 
 * @ClassName HC_OrderQueryResponseEntity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月4日 下午5:34:18
 *
 */
@XmlAlias(name = "root")
public class HC_OrderQueryResponseEntity extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3275484207714700817L;

	/**
	 * 商户号
	 */
	@XmlField(name = "merCode")
	private String merCode;

	/**
	 * 开始时间
	 */
	@XmlField(name = "beginDate")
	private String beginDate;

	/**
	 * 结束时间
	 */
	@XmlField(name = "endDate")
	private String endDate;

	/**
	 * 结果数量
	 */
	@XmlField(name = "resultCount")
	private String resultCount;

	/**
	 * 当前页
	 */
	@XmlField(name = "pageIndex")
	private String pageIndex;

	/**
	 * 分页数量
	 */
	@XmlField(name = "pageSize")
	private String pageSize;

	/**
	 * 结果
	 */
	@XmlField(name = "resultCode")
	private String resultCode;

	public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getResultCount() {
		return resultCount;
	}

	public void setResultCount(String resultCount) {
		this.resultCount = resultCount;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
