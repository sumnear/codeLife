package com.sumnear.limiting;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author SumNear
 * @date 2017年11月1日 下午1:59:12
 * @Description: drop的管理者，方便多线程客户端获得的drop是对的
 */
public class DropPoolManager {
	private static final DropPoolManager singleton = new DropPoolManager();
	private static final Integer DEFAULT_CAPACITY = 10;
	private static final Integer DEFAULT_TIMENODE = 30;
	private static final HashMap<Integer, Drop> dropPool = new HashMap<>();
	private static final ExecutorService dropBuilderService = Executors.newSingleThreadExecutor();
	
	private DropPoolManager() {
		super();
	}
	public static DropPoolManager getSingleton() {
		return singleton;
	}
    public Integer getPoolSize(){
    	return dropPool.size();
    }
    /*
     * 从map中获取drop对象，并不是阻塞的，所以限流功能会有一丢丢延迟
     */
    public LimitingInterface getDrop(Integer key){
    	LimitingInterface drop = dropPool.get(key);
    	if(drop == null){
    		updatePool(key,DEFAULT_CAPACITY,DEFAULT_TIMENODE);
    	}
    	return drop;
    }
	public void updateDrop(Integer key, Integer capacity,Integer timeNode) {
		dropBuilderService.execute(new Runnable() {
			@Override
			public void run() {
					dropPool.put(key,new Drop(key, capacity,timeNode));
			}
		});
	}
	private void updatePool(Integer key, Integer capacity,Integer timeNode) {
		dropBuilderService.execute(new Runnable() {
			@Override
			public void run() {
				if(dropPool.containsKey(key)){
					return;
				}else{
					dropPool.put(key,new Drop(key, capacity,timeNode));
				}
			}
		});
	}

	
}
