package com.sumnear.c0508;

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
class Animal2
{
	private void beat()
	{
		System.out.println("心脏跳动...");
	}
	public void breath()
	{
		beat();
		System.out.println("吸一口气，吐一口气，呼吸中...");
	}
}
// 继承Animal，直接复用父类的breath()方法
class Bird2 extends Animal2
{
	public void fly()
	{
		System.out.println("我在天空自在的飞翔...");
	}
}
// 继承Animal，直接复用父类的breath()方法
class Wolf2 extends Animal2
{
	public void run()
	{
		System.out.println("我在陆地上的快速奔跑...");
	}
}
public class InheritTest
{
	public static void main(String[] args)
	{
		Bird2 b = new Bird2();
		b.breath();
		b.fly();
		Wolf2 w = new Wolf2();
		w.breath();
		w.run();
	}
}
