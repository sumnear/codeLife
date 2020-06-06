package test.testDcss;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author SumNear
 * @date 2017年9月28日 下午4:19:22
 * @Description: 外部调用Dcc的最终门面
 */
public class ConvertFacade {
	public static Integer TIMEOUT = 2; // 单位秒

	public static void main(String[] args) throws InterruptedException {
		// 模拟多线程请求DCC
		System.out.println("开始");
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
			}, "模拟线程" + i).start();

		}

		Thread.sleep(Long.MAX_VALUE);
	}

	public Integer convert(Object convertParamater) {
		// 获取DCC实例
		long start = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"正在获取DCC实例");
		ConvertInstance converter = ConvertManager.instance.get();
		System.out.println(Thread.currentThread().getName()+":::获取DCC实例"+converter.toString()+"：：：耗时"+(System.currentTimeMillis()-start));
		FutureTask<Integer> task = new FutureTask<>(new ConvertThread(convertParamater, converter));
		Thread convertThread = new Thread(task);
		convertThread.start();
		// 阻塞线程 设置的时间
		Integer result = null;
		try {
			result = task.get(TIMEOUT, TimeUnit.SECONDS);
			// 如果在时间内获取到，说明DCC成功转码了；

		} catch (InterruptedException e) {
			// 线程在等待、睡觉或其他占用时抛出，线程在活动之前或活动期间被中断。有时，方法可能希望测试当前线程是否被中断，如果是这样，立即抛出此异常。
			System.out.println(Thread.currentThread().getName()+":::InterruptedException"+":::"+converter.toString());
			result = 11;   
		} catch (ExecutionException e) {
			// 获取任务的结果时任务被中止则抛出此异常
			System.out.println(Thread.currentThread().getName()+":::ExecutionException"+":::"+converter.toString());
			result = 12;
		} catch (TimeoutException e) {
			System.out.println(Thread.currentThread().getName()+":::TimeoutException"+":::"+converter.toString());
			result = 13;
			convertThread.interrupt();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+":::Exception"+":::"+converter.toString());
			result = 14;  //未知异常
			convertThread.interrupt();
		} finally {
			System.out.println("finally");
			ConvertManager.instance.free(converter);
		}
		return result;

	}

}
