package com.sumnear.jvm;

public class Demo1 {
public static void main(String[] args) {
	System.out.println(runStatic(1,2l,2.0f,new Object(),(byte)1));
}
	public static int runStatic(int i,long l,float f,Object o,byte b){
		return runStatic(i, l, f, o, b);
	}
}
