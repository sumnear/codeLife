package com.sumnear.bingfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable {
	final Semaphore semp = new Semaphore(15);
//	static int a = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semp.acquire();
//			a=a+1;
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId()+"dene!" );
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			semp.release();
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		SemapDemo demo = new SemapDemo();
		for (int i = 0; i < 500000; i++) {
			exec.submit(demo);
//			new Thread(demo).start();
		}
		exec.shutdown();
			
	}

}
