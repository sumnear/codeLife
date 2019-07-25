package com.sumnear.automation;

/**
 * 
 * @author SumNear
 * @date 2017年8月4日 下午1:36:04 
 * @Description: workManager的高层接口
 */
public interface IWorkManager {
	
	public void stop();
	
	public boolean start();
	
	public TaskStatusVO status();
	
	public void destroy();

}
