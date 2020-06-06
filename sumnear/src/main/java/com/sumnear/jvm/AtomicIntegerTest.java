package com.sumnear.jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	private int a = 0xDada_Cafe;
	private float b = 0x1.fffffeP+127f;
	private float c = 1996;
	// private float d=1996.3;
	// private int f=9999e2;
	private double g = 33e2;
	private float h = 0x1.fffep-12f;
	// private float i=1.fffep-12f;
	private long p = 0b1_1_1_0_1;

	// private long q=0b1_1_1_0_2;
	public static void main(String[] args) {
		AtomicInteger aq = new AtomicInteger();
		aq.get();
		System.out.println(0xDada_Cafe);
		int a = -6;
		for (int i = 0; i < 32; i++) {
			int t = (a & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(t);
		}
		System.out.println(Integer.toBinaryString(-6));
		方法();
	}

	public static void 方法() {
		System.out.println("你好");
	}
}
