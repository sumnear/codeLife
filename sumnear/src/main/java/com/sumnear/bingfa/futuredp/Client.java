package com.sumnear.bingfa.futuredp;

public class Client {
	public Data request(final String queryStr){
		final FutureData future = new FutureData();
		new Thread(){
			public void run(){
				//RealData�Ĺ��������������ڵ������߳��н��С�
				RealData realdata = new RealData(queryStr);
				future.setRealData(realdata);
			}
		}.start();
		return future; //futuredata�ᱻ��������
	}
	public static void main(String[] args) {
		Client client = new Client();
		//������������أ���Ϊ�õ�����FutureData������RealData
		Data data = client.request("testttt");
		System.out.println("�������");
//		try {
//			//���������һ��sleep�����˶�����ҵ���߼��Ĵ���
//			//�ڴ�����Щҵ���߼��Ĺ����У�RealData���������Ӷ���������˵ȴ�ʱ��
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("����="+data.getResult());
	}
}
