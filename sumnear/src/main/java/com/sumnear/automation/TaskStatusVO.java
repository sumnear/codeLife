package com.sumnear.automation;

/**
 * 
 * @author SumNear
 * @date 2017年8月4日 下午4:58:59 
 * @Description: 通过manager获取任务状态的VO
 */
public class TaskStatusVO {
	private Integer ActiveCount;	//正在执行的线程数量
	private Long CompletedTaskCount;	//完成的线程数量
	private Integer CorePoolSize;		//线程池的基本大小
	private Integer MaximumPoolSize;	//线程池中允许的最大线程数
	private Integer PoolSize;	//线程池中当前线程的数量		
	private Long TaskCount;		//当前任务数量
	private Integer statusVal;	//状态值 start  stop stopping
	private String statusMsg;	//状态描述
	public Integer getActiveCount() {
		return ActiveCount;
	}
	public void setActiveCount(Integer activeCount) {
		ActiveCount = activeCount;
	}
	public Integer getCorePoolSize() {
		return CorePoolSize;
	}
	public void setCorePoolSize(Integer corePoolSize) {
		CorePoolSize = corePoolSize;
	}
	public Integer getMaximumPoolSize() {
		return MaximumPoolSize;
	}
	public void setMaximumPoolSize(Integer maximumPoolSize) {
		MaximumPoolSize = maximumPoolSize;
	}
	public Integer getPoolSize() {
		return PoolSize;
	}
	public void setPoolSize(Integer poolSize) {
		PoolSize = poolSize;
	}
	public Long getTaskCount() {
		return TaskCount;
	}
	public void setTaskCount(Long taskCount) {
		TaskCount = taskCount;
	}
	public Integer getStatusVal() {
		return statusVal;
	}
	public void setStatusVal(Integer statusVal) {
		this.statusVal = statusVal;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	
	public Long getCompletedTaskCount() {
		return CompletedTaskCount;
	}
	public void setCompletedTaskCount(Long completedTaskCount) {
		CompletedTaskCount = completedTaskCount;
	}
	@Override
	public String toString() {
		return "TaskStatusVO [ActiveCount=" + ActiveCount + ", CompletedTaskCount=" + CompletedTaskCount
				+ ", CorePoolSize=" + CorePoolSize + ", MaximumPoolSize=" + MaximumPoolSize + ", PoolSize=" + PoolSize
				+ ", TaskCount=" + TaskCount + ", statusVal=" + statusVal + ", statusMsg=" + statusMsg + "]";
	}


	
	

}
