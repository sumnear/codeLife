package test.testThreadPool;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;  
  
public class ExecutorServiceTest2 {  
    public static void main(String[] args) {  
    	Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
	    cal.set(Calendar.HOUR_OF_DAY, 2);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    System.out.println(cal.getTimeInMillis()- System.currentTimeMillis());
	    long initialDelay =(cal.getTimeInMillis()- System.currentTimeMillis())/1000/3600;
	    System.out.println(initialDelay);
    	ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(()->System.out.println(new Date()), initialDelay, 5, TimeUnit.SECONDS);
    }  
}  
  
