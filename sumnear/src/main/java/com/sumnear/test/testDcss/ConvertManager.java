package test.testDcss;

import java.util.concurrent.ArrayBlockingQueue;


public class ConvertManager {
	public static final ConvertManager instance=new ConvertManager();
	
	private ArrayBlockingQueue<ConvertInstance> pool;
		
	public void init(){
		pool=new ArrayBlockingQueue<ConvertInstance>(1);
		for(int i=1;i<=1;i++){
			pool.add(new ConvertInstance(i));
				System.out.println("queue num:"+i);
		}
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
