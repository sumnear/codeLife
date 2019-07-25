package com.sumnear.automation;

import java.util.concurrent.ExecutorService;

/**
 * 
 * @author SumNear
 * @date 2017年8月4日 下午1:35:39 
 * @Description: 策略work的函数式接口
 */
@FunctionalInterface
public interface IWorkStrategy {
    
	//执行任务，并提交给线程池
	public void autoWorking(ExecutorService executorService);
}
