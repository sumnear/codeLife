package com.sumnear.c0604;

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
public class PrivateFinalMethodTest
{
	private final void test(){}
}
class Sub extends PrivateFinalMethodTest
{
	// 下面方法定义将不会出现问题
	public void test(){}
}
