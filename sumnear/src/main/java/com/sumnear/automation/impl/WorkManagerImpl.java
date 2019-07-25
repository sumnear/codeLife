package com.sumnear.automation.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sumnear.automation.EnumTaskStatus;
import com.sumnear.automation.IWorkManager;
import com.sumnear.automation.IWorkStrategy;
import com.sumnear.automation.TaskStatusVO;

/**
 * 
 * @author SumNear
 * @date 2017年8月2日 下午3:09:35
 * @Description: TODO
 */
public class WorkManagerImpl implements IWorkManager {
	private EnumTaskStatus enumTaskStatus; // 执行任务状态
	private ExecutorService executorService; // worker线程池
	private IWorkStrategy workStrategy; // 策略worker

	public WorkManagerImpl(int poolSize, IWorkStrategy workStrategy) {
		this.enumTaskStatus = EnumTaskStatus.E_STOP;
		this.executorService = Executors.newFixedThreadPool(poolSize);
		this.workStrategy = workStrategy;
	}

	
	@Override
	public String toString() {
		return "WorkManagerImpl [enumTaskStatus=" + enumTaskStatus + ", executorService=" + executorService
				+ ", workStrategy=" + workStrategy + "]";
	}


	// 获取 scheduledExecutorService 任务执行状态
	@Override
	public TaskStatusVO status() {
		TaskStatusVO result = new TaskStatusVO();
		if(executorService!=null){
			ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
			Long completedTaskCount = pool.getCompletedTaskCount();
			Integer activeCount = pool.getActiveCount();
			Integer corePoolSize = pool.getCorePoolSize();
			Integer maximumPoolSize = pool.getMaximumPoolSize();
			Integer poolSize = pool.getPoolSize();
			Long taskCount = pool.getTaskCount();
			Integer statusVal = enumTaskStatus.getValue();
			String statusMsg = enumTaskStatus.getInfo();
			result.setCompletedTaskCount(completedTaskCount);
			result.setActiveCount(activeCount);
			result.setCorePoolSize(corePoolSize);
			result.setMaximumPoolSize(maximumPoolSize);
			result.setPoolSize(poolSize);
			result.setStatusMsg(statusMsg);
			result.setStatusVal(statusVal);
			result.setTaskCount(taskCount);
		}
		return result;
		
	}

	// 开始执行任务
	@Override
	public boolean start() {
		if (executorService == null || workStrategy == null || enumTaskStatus == null
				|| enumTaskStatus.getValue() != EnumTaskStatus.E_STOP.getValue()) {
			// 如果任务正在停止的状态则不能启动；
			return false;
		} else {
			// 修改enumTaskStatus状态；
			enumTaskStatus = EnumTaskStatus.E_START;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (enumTaskStatus.getValue() == EnumTaskStatus.E_START.getValue()) {
							if (status().getActiveCount() < 1) {
								// 一批任务执行完之后，再执行下一批
								workStrategy.autoWorking(executorService);
								//System.out.println(workStrategy +"执行");
							}
							Thread.sleep(5000);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						// 任务出错
						enumTaskStatus = EnumTaskStatus.E_STOP;
					}

				}
			}).start();
			return true;
		}
	}

	// 停止执行任务，并不是真的shutdown，只是修改worker状态，不再接收新的任务。
	@Override
	public void stop() {
//		SysLog4JUtils.error(workStrategy + "任务停止!");
		if (enumTaskStatus == EnumTaskStatus.E_START) {
			// 先讲任务修改为正在停止状态；
			enumTaskStatus = EnumTaskStatus.E_STOPPING;
			Thread stopListener = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (status().getActiveCount() > 1) {
//							SysLog4JUtils.error(workStrategy + "任务还有"
//									+ (status().getTaskCount() - status().getCompletedTaskCount())
//									+ "条任务执行完后将关闭");
							Thread.sleep(1000);
						}
						enumTaskStatus = EnumTaskStatus.E_STOP;
//						SysLog4JUtils.error(workStrategy +"任务已停止!");
					} catch (InterruptedException e) {
//						SysLog4JUtils.error(e);
						e.printStackTrace();
					}
				}
			});
			stopListener.setDaemon(true);
			stopListener.start();
		}
	}

	@Override
	public void destroy() {
		enumTaskStatus = EnumTaskStatus.E_STOP;
		executorService.shutdownNow();
	}
}
