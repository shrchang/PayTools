package com.pay.entity.hftx.payment.app.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.entity.hftx.BasicRequestParam;
import com.pay.util.text.JsonUtil;

/**
 * 快捷支付后台请求实体 仅仅用于用户转账回滚
 * 
 * @ClassName Hftx_QuickPayMentRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月29日 下午2:26:41
 *
 */
public class Hftx_QuickBackPayMentRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714343249469147028L;

	/**
	 * 用户客户号
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "user_cust_id")
	private String userCustId;
	
	/**
	 * 充值类型
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "recharge_type")
	private String rechargeType="02020006";
	
	/**
	 * 交易类型
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_type")
	private String transType="02020101";
	
	/**
	 * 出账的人子账户id
	 */
	@PayRequestParamLabel(isRequired = true, isSign = false)
	private String userAcctId;

	/**
	 * 用户金额 金额格式是###.00
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "trans_amt")
	private String transAmt;
	
	/**
	 * 入账客户号	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_cust_id")
	private String inCustId;
	
	/**
	 * 入账账户号	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "in_acct_id")
	private String inAcctId;

	/**
	 * 这个应该默认就是传商户的信息进去 因为默认都要转给商户的 分账账户串 入账客户传，json格式：
	 * [{‘divCustId’:‘6666000000025350’,’divAcctId’:‘78276’,’divAmt’:‘50.00’,’
	 * divFreezeFg’:‘00’},{‘divCustId’:‘6666000000025666’,’divAcctId’:‘78841’,’
	 * divAmt’:‘50.00’,’divFreezeFg’:‘01’}]
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "div_detail")
	private String divDetail;


	/**
	 * 商户后台应答地址
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "bg_ret_url")
	private String bgRetUrl;

	/**
	 * 商户私有域
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "mer_priv")
	private String merPriv;

	/**
	 * 扩展域
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "extension")
	private String extension;
	
	/**
	 * 交易场景
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "trans_scene")
	private String transScene;
	
	/**
	 * 交易场景小类	
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "trans_scene_sub")
	private String transSceneSub;

	/**
	 * 二级商户号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "secondary_mer_id")
	private String secondaryMerId;

	/**
	 * 短信验证码	
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "sms_code")
	private String smsCode;
	
	/**
	 * 代扣签约流水	
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "sign_seq_id")
	private String signSeqId;
	
	/**
	 * 银行卡号
	 */
	@PayRequestParamLabel(isRequired = false, isSign = true, name = "card_no")
	private String cardNo;
	
	/**
	 * 阶段标志	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "card_no")
	private String stepFlag="01";
	
	/**
	 * 业务请求流水	
	 */
	@PayRequestParamLabel(isRequired = true, isSign = true, name = "biz_trans_id")
	private String bizTransId;

	public String getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(String userCustId) {
		this.userCustId = userCustId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getDivDetail() {
		if(divDetail == null){
			Map<String,String> param = new HashMap<String,String>();
			param.put("divCustId", this.getUserCustId());
			param.put("divAcctId", this.userAcctId);
			param.put("divAmt", this.transAmt);
			param.put("divFreezeFg", "00");
			List<Object> objs = new ArrayList<Object>();
			objs.add(param);
			this.divDetail = JsonUtil.getJsonStrByObj(objs);
		}
		return divDetail;
	}

	public void setDivDetail(String divDetail) {
		this.divDetail = divDetail;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getSecondaryMerId() {
		return secondaryMerId;
	}

	public void setSecondaryMerId(String secondaryMerId) {
		this.secondaryMerId = secondaryMerId;
	}
	
	public String getRechargeType() {
		return rechargeType;
	}

	public String getTransType() {
		return transType;
	}

	public String getUserAcctId() {
		return userAcctId;
	}

	public String getInCustId() {
		return inCustId;
	}

	public String getInAcctId() {
		return inAcctId;
	}

	public String getTransScene() {
		return transScene;
	}

	public String getTransSceneSub() {
		return transSceneSub;
	}

	public String getSignSeqId() {
		return signSeqId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getStepFlag() {
		return stepFlag;
	}

	public String getBizTransId() {
		return bizTransId;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public void setUserAcctId(String userAcctId) {
		this.userAcctId = userAcctId;
	}

	public void setInCustId(String inCustId) {
		this.inCustId = inCustId;
	}

	public void setInAcctId(String inAcctId) {
		this.inAcctId = inAcctId;
	}

	public void setTransScene(String transScene) {
		this.transScene = transScene;
	}

	public void setTransSceneSub(String transSceneSub) {
		this.transSceneSub = transSceneSub;
	}

	public void setSignSeqId(String signSeqId) {
		this.signSeqId = signSeqId;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setStepFlag(String stepFlag) {
		this.stepFlag = stepFlag;
	}

	public void setBizTransId(String bizTransId) {
		this.bizTransId = bizTransId;
	}

	@Override
	public String getCmdId() {
		if (this.cmdId == null)
			this.cmdId = "850";
		return this.cmdId;
	}

}
