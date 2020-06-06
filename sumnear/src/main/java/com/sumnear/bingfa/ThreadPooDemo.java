package com.sumnear.bingfa;

import java.util.concurrent.*;

public class ThreadPooDemo {
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(System.currentTimeMillis()+"thread id :"+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		MyTask task = new MyTask();
		ExecutorService es = Executors.newFixedThreadPool(5);
//		for (int i = 0; i < 10; i++) {
//			es.submit(task);
//		}
		ExecutorService es2 = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()){

			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("准备执行："+ Thread.currentThread().getName());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("执行之后："+ Thread.currentThread().getName());
			}

			@Override
			protected void terminated() {
				System.out.println("线程退出："+ Thread.currentThread().getName());
			}
			
		};
		for (int i = 0; i < 10; i++) {
			es2.submit(task);
		}
		es2.shutdown();
	}
}
