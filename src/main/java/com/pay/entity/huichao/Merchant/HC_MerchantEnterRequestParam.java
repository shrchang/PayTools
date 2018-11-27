package com.pay.entity.huichao.Merchant;

import java.io.Serializable;
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
import com.pay.util.http.HttpsUtil;
import com.pay.util.text.XmlUtil;

/**
 * 商户入驻
 * 
 * @ClassName HC_MerchantEnterRequestParam
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年9月4日 上午10:18:34
 *
 */
@XmlAlias(name = "ScanMerchantInRequest")
public class HC_MerchantEnterRequestParam extends BasicRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5312938509735342633L;

	@XmlField(name = "MerNo")
	@PayRequestParamLabel(isSign=true)
	private String MerNo="45627";

	@XmlField(name = "Version")
	private String Version = "1.0";

	@XmlField(name = "PayType")
	@PayRequestParamLabel(isSign=true)
	private String PayType = "WXZF_ONLINE";

	@XmlField(name = "RandomStr")
	@PayRequestParamLabel(isSign=true)
	private String RandomStr = UUID.randomUUID().toString();

	@XmlAlias(name = "MerchantInfo")
	private MerchantInfo MerchantInfo;

	@XmlAlias(name = "MerchantInfo")
	public class MerchantInfo implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6545952642910071728L;

		@XmlField(name = "MerName")
		private String MerName="广西豪华昕略网络竞技有限公司";

		@XmlField(name = "ShortName")
		private String ShortName="豪华昕略";

		@XmlField(name = "ServicePhone")
		private String ServicePhone="13167044534";

		@XmlField(name = "Business")
		private String Business="501";

		public String getMerName() {
			return MerName;
		}

		public void setMerName(String merName) {
			MerName = merName;
		}

		public String getShortName() {
			return ShortName;
		}

		public void setShortName(String shortName) {
			ShortName = shortName;
		}

		public String getServicePhone() {
			return ServicePhone;
		}

		public void setServicePhone(String servicePhone) {
			ServicePhone = servicePhone;
		}

		public String getBusiness() {
			return Business;
		}

		public void setBusiness(String business) {
			Business = business;
		}
	}

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

	public String getPayType() {
		return PayType;
	}

	public void setPayType(String payType) {
		PayType = payType;
	}

	public String getRandomStr() {
		return RandomStr;
	}

	public void setRandomStr(String randomStr) {
		RandomStr = randomStr;
	}

	public MerchantInfo getMerchantInfo() {
		return MerchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		MerchantInfo = merchantInfo;
	}

	@Override
	public void validate() throws Exception {
		System.out.println("aaaaaaaaa");
	}
	
	public static void main(String[] args) throws Exception{
		HC_MerchantEnterRequestParam param = new HC_MerchantEnterRequestParam();
		MerchantInfo info = param.new MerchantInfo();
		param.setMerchantInfo(info);
		param.getSignInfo();
		String xmlBody = XmlUtil.covertToXML(param);
		System.out.println(xmlBody);
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
		valuePairs.add(new BasicNameValuePair("requestDomain", Base64.encode(xmlBody.getBytes())));
		String result = HttpsUtil.sendHttpsRequestWithParam("https://gwapi.yemadai.com/scanpay/merchantIn", valuePairs, "UTF-8");
		byte[] bytes = Base64.decode(result);
		String r = new String(bytes);
		System.out.println("结果：" + r);
	}

}
