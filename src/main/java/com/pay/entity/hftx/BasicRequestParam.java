package com.pay.entity.hftx;

import java.util.Map;

import org.apache.log4j.Logger;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.BaseUrlEntity;
import com.pay.exception.PayException;
import com.pay.util.DateUtil;
import com.pay.util.sign.hftx.PayUtil;


/**
 * 基础请求实体
 * @ClassName BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 上午9:42:44
 *
 */
public abstract class BasicRequestParam extends BaseUrlEntity {
	
	private Logger logger = Logger.getLogger(BasicRequestParam.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8544556627108512750L;

	@PayRequestParamLabel(isRequired = true,isParam=true,isSign=true)
	private String version = "10";//版本固定
	
	@PayRequestParamLabel(isRequired=true,name="cmd_id",isParam=true,isSign=true)
	protected String cmdId;//消息类型
	
	@PayRequestParamLabel(isRequired=true,name="mer_cust_id",isParam=true,isSign=true)
//	private String merCustId="6666000000054889";//商户号id 必须
	private String merCustId;
	
	/**
	 * 订单号
	 */
	@PayRequestParamLabel(isRequired=false,name="order_id",isSign=true)
	private String orderId=String.valueOf(System.currentTimeMillis());
	
	/**
	 * 订单日期 格式为YYYYMMDD
	 */
	@PayRequestParamLabel(isRequired=false,name="order_date",isSign=true)
	private String orderDate=DateUtil.getStrByNow("yyyyMMdd");
	
	/**
	 * 不参与签名
	 * 接口请求地址 好像默认都是一个，所以应该是可以写死的  https://finance.chinapnr.com/npay/merchantRequest
	 */
	@PayRequestParamLabel(isRequired=true,isParam=false)
//	private String url="http://mertest.chinapnr.com/npay/merchantRequest";//测试地址 到时生产地址也可以写死
	private String url;
	
	/**
	 * pfx证书的完整路径
	 */
	@PayRequestParamLabel(isRequired=true)
//	private String pfxFilePath="C:\\Users\\Administrator\\Desktop\\商城\\支付\\NP2175.pfx";
	private String pfxFilePath;
//	private String pfxFilePath = "/data/apprun/kkgmall/front_apache-tomcat-7.0.72/webapps/frontWeb/WEB-INF/classes/NP2175.pfx";
	
	/**
	 * pfx证书密码
	 */
	@PayRequestParamLabel(isRequired=true)
//	private String pfxFilePwd="123123";
	private String pfxFilePwd;
	
	/**
	 * cer证书
	 */
	@PayRequestParamLabel(isRequired=true)
//	private String trustCerPath="C:\\Users\\Administrator\\Desktop\\商城\\支付\\CFCA_ACS_TEST_OCA31.cer";
	private String trustCerPath;
//	private String trustCerPath="/data/apprun/kkgmall/front_apache-tomcat-7.0.72/webapps/frontWeb/WEB-INF/classes/CFCA_ACS_TEST_OCA31.cer";
	
	/**
	 * 加密值
	 */
	@PayRequestParamLabel(isRequired=true,name="check_value",isParam=true)
	private String checkValue;
	
	public String getTrustCerPath() {
		return trustCerPath;
	}

	public void setTrustCerPath(String trustCerPath) {
		this.trustCerPath = trustCerPath;
	}

	public String getPfxFilePath() {
		return pfxFilePath;
	}

	public void setPfxFilePath(String pfxFilePath) {
		this.pfxFilePath = pfxFilePath;
	}

	public String getPfxFilePwd() {
		return pfxFilePwd;
	}

	public void setPfxFilePwd(String pfxFilePwd) {
		this.pfxFilePwd = pfxFilePwd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public abstract String getCmdId();

	/**
	 * 每一种消息类型代表一种交易 用户开户101 交易10x等等
	 * @author shrChang.Liu
	 * @param cmdId
	 * @date 2018年9月29日 上午9:47:38
	 * @return void
	 * @description
	 */
	public void setCmdId(String cmdId){
		this.cmdId = cmdId;
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
	
	public String getCheckValue() {
		if(this.checkValue == null){
			try {
				this.checkValue = PayUtil.getSign(this);
			} catch (Exception e) {
				logger.info("加密出错：" + e.getLocalizedMessage());
			}
		}
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	
	/**
	 * 验证参数是否存在
	 * @author shrChang.Liu
	 * @date 2018年9月29日 上午11:01:26
	 * @return void
	 * @description
	 */
	protected void validate()throws PayException{
		try {
			PayUtil.validate(this);
		} catch (Exception e) {
			throw new PayException(e.getMessage());
		}
	}
	
	/**
	 * 默认调用这个方法包含 调用签名、验证、最后返回给http的参数集合
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年9月29日 上午11:04:09
	 * @return Map<String,String>
	 * @description
	 */
	public Map<String,String> getRequestParam()throws PayException{
		//验证参数，这里面因为反射的原因会自动去调用签名方法
		this.validate();
		//直接获取最后的执行参数集合
		Map<String,String> param = PayUtil.getHttpPostParam(this);
		return param;
	}
}
