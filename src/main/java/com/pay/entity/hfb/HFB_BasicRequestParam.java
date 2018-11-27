package com.pay.entity.hfb;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.hfb.SignUtil;

/**
 * 汇付宝请求基础实体
 * 
 * @ClassName HFB_BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午5:35:16
 *
 */
public abstract class HFB_BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String version = "1.0";// 版本直接给默认值，如果没有传递的话

	@PayRequestParamLabel(isRequired = true, isSign = true)
	private String merchantId = "";// 商户的id

	private String remark = "";// 附加数据
	
	@PayRequestParamLabel(isRequired = false,isSign = true,sortIndex=1)
	private String key="";//用户的密钥，用于验证的 不需要将这个key放到请求体 只用于签名且只能放置到最后面

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 现在这个还存在问题，因为汇付宝要求所有的参数按照字典排序后还需要在后面加上分配给用户的私钥进行拼接然后加密，但是在MD5加密
	 */
	public String getSign() {
		if (this.sign != null)
			return sign;
		try {
			return SignUtil.getHybSign(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	protected String sign;// 代表签名档 这是每一个接口都必须有的参数
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/**
	 * 自带验证逻辑下面所有的请求参数都必须实现 如果没有的话 默认可以是空函数
	 * @author shrChang.Liu
	 * @param 
	 * @date 2018年6月22日 上午10:00:48
	 * @return void
	 * @description
	 * @throws Exception 默认是可以抛出异常的
	 */
	public abstract void validation() throws Exception;
}
