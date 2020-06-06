package test.testDcss;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author SumNear
 * @date 2017��9��28�� ����4:19:22
 * @Description: �ⲿ����Dcc����������
 */
public class ConvertFacade {
	public static Integer TIMEOUT = 2; // ��λ��

	public static void main(String[] args) throws InterruptedException {
		// ģ����߳�����DCC
		System.out.println("��ʼ");
		ConvertManager.instance.init();
		ConvertFacade f = new ConvertFacade();
		for (int i = 0; i < 2; i++) {
			System.out.println(i+"====");
			new java.lang.Thread(new Runnable() {
				@Override
				public void run() {
					Integer re = f.convert(new Object());
					System.out.println(Thread.currentThread().getName() +"===="+re);
				}
			}, "ģ���߳�" + i).start();

		}

		Thread.sleep(Long.MAX_VALUE);
	}

	public Integer convert(Object convertParamater) {
		// ��ȡDCCʵ��
		long start = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"���ڻ�ȡDCCʵ��");
		ConvertInstance converter = ConvertManager.instance.get();
		System.out.println(Thread.currentThread().getName()+":::��ȡDCCʵ��"+converter.toString()+"��������ʱ"+(System.currentTimeMillis()-start));
		FutureTask<Integer> task = new FutureTask<>(new ConvertThread(convertParamater, converter));
		Thread convertThread = new Thread(task);
		convertThread.start();
		// �����߳� ���õ�ʱ��
		Integer result = null;
		try {
			result = task.get(TIMEOUT, TimeUnit.SECONDS);
			// �����ʱ���ڻ�ȡ����˵��DCC�ɹ�ת���ˣ�

		} catch (InterruptedException e) {
			// �߳��ڵȴ���˯��������ռ��ʱ�׳����߳��ڻ֮ǰ���ڼ䱻�жϡ���ʱ����������ϣ�����Ե�ǰ�߳��Ƿ��жϣ�����������������׳����쳣��
			System.out.println(Thread.currentThread().getName()+":::InterruptedException"+":::"+converter.toString());
			result = 11;   
		} catch (ExecutionException e) {
			// ��ȡ����Ľ��ʱ������ֹ���׳����쳣
			System.out.println(Thread.currentThread().getName()+":::ExecutionException"+":::"+converter.toString());
			result = 12;
		} catch (TimeoutException e) {
			System.out.println(Thread.currentThread().getName()+":::TimeoutException"+":::"+converter.toString());
			result = 13;
			convertThread.interrupt();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+":::Exception"+":::"+converter.toString());
			result = 14;  //δ֪�쳣
			convertThread.interrupt();
		} finally {
			System.out.println("finally");
			ConvertManager.instance.free(converter);
		}
		return result;

	}

}
