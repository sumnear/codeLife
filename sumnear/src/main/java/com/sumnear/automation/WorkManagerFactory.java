package com.sumnear.automation;

import java.util.HashMap;
import java.util.Map;

import com.sumnear.automation.impl.WorkManagerImpl;
import com.sumnear.automation.impl.WorkStrategyImpl;

/**
 *
 * @author SumNear
 * @date 2017��8��4�� ����1:12:44
 * @Description: ����������������ȡ�Զ������أ��Զ����ϴ����Զ���ת�����������springע�룬������ʹ�øù����࣬
 *               ֻҪ��֤��spring�����WorkManagerImplΪ�������ɡ�
 */
public class WorkManagerFactory {

	// ʵ����ÿ�� manager����֤manager����
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


	// ���spring�����쳣��û�м��ظ��࣬���Լ���ʼ��
	private synchronized static void init() {
		System.out.println(WorkManagerFactory.class + " init manager instance");
		if (workManagerMap!=null) {
			System.out.println("�Ѿ���ʼ���������ظ�������");
			return;
		}
		// ʵ����workmanager����map��
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
