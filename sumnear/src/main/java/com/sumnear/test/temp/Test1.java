package test.temp;

import java.time.LocalDate;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadA());
		t1.start();
		t1.join(5000);
		t1.interrupt();
	}

}

class ThreadA implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println(LocalDate.now());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}