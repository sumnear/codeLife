package com.sumnear.bingfa.futurejdk;

import java.util.concurrent.*;

public class FutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		main2();
		
	}
	private static void main1() throws InterruptedException, ExecutionException{
		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据=="+future.get());
	}
	private static void main2() throws InterruptedException, ExecutionException{
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<String> future = executor.submit(new RealData("a"));
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据=="+future.get());
	}
}
