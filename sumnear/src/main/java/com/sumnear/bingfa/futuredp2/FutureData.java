package com.sumnear.bingfa.futuredp2;

public class FutureData implements Data
{
	protected RealData realdata = null;
	protected boolean isReady = false;

	public FutureData()
	{
	}

	public FutureData(String queryStr)
	{
		new Thread(){
	public void run(){
		//RealData的构建很慢，所以在单独的线程中进行。
		RealData realdata = new RealData(queryStr);
		setRealData(realdata);
	}
}.start();
}

	public synchronized void setRealData(RealData realdata){
		if(isReady){
			return;
		}
		this.realdata = realdata;
		isReady = true;
		notifyAll();
	}
	
	
	@Override
	public synchronized String getResult() {
		while(!isReady){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		return realdata.result;
	}



}
