package com.sumnear.automation;

import java.util.HashMap;
import java.util.Map;

import com.sumnear.automation.impl.WorkManagerImpl;
import com.sumnear.automation.impl.WorkStrategyImpl;

/**
 *
 * @author SumNear
 * @date 2017年8月4日 下午1:12:44
 * @Description: 单例生产工厂，获取自动化下载，自动化上传，自动化转换。如果用了spring注入，则无需使用该工厂类，
 *               只要保证由spring管理的WorkManagerImpl为单例即可。
 */
public class WorkManagerFactory {

	// 实例化每个 manager，保证manager单例
	private static Map<Integer, IWorkManager> workManagerMap = null;

	public WorkManagerFactory(Map<Integer, IWorkManager> workManagerMap) {
		WorkManagerFactory.workManagerMap = workManagerMap;
	}

	public static IWorkManager getSingleWorkManager(EnumWorkManager enumWorkManager) {
		if (workManagerMap == null || workManagerMap.isEmpty()) {
			init();
		}
		IWorkManager manager = workManagerMap.get(enumWorkManager.getValue());
		return manager;
	}


	// 如果spring启动异常，没有加载该类，则自己初始化
	private synchronized static void init() {
		System.out.println(WorkManagerFactory.class + " init manager instance");
		if (workManagerMap!=null) {
			System.out.println("已经初始化。请勿重复操作！");
			return;
		}
		// 实例化workmanager放入map中
		workManagerMap = new HashMap<>();
		for (EnumWorkManager managerEnum : EnumWorkManager.values()) {
			switch (managerEnum) {
			case DOWNLOAD_WORKER:
				workManagerMap.put(EnumWorkManager.DOWNLOAD_WORKER.getValue(),
						new WorkManagerImpl(5, new WorkStrategyImpl(100,EnumWorkManager.DOWNLOAD_WORKER)));
				break;
			case CONVERT_WORKER:
				workManagerMap.put(EnumWorkManager.CONVERT_WORKER.getValue(),
						new WorkManagerImpl(5, new WorkStrategyImpl(100,EnumWorkManager.CONVERT_WORKER)));
				break;
			case UPLOAD_WORKER:
				workManagerMap.put(EnumWorkManager.UPLOAD_WORKER.getValue(),
						new WorkManagerImpl(5, new WorkStrategyImpl(100,EnumWorkManager.UPLOAD_WORKER)));
				break;
			default:
				break;
			}
		}
	}

	@Override
	public String toString() {
		if (workManagerMap == null || workManagerMap.isEmpty()) {
			return WorkManagerFactory.class + " is null";
		} else {
			String temp = "";
			for (Integer k : workManagerMap.keySet()) {
				temp += workManagerMap.get(k);
			}
			return "WorkManagerFactory " + temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(new WorkManagerFactory(null));
		IWorkManager manager = WorkManagerFactory.getSingleWorkManager(EnumWorkManager.DOWNLOAD_WORKER);
		System.out.println(manager);
	}

}
