package itstack.demo.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Coder {

	/**
	 * Description: BASE64加密
	 * @param str
	 * @return
	 */
	public static String getBase64Str(String str){
		try {
			if(str==null||"".equals(str)){
				return null;
			}
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * Description: BASE64解密
	 * @param str
	 * @return
	 */
	public static String fromBase64Str(String str){
		byte[] src = null;
		try {
			if(str == null || "".equals(str)){
				return null;
			}
			BASE64Decoder decoder = new BASE64Decoder();
			src = decoder.decodeBuffer(str);
		} catch (IOException e) {
			return null;
		}
		return src.toString();
	}
}
