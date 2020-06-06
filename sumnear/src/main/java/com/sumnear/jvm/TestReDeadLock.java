package com.sumnear.jvm;

public class TestReDeadLock {
	public static void main(String[] args) throws Exception {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = a;
		//���Ͻ��������̶����
		Thread at = new Thread(a, "AThread");
		Thread bt = new Thread(b, "BThread");
		Thread ct = new Thread(c, "CThread");
		Thread dt = new Thread(d, "DThread");
		//�����߳�
		at.start();
		Thread.sleep(10);
		bt.start();
		Thread.sleep(10);
		ct.start();
		Thread.sleep(10);
		dt.start();

	}

}

class A extends P implements Runnable {

	P next;

	public A() {
	};

	public synchronized void getRes() {
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName()
				+ " | ������" + this.getClass().getSimpleName() + " ��ȡ����Դ | ׼�����ã�"
				+ next.getClass().getSimpleName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		next.getRes();
	}

	@Override
	public void run() {
		getRes();
	}

}

class B extends P implements Runnable {

	P next;

	public synchronized void getRes() {
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName()
				+ " | ������" + this.getClass().getSimpleName() + " ��ȡ����Դ | ׼�����ã�"
				+ next.getClass().getSimpleName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		next.getRes();
	}

	@Override
	public void run() {
		getRes();
	}

}

class C extends P implements Runnable {

	P next;

	public synchronized void getRes() {
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName()
				+ " | ������" + this.getClass().getSimpleName() + " ��ȡ����Դ | ׼�����ã�"
				+ next.getClass().getSimpleName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		next.getRes();
	}

	@Override
	public void run() {
		getRes();
	}

}

class D extends P implements Runnable {

	P next;

	public synchronized void getRes() {
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName()
				+ " | ������" + this.getClass().getSimpleName() + " ��ȡ����Դ | ׼�����ã�"
				+ next.getClass().getSimpleName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		next.getRes();
	}

	@Override
	public void run() {
		getRes();
	}

}

class P {
	public synchronized void getRes() {
	}
}