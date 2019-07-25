package com.sumnear.automation.impl;

import java.util.concurrent.ExecutorService;

import com.sumnear.automation.EnumWorkManager;
import com.sumnear.automation.IWorkStrategy;

/**
 * 
 * @author SumNear
 * @date 2017年8月4日 下午1:50:12
 * @Description: TODO
 */
public class WorkStrategyImpl implements IWorkStrategy {
	private Integer taskNum;
//	private IConvertDBService convertDBServiceImpl;
//	private IAutomationService automationServiceImpl;
	private EnumWorkManager enumWorkManager;

	public WorkStrategyImpl() {
	}

	/*
	 * 这里的构造函数注入，可以用spring的xml配置，但是如果用了，factory又要重新构造。。以后再说吧
	 */
	public WorkStrategyImpl(Integer taskNum, EnumWorkManager enumWorkManager) {
		super();
		this.taskNum = taskNum;
		this.enumWorkManager = enumWorkManager;
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//		this.convertDBServiceImpl = (IConvertDBService) wac.getBean("convertDBServiceImpl");
//		this.automationServiceImpl = (IAutomationService) wac.getBean("automationServiceImpl");
	}

	public Integer getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}
//
//	public IConvertDBService getConvertDBServiceImpl() {
//		return convertDBServiceImpl;
//	}
//
//	public void setConvertDBServiceImpl(IConvertDBService convertDBServiceImpl) {
//		this.convertDBServiceImpl = convertDBServiceImpl;
//	}
//
//	public IAutomationService getAutomationServiceImpl() {
//		return automationServiceImpl;
//	}
//
//	public void setAutomationServiceImpl(IAutomationService automationServiceImpl) {
//		this.automationServiceImpl = automationServiceImpl;
//	}

	public EnumWorkManager getEnumWorkManager() {
		return enumWorkManager;
	}

	public void setEnumWorkManager(EnumWorkManager enumWorkManager) {
		this.enumWorkManager = enumWorkManager;
	}

	@Override
	public String toString() {
		return "WorkStrategyImpl [taskNum=" + taskNum +  ", enumWorkManager=" + enumWorkManager + "]";
	}

	@Override
	public void autoWorking(ExecutorService executorService) {
		/*if (enumWorkManager == null || taskNum == null || convertDBServiceImpl == null
				|| automationServiceImpl == null) {
			SysLog4JUtils.error("WorkStrategyImpl初始化失败！请检查配置文件！！" +toString());
		} else {
			
			ConvertQO query = new ConvertQO();
			query.setPage(1);
			query.setRows(taskNum);
			switch (enumWorkManager) {
			case DOWNLOAD_WORKER:
				query.setStatus(EnumTaskStep.READY.getValue());
				break;
			case CONVERT_WORKER:
				query.setStatus(EnumTaskStep.DOWNLOAD_SUCCESS.getValue());
				break;
			case UPLOAD_WORKER:
				query.setStatus(EnumTaskStep.CONVERT_SUCCESS.getValue());
				break;
			default:
				break;
			}
			query.setLimit();
			SysLog4JUtils.error(enumWorkManager.getInfo() + "从数据库中查询出新的要执行的任务列表！query:" +query);
			if (query.getStatus() == null) {
				SysLog4JUtils.error("WorkStrategyImpl查询需要执行的任务参数query为空错误！");
				return;
			} else {
				List<ConvertPO> list = convertDBServiceImpl.selectConvert4TaskPage(query);
//				SysLog4JUtils.error(list.toString());
				if (list == null || list.size() < 1) {
					return;
				} else {
//					list.sort(new Comparator<ConvertPO>() {
//
//						@Override
//						public int compare(ConvertPO o1, ConvertPO o2) {
//							// TODO Auto-generated method stub
//							return 0;
//						}
//					});
					list.sort((o1,o2) ->{
						return o1.getFileSize()-o2.getFileSize();
					});
					for (ConvertPO re : list) {
						executorService.execute(new Runnable() {
							@Override
							public void run() {
								automationServiceImpl.asynTaskApi(re, enumWorkManager);
								//TODO:中间休息一些时间
//								switch (enumWorkManager) {
//								case DOWNLOAD_WORKER:
//									automationServiceImpl.download(re);
//									break;
//								case CONVERT_WORKER:
//									automationServiceImpl.convert(re);
//									break;
//								case UPLOAD_WORKER:
//									automationServiceImpl.upload(re);
//									break;
//								default:
//									break;
//								}
							}
						});
					}
				}
			}

		}*/

	}

}
