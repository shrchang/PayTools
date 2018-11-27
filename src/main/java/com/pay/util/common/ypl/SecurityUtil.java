package com.pay.util.common.ypl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import com.pay.util.common.ypl.base.BaseSecurity;
import com.pay.util.common.ypl.base.SunSecurityUtil;

import sun.misc.BASE64Encoder;

public class SecurityUtil {
	public final static PublicKey epaylinksPublicKey;
	public final static PrivateKey privateKey;
	public final static String certId;
	static {

		try {
			String keyStoreFilePath = Parameters.getProperty("keystore_path");
			String keyStorePassword = Parameters.getProperty("keystore_password");
			String keyPassword = Parameters.getProperty("privatekey_password");
			String epaylinksCertPath = Parameters.getProperty("epaylinks_cert_path");

			KeyStore keyStore = SunSecurityUtil.getKeyStore(keyStoreFilePath, keyStorePassword,
					BaseSecurity.KEY_STORE_TYPE_PKCS12);

			Enumeration<String> aliasSet = keyStore.aliases();
			String alias = null;
			while (aliasSet.hasMoreElements()) {
				alias = aliasSet.nextElement();
			}

			// 加载商户的私钥
			privateKey = SunSecurityUtil.getPrivateKey(keyStore, alias, keyPassword.toCharArray());
			X509Certificate cert = (X509Certificate) SunSecurityUtil.getCertificate(keyStore, alias);
			certId = String.valueOf(cert.getSerialNumber());
			// 加载易票联的公钥
			epaylinksPublicKey = SunSecurityUtil.getPublicKeyByCertFile(epaylinksCertPath);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数字签名，使用SHA256withRSA签名算法
	 * 
	 * @param signData
	 *            待签名数据
	 * @return byte[]返回签名后的字节数组
	 * @throws Exception
	 */
	public static byte[] sign(byte[] signData) throws Exception {
		return SignatureUtil.sign(signData, BaseSecurity.SIGNATURE_ALGORITHM_SHA256withRSA, privateKey);
	}

	/**
	 * 数字签名，使用SHA256withRSA签名算法
	 * 
	 * @param signData
	 *            待签名数据
	 * @return String 签名结果以Base64编码格式返回
	 * @throws Exception
	 */
	public static String signForBase64(byte[] signData) throws Exception {
		byte[] sign = sign(signData);
		String result = new BASE64Encoder().encode(sign);
		result = result.replaceAll("[\\s*\t\n\r]", "");
		return result;
	}

	/**
	 * 数字验签，使用SHA256withRSA签名算法
	 * 
	 * @param signData
	 *            待签名数据
	 * @param sign
	 *            签名字符串
	 * @param publicKey
	 *            公钥
	 * @return boolean 返回数字验签结果
	 * @throws Exception
	 */
	public static boolean verify(byte[] signData, byte[] sign) throws Exception {
		return SignatureUtil.verify(signData, BaseSecurity.SIGNATURE_ALGORITHM_SHA256withRSA, epaylinksPublicKey, sign);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		try {
			String keyStoreFilePath = Parameters.getProperty("keystore_path");
			String keyStorePassword = Parameters.getProperty("keystore_password");
			String keyPassword = Parameters.getProperty("privatekey_password");
			String epaylinksCertPath = Parameters.getProperty("epaylinks_cert_path");

			KeyStore keyStore = SunSecurityUtil.getKeyStore(keyStoreFilePath, keyStorePassword,
					BaseSecurity.KEY_STORE_TYPE_PKCS12);

			Enumeration<String> aliasSet = keyStore.aliases();
			String alias = null;
			while (aliasSet.hasMoreElements()) {
				alias = aliasSet.nextElement();
			}

			// 加载商户的私钥
			PrivateKey privateKey = SunSecurityUtil.getPrivateKey(keyStore, alias, keyPassword.toCharArray());
			X509Certificate cert = (X509Certificate) SunSecurityUtil.getCertificate(keyStore, alias);
			String certId = String.valueOf(cert.getSerialNumber());
			// 加载易票联的公钥
			PublicKey epaylinksPublicKey = SunSecurityUtil.getPublicKeyByCertFile(epaylinksCertPath);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		String str = "base64_memo=SXBob25lWA==&certId=335902764374016746163578510918738695929360058949&currency_type=RMB&is_raw=1&notify_url=http://www.baidu.com&out_trade_no=20180601141654885&partner=130&pay_id=wxpay&sign_type=SHA256withRSA&store_oi_type=0&sub_appid=wxdac3dd7ffa21c579&sub_openid=ojKWzt_zSJDSxTmIlNlYEO0wYUCQ&total_fee=0.01&version=4.0";
		String sign = signForBase64(str.getBytes(Parameters.getProperty("encoding")));
		String val = URLEncoder.encode(sign, Parameters.getProperty("encoding"));

		System.out.println("sign:" + sign);
		System.out.println("URLENcode:" + val);
	}

}
