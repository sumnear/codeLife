package test.testProcess;

import javax.swing.plaf.TableHeaderUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @authore sumnear
 * @create 2019-6-28 9:21
 */
public class TestProcess
{
    public static void main(String[] args) throws InterruptedException
    {
        testProcessConcurrent();

        while (true){
            Thread.sleep(100000);
        }
    }
    /**
     * 模拟 process  子进程启动子进程
     */
    private static void testProcessMid()
    {
        /**
         * 如果子进程A 又 启动了一个 子进程B，则要等 子进程A把 B关闭后，父进程才能关闭，不然进程B成野生状态
         */
        doProcessMid();
    }

    private static void testProcess()
    {
        doProcess();
    }
    /**
     * 模拟 process  并发问题
     */
    private static void testProcessConcurrent()
    {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    doProcess();
                }
            }).start();
        }

    }
    private static void doProcess(){
        ProcessBuilder pb = new ProcessBuilder("java","-classpath","E:\\Github\\javaLife\\WebContent\\WEB-INF" +
                "\\classes\\production\\javaLife\\","test.testProcess.TestSleep");
        Process process = null;
        try {
            Thread.sleep(10);
            process = pb.start();
            Thread.sleep(10);
            //获取进程的标准输入流
            final InputStream is1 = process.getInputStream();
            //获取进城的错误流
            final InputStream is2 = process.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            new Thread() {
                public void run() {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
                    try {
                        String line1 = null;
                        while ((line1 = br1.readLine()) != null) {
                            if (line1 != null){
                                System.out.println(line1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            new Thread() {
                public void  run() {
                    BufferedReader br2 = new  BufferedReader(new InputStreamReader(is2));
                    try {
                        String line2 = null ;
                        while ((line2 = br2.readLine()) !=  null ) {
                            if (line2 != null){
                                System.out.println(line2);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            boolean ret = process.waitFor(15, TimeUnit.SECONDS);

            System.out.println("return value:"+ret);
//            System.out.println(process.exitValue());
//            byte[] bytes = new byte[process.getInputStream().available()];
//            process.getInputStream().read(bytes);
//            System.out.println(123+new String(bytes));
        }catch (Exception ex){
            System.out.println("exexexeex");
            ex.printStackTrace();

        }finally {
            System.out.println("finally destory");
            process.destroy();
            try{
                if(process!=null){
                    process.getErrorStream().close();
                    process.getInputStream().close();
                    process.getOutputStream().close();
                }

            }
            catch(Exception ee){
                System.out.println("eeeeeeeee");
            }
        }

    }
    private static void doProcessMid(){
        ProcessBuilder pb = new ProcessBuilder("java","-classpath","E:\\Github\\javaLife\\WebContent\\WEB-INF" +
                "\\classes\\production\\javaLife\\","test.testProcess.TestMidProcess");
        Process process = null;
        try {
            process = pb.start();
            //获取进程的标准输入流
            final InputStream is1 = process.getInputStream();
            //获取进城的错误流
            final InputStream is2 = process.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            new Thread() {
                public void run() {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
                    try {
                        String line1 = null;
                        while ((line1 = br1.readLine()) != null) {
                            if (line1 != null){
                                System.out.println(line1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            new Thread() {
                public void  run() {
                    BufferedReader br2 = new  BufferedReader(new InputStreamReader(is2));
                    try {
                        String line2 = null ;
                        while ((line2 = br2.readLine()) !=  null ) {
                            if (line2 != null){
                                System.out.println(line2);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            boolean ret = process.waitFor(15, TimeUnit.SECONDS);

            System.out.println("return value:"+ret);
//            System.out.println(process.exitValue());
//            byte[] bytes = new byte[process.getInputStream().available()];
//            process.getInputStream().read(bytes);
//            System.out.println(123+new String(bytes));
        }catch (Exception ex){
            System.out.println("exexexeex");
            ex.printStackTrace();

        }finally {
            System.out.println("finally destory");
            process.destroy();
            try{
                if(process!=null){
                    process.getErrorStream().close();
                    process.getInputStream().close();
                    process.getOutputStream().close();
                }

            }
            catch(Exception ee){
                System.out.println("eeeeeeeee");
            }
        }

    }

    /**
     * 模拟 线程池异常情况
     */
    private static void testPoolEx(){

        ExecutorService es  =  Executors.newFixedThreadPool(1);

        es.submit(new Runnable()
        {
            @Override
            public void run()
            {
                    int a =  1/0;
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.submit(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(22222);
            }
        });


    }
}
