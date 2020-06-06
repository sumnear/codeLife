package com.sumnear.bingfa.futuredp;

public class RealData implements Data{
	protected final String result;
	
	public RealData(String para) {
		//realdata的构造可能很慢，这里用sleep模拟
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.result = sb.toString();
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
