package com.sumnear.automation.impl;

import com.sumnear.automation.EnumTaskStatus;
import com.sumnear.automation.TaskStatusVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @author SumNear
 * @date 2017年8月2日 下午3:09:35
 * @Description: TODO
 */

public class DownloadTaskManager {
	public static void main(String[] args) {
		DownloadTaskManager instance = DownloadTaskManager.getInstance();
		System.out.println(instance.start() ? "开始执行任务成功" : "开始执行任务失败");

	}

	// 确保该对象为单例
	private static final Integer WORKER_NUM = 5;
	private static final DownloadTaskManager instance = new DownloadTaskManager();
	private EnumTaskStatus enumTaskStatus; // 执行任务状态
	private ExecutorService executorService; // worker线程池

	// 私有化构造函数
	private DownloadTaskManager() {
		init();
	}

	// 该manager初始化操作
	private void init() {
		// 这是一个固定数量的线程池，需要控制并发量
		executorService = Executors.newFixedThreadPool(WORKER_NUM);
		enumTaskStatus = EnumTaskStatus.E_STOP;
	}

	// 获取 下载任务管理器
	public static DownloadTaskManager getInstance() {
		return instance;
	}

	// 获取 scheduledExecutorService 任务执行状态
	public TaskStatusVO getTaskStatus() {
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
		Long completedTaskCount = pool.getCompletedTaskCount();
		Integer activeCount = pool.getActiveCount();
		Integer corePoolSize = pool.getCorePoolSize();
		Integer maximumPoolSize = pool.getMaximumPoolSize();
		Integer poolSize = pool.getPoolSize();
		Long taskCount = pool.getTaskCount();
		Integer statusVal = enumTaskStatus.getValue();
		String statusMsg = enumTaskStatus.getInfo();
		TaskStatusVO result = new TaskStatusVO();
		result.setCompletedTaskCount(completedTaskCount);
		result.setActiveCount(activeCount);
		result.setCorePoolSize(corePoolSize);
		result.setMaximumPoolSize(maximumPoolSize);
		result.setPoolSize(poolSize);
		result.setStatusMsg(statusMsg);
		result.setStatusVal(statusVal);
		result.setTaskCount(taskCount);
		return result;
	}

	// 开始执行任务
	public boolean start() {
		if (enumTaskStatus.getValue() != EnumTaskStatus.E_STOP.getValue()) {
			// 如果任务正在停止的状态则不能启动；
			return false;
		} else {
			// 修改enumTaskStatus状态；
			enumTaskStatus = EnumTaskStatus.E_START;
			System.out.println("开始执行任务：" + new Date().toGMTString());
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							System.out.println(instance.getTaskStatus());
							if (instance.getTaskStatus().getStatusVal() == EnumTaskStatus.E_START.getValue()) {
								if(instance.getTaskStatus().getActiveCount() < 1){
									working();
								}
							}else{
								break;
							}
							Thread.sleep(5000);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
			return true;
		}
	}

	// 任务执行体
	private int working() {
		// 模拟生成 任务list
		int i = 0;
		List<Integer> list = new ArrayList<>();
		for (int j = i + 100; i < j; i++) {
			list.add(i);
		}
		System.out.println(list);
		for (int re : list) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						// 随机10s完成一个任务
						Thread.sleep(new Random().nextInt(5) * 1000);
						System.out.println("执行任务::" + re);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		return list.size();
	}

	// 停止执行任务，并不是真的shutdown，只是修改worker状态，不再接收新的任务。
	public void stop() {
		if (enumTaskStatus == EnumTaskStatus.E_START) {
			// 先讲任务修改为正在停止状态；
			enumTaskStatus = EnumTaskStatus.E_STOPPING;
			Thread stopListener = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
						while (pool.getActiveCount() > 1) {
							System.out.println(Thread.currentThread().getName() + ":::" + pool);
							Thread.sleep(1000);
						}
						enumTaskStatus = EnumTaskStatus.E_STOP;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			stopListener.setDaemon(true);
			stopListener.start();
		}
	}
}
