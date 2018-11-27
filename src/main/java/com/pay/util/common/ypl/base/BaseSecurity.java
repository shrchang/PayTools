package com.pay.util.common.ypl.base;

/**
 * 数字签名算法常量类
 * @ClassName BaseSecurity
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午11:27:20
 *
 */
public class BaseSecurity {
	/**
	 * 密钥库类型
	 */
	public final static String KEY_STORE_TYPE_JKS = "JKS";
	public final static String KEY_STORE_TYPE_JCEKS = "JCEKS";
	public final static String KEY_STORE_TYPE_PKCS12 = "PKCS12";
	
	/**
	 * 数字签名算法
	 */
	public final static String SIGNATURE_ALGORITHM_MD2withRSA  = "MD2withRSA";
	public final static String SIGNATURE_ALGORITHM_MD5withRSA  = "MD5withRSA";
	public final static String SIGNATURE_ALGORITHM_SHA1withRSA = "SHA1withRSA";
	public final static String SIGNATURE_ALGORITHM_SHA224withRSA = "SHA224withRSA";
	public final static String SIGNATURE_ALGORITHM_SHA256withRSA = "SHA256withRSA";
	public final static String SIGNATURE_ALGORITHM_SHA512withRSA = "SHA512withRSA";
	public final static String SIGNATURE_ALGORITHM_SHA1withDSA = "SHA1withDSA";

}
