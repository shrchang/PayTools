package com.pay.entity.hftx.user.manage.request;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;


/**
 * 汇付天下用户开户
 * @ClassName Hftx_PersonOpenRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 上午9:41:15
 *
 */
public class Hftx_PersonOpenRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3451646890969347573L;
	
	/**
	 * 个体户标识  不传默认为个体户开户 00000100个人开户, 00000101个体户开户
	 */
	@PayRequestParamLabel(isRequired=false,name="solo_flg",isSign=true)
	private String soloFlg="00000100";
	
	/**
	 * 用户的真实姓名
	 */
	@PayRequestParamLabel(isRequired=true,name="user_name",isSign=true)
	private String userName;
	
	/**
	 * 用户的身份证号
	 */
	@PayRequestParamLabel(isRequired=true,name="cert_id",isSign=true)
	private String certId;
	
	/**
	 * 用户的手机号
	 */
	@PayRequestParamLabel(isRequired=true,name="user_mobile",isSign=true)
	private String userMobile;
	
	/**
	 * 填写证件上有效期的截至日期，格式为：YYYYMMDD，例如：20290420
	 */
	@PayRequestParamLabel(isRequired=false,name="vali_date",isSign=true)
	private String valiDate;
	
	/**
	 * 用户省份，如上海0031
	 */
	@PayRequestParamLabel(isRequired=true,name="cust_prov",isSign=true)
	private String custProv;
	
	/**
	 * 用户地区，如上海3100
	 */
	@PayRequestParamLabel(isRequired=true,name="cust_area",isSign=true)
	private String custArea;
	
	/**
	 * 填写证件上的住址
	 */
	@PayRequestParamLabel(isRequired=false,name="cust_address",isSign=true)
	private String custAddress;
	
	/**
	 * 见个人职业分类表 可选
	 */
	@PayRequestParamLabel(isRequired=false,isSign=true)
	private String occupation;
	
	/**
	 * 用户的电子邮箱
	 */
	@PayRequestParamLabel(isRequired=false,name="user_email",isSign=true)
	private String userEmail;
	
	/**
	 * 个体户标识为是时，必须输入
	 */
	@PayRequestParamLabel(isRequired=true,name="pay_password",signField="soloFlg",signOptions="00000101",isSign=true)
	private String payPassword;
	
	/**
	 * 通过后台异步通知商户开户结果 注意： 1) 使用时不要包含中文 2) 必须是外网地址
	 */
	@PayRequestParamLabel(isRequired=true,name="bg_ret_url",isSign=true)
	private String bgRetUrl;
	
	/**
	 * 为商户的自定义字段，该字段在交易完成后由本平台原样返回
	 */
	@PayRequestParamLabel(isRequired=false,name="mer_priv",isSign=true)
	private String mer_priv;
	
	/**
	 * 用于扩展请求参数
	 */
	@PayRequestParamLabel(isRequired=false,isSign=true)
	private String extension;

	public String getSoloFlg() {
		return soloFlg;
	}

	public void setSoloFlg(String soloFlg) {
		this.soloFlg = soloFlg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getValiDate() {
		return valiDate;
	}

	public void setValiDate(String valiDate) {
		this.valiDate = valiDate;
	}

	public String getCustProv() {
		return custProv;
	}

	public void setCustProv(String custProv) {
		this.custProv = custProv;
	}

	public String getCustArea() {
		return custArea;
	}

	public void setCustArea(String custArea) {
		this.custArea = custArea;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getMer_priv() {
		return mer_priv;
	}

	public void setMer_priv(String mer_priv) {
		this.mer_priv = mer_priv;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String getCmdId() {
		if(this.cmdId == null)
			this.cmdId = "101";
		return this.cmdId;
	}
}
