package com.sumnear.dcsAnyc;

public class MapConvertParam {
	//	private ConvertParam param;
	private String resultInfo; // 转换好的描述
	private Integer resultvalue;
	private Integer pagecount; // 转换好的总页??
	private Integer state; // 转换状???(1转成??,0在转,2转换失败)
	private Integer threadNum; //有多少线程在等待

	public synchronized Integer getResultvalue() {
		return resultvalue;
	}

	public synchronized void setResultvalue(Integer resultvalue) {
		this.resultvalue = resultvalue;
	}

	public synchronized Integer getThreadNum() {
		return threadNum;
	}

	public synchronized void setThreadNum(Integer threadNum) {
		this.threadNum = threadNum;
	}

	public synchronized Integer getState() {
		return state;
	}

	public synchronized void setState(Integer state) {
		this.state = state;
	}

	public synchronized String getResultInfo() {
		return resultInfo;
	}

	public synchronized void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	public synchronized Integer getPagecount() {
		return pagecount;
	}

	public synchronized void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public synchronized void addThreadNum(){
		this.threadNum++;
	}

	public synchronized void reduceThreadNum(){
		this.threadNum--;
	}

//	public synchronized ConvertParam getParam() {
//	    return param;
//  }
//
//  public synchronized void setParam(ConvertParam param) {
//	    this.param = param;
//  }

	public static void main(String[] args) {
		MapConvertParam aa =new MapConvertParam();
		aa.setState(1);
		synchronized (aa) {
			System.out.println(aa.getState());
		}
	}
}
