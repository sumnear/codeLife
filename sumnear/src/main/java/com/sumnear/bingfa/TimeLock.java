package com.sumnear.bingfa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//ø…œﬁ ±
public class TimeLock implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)){
				Thread.sleep(6000);
			}else{
				System.out.println(Thread.currentThread().getName()+"get lock failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
		
	}
	public static void main(String[] args) {
		TimeLock tl = new TimeLock();
		Thread t1 = new Thread(tl,"sb1");
		Thread t2 = new Thread(tl,"sb2");
		t1.start();
		t2.start();
	}

}
