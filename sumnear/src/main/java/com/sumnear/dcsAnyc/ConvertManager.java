package com.sumnear.dcsAnyc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConvertManager {
	public static final ConvertManager instance=new ConvertManager();

	private ArrayBlockingQueue<ConvertInstance> pool;
	private ExecutorService worker;

	public void init(){
		//ConvertType.init();
		// DB.init();
		pool=new ArrayBlockingQueue<ConvertInstance>(5);
		for(int i=1;i<=5;i++){
			pool.add(new ConvertInstance(i));
			System.out.println("queue num:"+i);
		}
		this.worker = Executors.newFixedThreadPool(5);
	}
	public ExecutorService getExecutor(){
		return worker;
	}

	public int Size(){
		return pool.size();
	}
	public ConvertInstance get(){
		try {
			return pool.take();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void free(ConvertInstance instance){
		try {
			pool.put(instance);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
