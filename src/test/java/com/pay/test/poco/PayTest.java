package com.pay.test.poco;

import java.math.BigDecimal;

import com.pay.constant.Const;
import com.pay.entity.poco.pay.Poco_PayRequestParam;
import com.pay.entity.poco.pay.Poco_PayResponseEntity;
import com.pay.handler.payment.poco.PoCo_PayHandler;
import com.pay.util.text.JsonUtil;

public class PayTest {

	// 公钥
	public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBecEbwvOAweSnc2q8aSF1fArk7bAQks5onK+Zxy0TeQL15FgBFaLpclkejcNtKGAakYzL8KAH/t14/eOqGdNLGUo9PaNSeTV5guM1IxhnsujXUGEScJDJ9rD1d78HFdt+nYYZEwQvsW+oBf+zhjjSmvUXDNAyskR5Ms9LGKYEHwIDAQAB";
	// 私钥
	// public static String privateKey =
	// "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCi9OZEXbtBMZBp"
	// + "stXfufUFRR65eAlQZU5JyAVQZIn1+5x7imM8O8Z6YqwNpNA7qwcmMq/Z1oxtutV/"
	// + "oGnkFBXO93u6HS8ajCmbzYjkhNrXxEKnhxPp7rVb8JucJz/3jU5UTE9m+Ab+nyq5"
	// + "gQicqEpkbutiU8UJ6oow9Vap5L5j62de639IBhcJMtTxtPkbyNRreCYS/B1yMYYj"
	// + "Giw3x34oVkxrBQX3tvyCmk8tffVdVyPkLJI75vtTTvVVQPogn/N6Xfh/KLe5Sklq"
	// + "Xc3GT9cCtElUeMIAbaERBBdAyvywg3NUaKSVhbxIOG6UdAE8cmhZI8sl56mvsGYj"
	// + "mIoWU5nZAgMBAAECggEAI/J0LVaj7SC646YwqdbCpzP1MCK7o0GFwJ7gFTjoehvU"
	// + "DCid9XaWNP85RxU5XkA/Jnz978b1WWtil3HSih6oJOzRHWA8uNV8hEMV1Js+D2Ta"
	// + "80vH583hsfNk0FCUOs6wHcZrqaJDIL4J1bwSI0S4jGkvgZRLHgHgFCa6xGWSXkYA"
	// + "e1jSLlFzpHCGpFks+nhYCjA8m0q26AxqF3tQ2nbQGczT8IF3PYR0xxxElTB3NucH"
	// + "EVTg7Q7KKAbvlcop6nnNVtyHiq4/AAkvawQXdEi/bklVABtbsIdwZpQ2+qg3wIsJ"
	// + "d2rmEg/8ioz/3zPmxK45TWCtsTmuXT91Ks0PbuwAxQKBgQDPSR35QMLzAtrU1FHt"
	// + "33RefIWj76qetYSl7ZMxMi/URHmbYUBjfNv3jv4aAyMZPmnh8Gu47drLPP1hVPG9"
	// + "UWjW6W2vKS1kIIJN0Kj41tbBjbKhLX7Y41YKjxjPozniyP01yqisyWz9OVM+KHKC"
	// + "tyfJaCMpIDnJE7FgRS66z+WckwKBgQDJQNO/T212eUN+Vl+aUe12uIbU4Gm7voLe"
	// + "5os07gwQXw5CjdMo1BJ+BtcFNHcUKLuI9CBJ6L85+Kga0I5sfCLEy42qTKdPKjYL"
	// + "tfn9Wv2PX7VU5pEn0YyDVGrIbGgi1VMZtReBkFCDzHtcTEcV/+ZOoFytG+DGyvXK"
	// + "NP/3eMzfYwKBgDAvvCMMVgVt/XcKYH1eu8uXQO3qMgyw/8Qe5V/DXfEHdgmT4wb9"
	// + "qJj1Ccb8QbWFl9GpNTGJQZqLdA+jUosDGM8U9qWIef/TutbiEdW/A699BDCJxfof"
	// + "ZwoPV+I0/Kjmtk5B7VI1hPuczugdOPmAIGSmq73MuwIubMaHbqSI3cS3AoGBAKwA"
	// + "5/i+HcP/6Bt2Hsd59gZdt38BPdzj+l4flCJswYrMcxeWtz5R4mwr1GHycUOdfIqU"
	// + "e3QvpCAb0TD5xoAZqG2huzYtxWD3prFjmoFa3xNGrWgelzj886ba41jgri/3Osrh"
	// + "53EosmeywEwmNSssRt40WIDrLrU4idGEcrBDYnYZAoGBALgfIKPWgN/U2NHbzant"
	// + "GlutCui5bxIOAhzhUSe0axw2CeP8kPf9HwsVu1vBokdhuoO4L1Ht/QB7iWSYAGAW"
	// + "InbeIvblxxDOEXVKlT+khp4E03SZ1My+OTnIIxWIA22R5njMI3O9h900eK9CjQdz"
	// + "vdRiwBvlH1daMcf4h3/SMW41";

	public static String privateKey = "MIICXQIBAAKBgQCzjJ991toXnrZJbNFPoJPiH9jHKfovUNTD7WzdBnkbi8dcOGgi"
			+ "OEyZDAXOU/EEJhCBAfO1K4ZZCGkrGJMltO4/spIkt3F21L/tAJgh2csKexbD++tn"
			+ "gv5xWvO77RbS9A1CB16H+WD0xm5uVAeGPtMzGLqtxpJ2+rdJM/lxl8huwwIDAQAB"
			+ "AoGBAJ45SP+jC3QPKAJSg62RC2EUwXrZciCqMaUrIGkyYB03M4sAJjwpss6YOrGV"
			+ "ZWpLhPW626IG5hClidAxitKKu/wpIEakVl0ntSB3AVmLiF42uGiOEe/KV9ZrUOcC"
			+ "lsJWMsZSt5jrwgZ3rGGWs7ch8V8vt2Z7WqUs9sr2rC73cXj5AkEA5ueCa6cVWnkO"
			+ "tFNy4njRZS/A4c2DQRX15bZuEupjonLW1qzXeB5B6Zpf7zIXaplfwugM4lIVIWGO"
			+ "pxIeGj/0VQJBAMcQQQOSzmNWJaHeUBymKmQPl4zONMVvm9wv0qqJZIejD2MuvJh+"
			+ "DjnIOEcexIuJZnbLeAYCmOnPrj9oFoMDrrcCQDJ0A5tiNtg9+2iLk17I53gkpxCv"
			+ "xy5BjilTY1nevUaRsT/XJH2qntxcTvoFB/jS6om8CpSpOtTAbFs1Kj6yGsECQQC9"
			+ "KuYNhkoZPjle3IvW3dV05xhGl4KwiQJdORkCNLRS7RLnVvekFk5gfLN2aneufnDf"
			+ "vTWeyIMV1eUpnjmeYTZ7AkAQzGriMoFuVWGCC24rPpCK8ElreJkF45kzQ3ZJqnlA"
			+ "QrjFYupt5lVQfreRWEF4JTf+kruj0UTKpOn8XoevzOdr";

	/**
	 * 支付测试
	 * 
	 * @author shrChang.Liu
	 * @throws Exception
	 * @date 2018年6月30日 下午1:52:11
	 * @return void
	 * @description
	 */
	public static void testPay() throws Exception {
		Poco_PayRequestParam param = new Poco_PayRequestParam();
		param.setBody("xxxxx");
		param.setClientIp("127.0.0.1");
		param.setKey("6d4a9be3d1305f693a92ca3ff4c5a17e");
		param.setMerchantNo("1180628111450664");
		param.setMethod(Const.WAP_PAY);
		param.setNotifyUrl("http://www.baidu.com");
		param.setOutTradeNo("201806301440093343892");
		param.setPayType(Const.PMT_TAG_ALI_PAY);
		param.setPid("10803984000000396628");
		param.setPrivateKey(privateKey);
		param.setPublicKey(publicKey);
		param.setSyncUrl("http://www.baidu.com");
		param.setTradeAmount("10000");
		param.setUrl("http://api.pocopayment.com/v1");
		param.setTimestamp("1530340809881");
		param.setRandstr("vrdfei0nqxvu1a528q6qqykms8q2861d");
		PoCo_PayHandler payHandler = new PoCo_PayHandler();
		Poco_PayResponseEntity entity = (Poco_PayResponseEntity) payHandler.pay(param);
		System.out.println(JsonUtil.getJsonStrByObj(entity));
		if (entity.getErrcode().equals("0")) {
			System.out.println("商户号：" + entity.getMerchantNo());
			System.out.println("pay_url：" + entity.getOutPayUrl());
			System.out.println("结果：" + entity.getResultCode());
		}
	}

	public static void main(String[] args) throws Exception {
		// testPay();
		// StringBuilder builder = new StringBuilder();
		// builder.append("aaaaaaa&");
		// System.err.println(builder.substring(0, builder.length()-1));
		// String tradeAmount = "100.19";
		// System.out.println(String.valueOf(new
		// BigDecimal(tradeAmount).multiply(new BigDecimal(100)).intValue()));
//		String s = "我的神1111aa";
//		System.out.println(chineseToUnicode(s));
		
//		String a = "aaa.jpg";
//		int i = a.lastIndexOf(".");
//		System.out.println(a.substring(i));
		String a = "500.23";
		BigDecimal bigDecimal = new BigDecimal(a);
		System.out.println(bigDecimal.setScale(2).toString());
	}

	/**
	 * 转码专用
	 * @author shrChang.Liu
	 * @param gbString
	 * @return
	 * @date 2018年7月2日 上午10:30:19
	 * @return String
	 * @description
	 */
	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int i = 0; i < utfBytes.length; i++) {
			String hexB = Integer.toHexString(utfBytes[i]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}
	
	/**
     * 把中文转成Unicode码
     * @param str
     * @return
     */
    public static String chineseToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }

}
