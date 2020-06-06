package test.testThreadPool;

import java.util.Random;
import java.util.concurrent.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

class MyExHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println(t+"\n"+e);
	}
	
}

public class ThreadPoolTest
{
	public static void main(String[] args)
		throws Exception
	{
		// �����㹻���߳���֧��4��CPU���е��̳߳�
		// ����һ�����й̶��߳�����6�����̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(1);
		
		// ʹ��Lambda���ʽ����Runnable����
		Runnable target = () -> {
			    Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int a = 1/0;
				System.out.println(a);
		};
		// ���̳߳����ύ�����߳�
		Future<String> future  = pool.submit(() -> {
		    Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int a = 1/0;
			return a+"";
	});
		future.get();
//		pool.execute(target);
//		pool.execute(target);
//		pool.submit(target);
//		pool.submit(target);
//		pool.submit(target);
//		pool.submit(target);
//		pool.submit(target);
		
//		new Thread(target).start();
		// �ر��̳߳�
		pool.shutdown();
		
	}
}

