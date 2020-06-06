package test;

import java.io.UnsupportedEncodingException;

public class TestString {
	public static void main(String[] args) throws UnsupportedEncodingException {
		char[] a = { 'a', 'b', 'c', 'd', 'd', 'd', 'd', 'd', 'd' };
		String v = "ejb";
		v.getChars(0, 3, a, 5);
		System.out.println(a);
		System.out.println(new String(new String("ÖÐÎÄ").getBytes("UTF-8"), "gbk"));
		String encoding=System.getProperty("file.encoding");
		System.out.println("Default System Encoding: " + encoding);
	}
}
