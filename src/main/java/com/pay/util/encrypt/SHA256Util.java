package com.pay.util.encrypt;

import java.security.MessageDigest;

/**
 * 哈希散列256加密方式
 * @ClassName SHA256Util
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月23日 下午11:06:08
 *
 */
public class SHA256Util {

	/**
	 * 散列256加密
	 * @author shrChang.Liu
	 * @param origin
	 * @param charsetname
	 * @return
	 * @date 2018年6月23日 下午11:13:54
	 * @return String
	 * @description
	 */
	public static String SHA256Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			if (charsetname == null || "".equals(charsetname))
				resultString = Hex.encode(md.digest(resultString
						.getBytes()));
			else
				resultString = Hex.encode(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	public static void main(String []arg){
		System.out.println(SHA256Util.SHA256Encode("abc123", "gbk"));
	}

}
