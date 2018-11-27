package com.pay.entity.huichao.pay;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.huichao.BasicRequestParam;
import com.pay.util.DateUtil;
import com.pay.util.common.poco.RSAUtils;
import com.pay.util.sign.huichao.SignUtil;
import com.pay.util.text.XmlUtil;

/**
 * 扫码支付
 * 
 * @ClassName HC_ScanPayRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月4日 上午9:03:30
 *
 */
@XmlAlias(name = "ScanPayRequest")
public class HC_ScanPayRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1582050302460909001L;

	/**
	 * 商户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="MerNo")
	private String MerNo = "45627";

	/**
	 * 订单号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="BillNo")
	private String BillNo = "N"+System.currentTimeMillis();

	/**
	 * 支付方式 AliScanPay（支付宝支付）， WxScanPay(微信支付)， QQScanPay(QQ钱包支付),
	 * BdScanPay(百度钱包支付)， JdScanPay(京东钱包支付)  客户要求只要微信和支付宝
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="payType")
	private String payType = "WxScanPay_OnLine";

	/**
	 * 支付金额
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="Amount")
	private String Amount = "0.01";

	/**
	 * 发起支付的交易时间，格式
	 * yyyyMMddHHmmss
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="OrderTime")
	private String OrderTime = DateUtil.getStrByNow("yyyyMMddHHmmss");
	
	/**
	 * 渠道商户入驻返回的公司标示companyNo
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="ScanpayMerchantCode")
	private String ScanpayMerchantCode="sweep-e8b27afa1e404b2aad4968925db73ac7";

	/**
	 * 异步通知地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="AdviceUrl")
	private String AdviceUrl = "http://47.106.171.66:18211/frontWeb/api/hcpay_doAsynRecvNotify.do";

	/**
	 * 默认无限制
		0.无限制  可选
	1.限制使用信用卡
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true)
	@XmlField(name="limitPay")
	private String limitPay;

	/**
	 * 商品描述 可选
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true)
	@XmlField(name="products")
	private String products="游戏币";

	/**
	 * 备注 可选
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true)
	@XmlField(name="remark")
	private String remark;
	
	/**
	 * 回调url设置 不签名 必填
	 */
	@PayRequestParamLabel(isRequired = true)
	@XmlField(name="ReturnUrl")
	private String ReturnUrl="http://www.baidu.com";

	public String getReturnUrl() {
		return ReturnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		ReturnUrl = returnUrl;
	}

	public String getScanpayMerchantCode() {
		return ScanpayMerchantCode;
	}

	public void setScanpayMerchantCode(String scanpayMerchantCode) {
		ScanpayMerchantCode = scanpayMerchantCode;
	}

	public String getMerNo() {
		return MerNo;
	}

	public void setMerNo(String merNo) {
		MerNo = merNo;
	}

	public String getBillNo() {
		return BillNo;
	}

	public void setBillNo(String billNo) {
		BillNo = billNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getAdviceUrl() {
		return AdviceUrl;
	}

	public void setAdviceUrl(String adviceUrl) {
		AdviceUrl = adviceUrl;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
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

	@Override
	public void validate() throws Exception {
		SignUtil.validate(this);
	}
	
	@Override
	public String getSignInfo() {
		if(this.SignInfo == null){
			String s = "MerNo="+this.MerNo+"&BillNo="+this.BillNo+"&Amount="+this.Amount+"&OrderTime="+this.OrderTime+"&AdviceUrl="+this.AdviceUrl;
			System.out.println("加密的字段：" + s +"\n私钥："+this.getPrivateKey());
			try {
				this.SignInfo = RSAUtils.sign(s.getBytes(), this.getPrivateKey(),RSAUtils.SIGNATURE_ALGORITHM_SHA1);
				System.out.println("加密后：" + this.SignInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.SignInfo;
	}
	
	public static void main(String[] args)throws Exception {
		HC_ScanPayRequestParam param = new HC_ScanPayRequestParam();
		param.getSignInfo();
		System.out.println(XmlUtil.covertToXML(param));
	}

}
