package com.sumnear.bingfa;

import java.util.concurrent.locks.ReentrantLock;

//可重入锁例子
public class ReenterLock implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();
	public static int j = 0;
	@Override
	public void run() {
		for (int i = 0; i <10000000; i++) {
			lock.lock();
			//可重入
//			lock.lock();
			try {
				j++;
			} finally {
				lock.unlock();
//				lock.unlock();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ReenterLock tl = new ReenterLock();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(j);
	}
	
}
