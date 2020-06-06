package com.sumnear.jvm;

//ËøÏû³ı
public class EliminateLocksTest {
	public static void main(String args[]) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000000; i++) {
			craeteStringBuffer("JVM", "Diagnosis");
		}
		long bufferCost = System.currentTimeMillis() - start;
		System.out.println("craeteStringBuffer: " + bufferCost + " ms");
	}

	public static String craeteStringBuffer(String s1, String s2) {
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		return sb.toString();
	}

}
