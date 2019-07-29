package com.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式验证输入格式
 * 
 *
 */
public class RegexValidateUtils {
	private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{5,19}");
//	private static final Pattern PATTERN_DOMAIN = Pattern.compile("^[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?$");
	private static final Pattern PATTERN_EMAIL = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
	private static final Pattern PATTERN_MOBILE = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$");
	
	public static void main(String[] args) {
		System.out.println(isMobileNumber(null));
	}
    /**
     * 验证用户名
     */
	public static boolean isUserName(String username){
		boolean flag = false;
		try {
			Matcher matcher = PATTERN_USERNAME.matcher(username);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
    /**
     * 验证长度
     */
	public static boolean isLength(String value ,Integer minL , Integer maxL){
		if(value==null){
			return false;
		}else{
			Integer len = value.length();
			if(len>=minL && len<=maxL){
				return true;
			}else{
				return false;
			}
		}
	}
    /**
     * 验证域名
     */
//	public static boolean isDomain(String domain){
//		boolean flag = false;
//		try {
//			Matcher matcher = PATTERN_DOMAIN.matcher(domain);
//			flag = matcher.matches();
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}
	/**
	 * 验证邮箱
	 */
	public static boolean isEmail(String email) {
		boolean flag = false;
		try {
			Matcher matcher = PATTERN_EMAIL.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	/**
	 * 验证手机号码
	 */
	public static boolean isMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Matcher matcher = PATTERN_MOBILE.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}