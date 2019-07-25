package com.sumnear.c0602;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class Person4
{
	private String name;
	public Person4(String name)
	{
		this.name = name;
	}
}
public class PrintObject
{
	public static void main(String[] args)
	{
		// 创建一个Person对象，将之赋给p变量
		Person4 p = new Person4("孙悟空");
		// 打印p所引用的Person对象
		System.out.println(p);
	}
}

