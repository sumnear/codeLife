package com.sumnear.bingfa.futuredp2;

public class Client {

	public static void main(String[] args) {
		FutureData future = new FutureData("testtttt");
		System.out.println("�������");
//		try {
//			//���������һ��sleep�����˶�����ҵ���߼��Ĵ���
//			//�ڴ�����Щҵ���߼��Ĺ����У�RealData���������Ӷ���������˵ȴ�ʱ��
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("����="+future.getResult());
	}
}
