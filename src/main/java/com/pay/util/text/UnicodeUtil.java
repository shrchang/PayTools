package com.pay.util.text;

/**
 * unicode转码使用
 * 
 * @ClassName UnicodeUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月2日 上午9:57:06
 *
 */
public class UnicodeUtil {

	/**
	 * 中文转unicode编码
	 * @author shrChang.Liu
	 * @param gbString
	 * @return
	 * @date 2018年7月2日 上午9:57:42
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
	 * unicode编码转中文
	 * @author shrChang.Liu
	 * @param dataStr
	 * @return
	 * @date 2018年7月2日 上午9:57:52
	 * @return String
	 * @description
	 */
	public static String decodeUnicode(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
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
