package test.testThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFurther {  
	  
    public static void main(String[] args) {  
        ExecutorService executorService = Executors.newFixedThreadPool(1);  
        FutureTask<Boolean> futureTask = new FutureTask<>(  
                new Callable<Boolean>() {  
                    @Override  
                    public Boolean call() throws Exception {  
                        System.out.println("不告诉你。");  
                        Thread.sleep(1000 * 5);  
                        System.out.println("8888888888");  
                        return false;  
                    }  
                });  
        Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
				 while(true){
						Thread.sleep(1000);
						System.out.println(System.currentTimeMillis());
				 }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		};
        System.out.println(runnable);
//        try {  
//            executorService.submit(futureTask).get(2, TimeUnit.SECONDS);  
//        } catch (InterruptedException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        } catch (ExecutionException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        } catch (TimeoutException e) {  
//            System.out.println("超时了吧~~~");  
////            e.printStackTrace();  
//            //executorService.shutdownNow();  
//        }  
        executorService.execute(runnable);  
        executorService.execute(runnable); 
        try {
 			Thread.sleep(1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        executorService.shutdownNow();
        try {
 			Thread.sleep(1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        executorService.execute(runnable); 
//        List<Runnable> list = executorService.shutdownNow();
//     
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//        System.out.println(list.size());
//        for (Runnable r : list) {
//			System.out.println(r);
//			
//		}
//        executorService.submit(futureTask);  
    }  
}