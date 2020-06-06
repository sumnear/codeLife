package test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 14-6-18 Time: 11:01 ����ShutdownHook
 */
public class TestShutdownHook {

	// ��ģ��ɻ��
	static Timer timer = new Timer("job-timer");

	// �����ɻ����
	static AtomicInteger count = new AtomicInteger(0);

	/**
	 * hook�߳�
	 */
	static class CleanWorkThread extends Thread {
		@Override
		public void run() {
			System.out.println("clean some work.");
			timer.cancel();
			try {
				Thread.sleep(2 * 1000);// sleep 2s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// ��hook�߳���ӵ�����ʱ������ȥ
		Runtime.getRuntime().addShutdownHook(new CleanWorkThread());
		System.out.println("main class start ..... ");
		// ��ģ��
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				count.getAndIncrement();
				System.out.println("doing job " + count);
				if (count.get() == 5) { // ����10���˳�
					System.exit(0);
				}
			}
		}, 0, 2 * 1000);

	}
}