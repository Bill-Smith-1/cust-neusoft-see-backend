package com.neusoft.util;

import java.security.MessageDigest;

/**
 * @Description: Md5加密工具类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public class Md5Utils {
	/**
	 * @Description: md5加密方法
	 * @param s 待加密字符串
	 * @return: 加密后字符串
	 * @exception: 无
	 */
	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String str1 = Md5Utils.md5("abc");
		System.out.println("str1=" + str1);
		String str2 = Md5Utils.md5("abc");
		System.out.println("str2=" + str2);
		String str3 = Md5Utils.md5("abd");
		System.out.println("str3=" + str3);
	}
}
