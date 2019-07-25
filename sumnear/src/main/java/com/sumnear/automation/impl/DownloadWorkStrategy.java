package com.sumnear.automation.impl;

import java.util.concurrent.ExecutorService;

import com.sumnear.automation.IWorkStrategy;


/**
 * 
 * @author SumNear
 * @date 2017年8月4日 下午1:50:12
 * @Description: TODO
 */
public class DownloadWorkStrategy implements IWorkStrategy {
	private Integer taskNum;
//	private IConvertDBService convertDBServiceImpl;
//	private IAutomationService automationServiceImpl;

	public DownloadWorkStrategy() {
	}
    /*
     * 这里的构造函数注入，可以用spring的xml配置，但是如果用了，factory又要重新构造。。以后再说吧
     */
	public DownloadWorkStrategy(Integer taskNum) {
		super();
		this.taskNum = taskNum;
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//		convertDBServiceImpl = (IConvertDBService) wac.getBean("convertDBServiceImpl");
//		automationServiceImpl = (IAutomationService) wac.getBean("automationServiceImpl");
	}

	public Integer getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}
//	public IConvertDBService getConvertDBServiceImpl() {
//		return convertDBServiceImpl;
//	}
//	public void setConvertDBServiceImpl(IConvertDBService convertDBServiceImpl) {
//		this.convertDBServiceImpl = convertDBServiceImpl;
//	}
//	public IAutomationService getAutomationServiceImpl() {
//		return automationServiceImpl;
//	}
//	public void setAutomationServiceImpl(IAutomationService automationServiceImpl) {
//		this.automationServiceImpl = automationServiceImpl;
//	}
	@Override
	public void autoWorking(ExecutorService executorService) {
//		SysLog4JUtils.error("从数据库中查询出新的要执行的任务列表！");
//		ConvertQO query = new ConvertQO();
//		query.setStatus(EnumTaskStep.READY.getValue());
//		query.setPage(1);
//		query.setRows(taskNum);
//		query.setLimit();
//		List<ConvertPO> list = convertDBServiceImpl.selectConvert4TaskPage(query);
//		SysLog4JUtils.error(list.toString());
//		if (list == null || list.size() < 1) {
//			return;
//		} else {
//			for (ConvertPO re : list) {
//				executorService.execute(new Runnable() {
//					@Override
//					public void run() {
//						automationServiceImpl.download(re);
//					}
//				});
//			}
//		}
	}

}
