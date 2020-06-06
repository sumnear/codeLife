package test.testProcess;

import java.util.Date;
import java.util.Random;

/**
 * @authore sumnear
 * @create 2019-6-28 9:15
 */
public class TestSleep
{
    public static void main(String[] args)
    {
        String a = new Random().nextInt(1000)+"";
        int count =  0 ;
        while (true){
            try {
                Thread.sleep(1000);
                count++;
                System.out.println(Thread.currentThread().getName()+"--"+a+"::"+count+"::"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
