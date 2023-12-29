package com.neusoft.util;

/**
 * @Description: 字符串判断工具类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public class ParamUtil {

	/**
	 * @Description: 判断字符串是否能否转换为整形，如果不可以，赋为默认值
	 * @param str 字符串
	 * @param int 默认值
	 * @return: 字符串
	 * @exception: 无
	 */
	public static String stringToInt(String str, int def) {
		if (str == null || str.trim().length() == 0) {
			str = def + "";
		} else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				str = def + "";
			}
		}
		return str;
	}
}