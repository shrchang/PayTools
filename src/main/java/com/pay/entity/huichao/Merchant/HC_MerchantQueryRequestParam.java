package com.pay.entity.huichao.Merchant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.pay.annotation.PayRequestParamLabel;
import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlField;
import com.pay.entity.huichao.BasicRequestParam;
import com.pay.util.common.poco.Base64;
import com.pay.util.common.poco.RSAUtils;
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.XmlUtil;

/**
 * 查询商户入驻
 * 
 * @ClassName HC_MerchantQueryRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月4日 上午11:31:53
 *
 */
@XmlAlias(name = "ScanMerchantInQueryRequest")
public class HC_MerchantQueryRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541532161152754224L;

	@PayRequestParamLabel(isSign = true)
	@XmlField(name = "MerNo")
	private String MerNo = "45627";

	@XmlField(name = "Version")
	private String Version = "1.0";

	@XmlField(name = "RandomStr")
	@PayRequestParamLabel(isSign = false)
	private String RandomStr = UUID.randomUUID().toString();

	@XmlField(name = "CompanyNo")
	@PayRequestParamLabel(isSign = true)
	private String CompanyNo = "sweep-4100d72503d34425984d20853298435e";

	@XmlField(name = "PayType")
	@PayRequestParamLabel(isSign = false)
	private String PayType = "WXZF_ONLINE";

	public String getMerNo() {
		return MerNo;
	}

	public void setMerNo(String merNo) {
		MerNo = merNo;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getRandomStr() {
		return RandomStr;
	}

	public void setRandomStr(String randomStr) {
		RandomStr = randomStr;
	}

	public String getCompanyNo() {
		return CompanyNo;
	}

	public void setCompanyNo(String companyNo) {
		CompanyNo = companyNo;
	}

	public String getPayType() {
		return PayType;
	}

	public void setPayType(String payType) {
		PayType = payType;
	}
	
	@Override
	public String getSignInfo() {
		try {
			String s = "MerNo="+this.MerNo+"&CompanyNo="+this.CompanyNo+"&PayType="+this.PayType+"&RandomStr="+this.RandomStr;
			return RSAUtils.sign(s.getBytes(), this.getPrivateKey(),RSAUtils.SIGNATURE_ALGORITHM_SHA1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void validate() throws Exception {
		System.err.println("aaaaaaaa");
	}
	
	public static void main(String[] args) throws Exception{
		HC_MerchantQueryRequestParam param = new HC_MerchantQueryRequestParam();
		param.getSignInfo();
		String xmlBody = XmlUtil.covertToXML(param);
		System.out.println(xmlBody);
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
		valuePairs.add(new BasicNameValuePair("requestDomain", Base64.encode(xmlBody.getBytes())));
		String result = HttpsUtil.sendHttpsRequestWithParam("https://gwapi.yemadai.com/scanpay/merchantInQuery", valuePairs, "UTF-8");
		System.out.println("结果：" + result);
		byte[] bytes = Base64.decode(result);
		String r = new String(bytes);
		System.out.println("结果：" + r);
	}

}
