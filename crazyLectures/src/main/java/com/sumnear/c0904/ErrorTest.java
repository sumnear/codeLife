package com.sumnear.c0904;

import java.util.*;
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
public class ErrorTest
{
	// 声明一个泛型方法，该泛型方法中带一个T类型形参
	static <T> void test(Collection<T> from, Collection<T> to)
	{
		for (T ele : from)
		{
			to.add(ele);
		}
	}
	static void test2(Collection<? extends Number> from, Collection<Number> to)
	{
		for (Number ele : from)
		{
			to.add(ele);
		}
	}
	static void fromArrayToCollection(Object[] a,Collection<Object> c){
		for(Object o : a){
			c.add(o);
		}
	}
	public static void main(String[] args)
	{
		List<Object> as = new ArrayList<>();
		List<String> ao = new ArrayList<>();
		// 下面代码将产生编译错误
//		test(as , ao);
	}
}


