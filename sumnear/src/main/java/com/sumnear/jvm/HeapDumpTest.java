package com.sumnear.jvm;

public class HeapDumpTest {
	public static void main(String[] args) {
//			Vector v = new Vector<>();
//			for (int i = 0; i < 20; i++) {
//				v.add(new byte[1*1024*1024]);
//			}
			int a = 1;
			int b = a;
			int c = b; 
			    a = c;
			System.out.println(c);
	}
}
