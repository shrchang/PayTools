package com.pay.entity.huichao.bill;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.BaseUrlEntity;
import com.pay.util.sign.huichao.SignUtil;

@XmlAlias(name="root")
public class HC_BillRequestParam extends BaseUrlEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -807766853841495086L;
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	@XmlField(name="merCode")
	private String merCode="45627";
	
	@PayRequestParamLabel(isRequired=true,isSign=true)
	@XmlField(name="settleDate")
	private String settleDate="20180904";
	
	@PayRequestParamLabel(isRequired=true)
	@XmlField(name="sign")
	private String sign;
	
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
	private String url = "https://gwapi.yemadai.com/merchantBatchQueryAPI";

	public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getSign() {
		if(this.sign == null){
			try {
				this.sign = SignUtil.getSign(this, this.privateKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
