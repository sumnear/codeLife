package com.sumnear.c0803;

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
class R6
{
	int count;
	public R6(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "R[count:" + count + "]";
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj != null && obj.getClass() == R6.class)
		{
			R6 r = (R6)obj;
			return this.count == r.count;
		}
		return false;
	}
	public int hashCode()
	{
		return this.count;
	}
}
public class HashSetTest2
{
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add(new R6(5));
		hs.add(new R6(-3));
		hs.add(new R6(9));
		hs.add(new R6(-2));
		// 打印HashSet集合，集合元素没有重复
		System.out.println(hs);
		// 取出第一个元素
		Iterator it = hs.iterator();
		R6 first = (R6)it.next();
		// 为第一个元素的count实例变量赋值
		first.count = -3;     // ①
		// 再次输出HashSet集合，集合元素有重复元素
		System.out.println(hs);
		// 删除count为-3的R对象
		hs.remove(new R6(-3));    // ②
		// 可以看到被删除了一个R元素
		System.out.println(hs);
		System.out.println("hs是否包含count为-3的R对象？"
			+ hs.contains(new R6(-3))); // 输出false
		System.out.println("hs是否包含count为-2的R对象？"
			+ hs.contains(new R6(-2))); // 输出false
	}
}
