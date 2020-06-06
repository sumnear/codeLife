package com.sumnear.bingfa;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static class Soldier implements Runnable {
		private String soldier;
		private final CyclicBarrier cyclic;

		public Soldier(String soldier, CyclicBarrier cyclic) {
			this.soldier = soldier;
			this.cyclic = cyclic;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				cyclic.await();
				doWork();
				cyclic.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				if(cyclic.isBroken()){
					System.out.println(soldier+"����");
				}
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		void doWork() {
			try {
				Thread.sleep(new Random().nextInt(10) * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(soldier + "�������");
		}
	}

	public static class BarrierRun implements Runnable {
		boolean flag;
		int N;

		public BarrierRun(boolean flag, int n) {
			this.flag = flag;
			N = n;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (flag) {
				System.out.println("˾�ʿ��" + N + "����������ɣ�");
			} else {
				System.out.println("˾�ʿ��" + N + "����������ϣ�");
				flag = true;

			}
		}

	}

	public static void main(String[] args) {
		final int N = 10;
		Thread[] allSoldier = new Thread[10];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
		System.out.println("���鼯��");
		for (int i = 0; i < N; i++) {
			System.out.println("ʿ��" + i + "������");
			allSoldier[i] = new Thread(new Soldier("ʿ��" + i, cyclic));
			allSoldier[i].start();
			if (i == 5) {
				allSoldier[0].interrupt();
			}

		}
	}

}
