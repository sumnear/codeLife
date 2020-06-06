package com.sumnear.bingfa.futuredp2;

public class Client {

	public static void main(String[] args) {
		FutureData future = new FutureData("testtttt");
		System.out.println("请求完毕");
//		try {
//			//这里可以用一个sleep代替了对其他业务逻辑的处理
//			//在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("数据="+future.getResult());
	}
}
