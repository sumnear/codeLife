package com.commons.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @author zw997
 * 
 */
public class PropertiesUtil {
	//private static final String filePath =PropertiesUtil.class.getClass().getResource("/").getFile().toString()+ "META-INF/url/url.properties";
	private static final String filePath =Thread.currentThread().getContextClassLoader().getResource("/").getPath()+ "META-INF/url/url.properties";
	// 根据key读取value
	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			String value = props.getProperty(key);
			//System.out.println(key +"="+ value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 读取properties的全部信息
	public static void readProperties() {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			Enumeration en =  props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 写入properties信息
	public static void writeProperties(String parameterName,
			String parameterValue) {
		Properties prop = new Properties();
		try {
			InputStream fis = new FileInputStream(filePath);
			// 从输入流中读取属性列表（键和元素对）
			prop.load(fis);
			// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(parameterName, parameterValue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			prop.store(fos, "Update '" + parameterName + "' value");
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating "
					+ parameterName + " value error");
		}
	}

	public static void main(String[] args) {
		readValue("dologin");
	}

}
