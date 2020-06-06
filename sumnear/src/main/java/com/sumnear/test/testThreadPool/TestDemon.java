package test.testThreadPool;

public class TestDemon {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyRunnable(), "t1");
		t1.setDaemon(true);
		System.out.println(Thread.activeCount());
		t1.start();
		Thread.sleep(2000);
		for (int i = 0; i < 200; i++) {
			System.out.println("我是线程：" + Thread.currentThread().getName() + "--我还活着" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 10) {
				t1.interrupt();
			}
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			System.out.println("我是线程：" + Thread.currentThread().getName() + Thread.activeCount());
			Thread t2 = new Thread(new MyRunnable2(), "t2");
			t2.setDaemon(true);
			t2.start();
			while (true) {
				System.out.println("我是线程：" + Thread.currentThread().getName() + "--我还活着");

				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("我是线程：" + Thread.currentThread().getName() + "--我被干掉了" + Thread.currentThread().isInterrupted());
		}
	}

}

class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			while (true) {
				System.out.println("我是线程：" + Thread.currentThread().getName() + "--我还活着");

				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("我是线程：" + Thread.currentThread().getName() + "--我被干掉了" + Thread.currentThread().isInterrupted());
		}
	}

}