package com.sumnear.limiting;

import java.util.Random;

public class Client {
	public static void main(String[] args) throws InterruptedException {
//		DropManager manager = DropManager.getSingleton();
//		LimitingInterface d = manager.getDrop(1);
//		if(d !=null){
//			System.out.println(d.isAllow());
//		}else{
//			Thread.sleep(1000);
//			d = manager.getDrop(1);
//			System.out.println(d.isAllow());
//		}
		test5();
	}
	private static void test5() throws InterruptedException{
		DropPoolManager manager = DropPoolManager.getSingleton();
		while(true){
			new Thread(() -> {
				Integer k = new Random().nextInt(10);
				LimitingInterface d = manager.getDrop(k);
				if(d != null){
					boolean isAllow = d.isAllow();
					if(!isAllow){
						System.out.println(Thread.currentThread().getName()+":::限流======"+d);
					}else{
						System.out.println(Thread.currentThread().getName()+":::通过"+d);
					}
				}else{
					System.out.println(Thread.currentThread().getName()+":::没有获取到"+k);
				}
			}).start();
			Thread.sleep(100);
		}
	}
	
	private static void test4() throws InterruptedException{
		DropPoolManager manager = DropPoolManager.getSingleton();
		for (int i = 0; i < 1000000; i++) {
			int v = i;
			manager.getDrop(v);
		}
		while(manager.getPoolSize()<999999){
			
		}
	}
	private static void test3() throws InterruptedException{
		DropPoolManager manager = DropPoolManager.getSingleton();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				Integer k = new Random().nextInt(10);
				LimitingInterface d = manager.getDrop(k);
				if(d != null){
					boolean isAllow = d.isAllow();
					if(!isAllow){
						System.out.println(Thread.currentThread().getName()+":::"+d);
					}else{
						System.out.println(Thread.currentThread().getName()+":::通过 key"+k);
					}
				}else{
					System.out.println(Thread.currentThread().getName()+":::没有获取到"+k);
				}
			}).start();
			Thread.sleep(500);
		}
		System.out.println("线程生成完毕");
	}
	private static void test2(){
		DropPoolManager manager = DropPoolManager.getSingleton();
		for (int i = 0; i < 1000; i++) {
//			Integer k = new Random().nextInt(10);
			new Thread(() -> {
				LimitingInterface d = manager.getDrop(1);
				System.out.println(d==null?"没有获取到"+1:d);
			}).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("线程生成完毕");
	}
	private static void test1() throws InterruptedException {
		Drop d = new Drop(0, 10 ,30);
		Drop d2 = new Drop(2, 30 , 30);
//		 System.out.println("单线程执行测试");
//		 for(int i=0;i<200;i++){
//		 System.out.println("=====================================");
//		 System.out.println("第"+i+"次执行");
//		 System.out.println(d.isAllow());
//		 System.out.println(d.toString());
//		 System.out.println("=====================================");
//		 Thread.sleep(1000);
//		 }
		System.out.println("多线程执行测试");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						StringBuffer sb = new StringBuffer();
						sb.append("=====================================\n");
						sb.append(Thread.currentThread().getName() +"::");
						sb.append(d.isAllow() +"::");
						sb.append(d.toString() +"\n");
						sb.append("=====================================\n");
						System.out.println(sb);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		for (int i = 0; i < 10; i++) {
			new Thread(r,"线程"+i).start();
		}
		System.out.println(d2.isAllow());
		
	}
}
