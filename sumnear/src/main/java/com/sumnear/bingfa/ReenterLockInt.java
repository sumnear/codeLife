package com.sumnear.bingfa;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.concurrent.locks.ReentrantLock;

//可中断
public class ReenterLockInt implements Runnable {
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;

	/**
	 * 控制加锁顺序，方便构造死锁；
	 */
	public ReenterLockInt(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				lock2.lockInterruptibly();
			} else {
				lock2.lockInterruptibly();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				lock1.lockInterruptibly();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread())
				lock1.unlock();
			if (lock2.isHeldByCurrentThread())
				lock2.unlock();
			System.out.println(Thread.currentThread().getId() + "thread exit!");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLockInt r1 = new ReenterLockInt(1);
		ReenterLockInt r2 = new ReenterLockInt(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		Thread.sleep(1000);
		 DeadlockChecker.check();
	}
}

class DeadlockChecker {
	private final static ThreadMXBean mbean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
	final static Runnable deadlockCheck = new Runnable() {
		
		@Override
		public void run() {
			while(true){
				long[] deadlockedThreadIds = mbean.findDeadlockedThreads();
				if(deadlockedThreadIds!=null){
					ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
					for (Thread t : Thread.getAllStackTraces().keySet()) {
						for (int i = 0; i < threadInfos.length; i++) {
							if(t.getId() == threadInfos[i].getThreadId()){
								t.interrupt();
							}
						}
					}
				}
			}
			
		}
	};
	public static void check() {
		Thread t = new Thread(deadlockCheck);
		t.setDaemon(true);
		t.start();
	}
}