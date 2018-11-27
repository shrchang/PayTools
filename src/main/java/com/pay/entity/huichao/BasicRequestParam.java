package com.pay.entity.huichao;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.huichao.SignUtil;

/**
 * 汇潮支付的数据
 * 
 * @ClassName BasicRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月3日 下午3:42:17
 *
 */
public abstract class BasicRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6394119223940389375L;

	/**
	 * 签名的
	 */
	@PayRequestParamLabel(isRequired = true)
	@XmlField(name = "SignInfo")
	protected String SignInfo;

	/**
	 * 私钥
	 */
	@PayRequestParamLabel(isRequired = true, sortIndex = 1)
	private String privateKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBALE4e7sq0diZxT5A"
			+ "+G4fM00GJvTvnlNtOgH+xQ+STp4scd+UNDftFtV+yNcm2C2286HrGtirJsLfPz1U"
			+ "YzdBnrd/7Tgbzhpqh7ubaK8SwIAKXEgIE1gxiRXSHqnxIWtYDkCaJPz1IXrUhbS9"
			+ "Ce9iW7pDL3yyBBKYBwIlFP/s/vYBAgMBAAECgYEAlJIDuM+XCP0wzJXvL3LcsS/9"
			+ "LM5NbydcwBtz3TAM1LHx7Tvz4wbSY71cZnLcPMbpzM6qvQYPAsPh4mqCmupaQZk6"
			+ "TCrto7T9/F5PrwqIql80wRIew/ZQlVQdjK/dbl5nq8CD36Lp3dFFX3tfp8NOnzwM"
			+ "54+fIWksxUeTiDgBCAECQQDp9SNZP+ww9tLzIhqIsEOr0Jmu9QAzm9AQpKrqCTrW"
			+ "F7+34pCJmUrrseV9+6/ejtF+F/hvBZd9QvzajeGjUgYhAkEAwerly9aC1BDZ6dWE"
			+ "TgOAgCKUvFQYSGHo47XNIKyjhcPMaaymLzG90Ar2+ClOEQbe0s8EbB1/rcCNSjBE"
			+ "Vs8z4QJBANj+Xe/cowPzGksZmYSn/8vvKWuln68+WCfnowJ41xJVaqNyR17oSB39"
			+ "nP5Rn5gL3PBX6TuH8y7iH8XSDLK/VCECQQCdeEWhUJGu6fw7UcL9owRfiTVk9Zk+"
			+ "dhurhj+MEAU+I7DEA4pz+p2b6ruA6/HUC9M4NxntPcsn6pwRqb5lDB+hAkEAxssX"
			+ "7FTETy1oGByCEPfh8n11XcXTxtfuCBnHVyXgoQqlPeiAOvx7buLjY3MOTxdZlbh/" 
			+ "SQ1WAtFPNs04BeMM6w==";

	/**
	 * 请求路径
	 */
	@PayRequestParamLabel(isRequired = true, sortIndex = 1)
	// private String url="https://gwapi.yemadai.com/pay/sslpayment";
	private String url = "https://gwapi.yemadai.com/pay/scanpay";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * 需要自己实现签名的问题
	 * 
	 * @author shrChang.Liu
	 * @return
	 * @date 2018年9月3日 下午3:56:22
	 * @return String
	 * @description
	 */
	public String getSignInfo() {
		if (SignInfo == null)
			try {
				this.SignInfo = SignUtil.getSign(this, this.privateKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return SignInfo;
	}

	public void setSignInfo(String signInfo) {
		SignInfo = signInfo;
	}

	/**
	 * 验证参数
	 * 
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年9月3日 下午4:41:47
	 * @return void
	 * @description
	 */
	public abstract void validate() throws Exception;

}
