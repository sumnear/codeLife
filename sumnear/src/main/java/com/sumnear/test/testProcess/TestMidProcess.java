package test.testProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @authore sumnear
 * @create 2019-6-28 13:16
 */
public class TestMidProcess
{
    public static void main(String[] args)
    {
        ProcessBuilder pb = new ProcessBuilder("java","-classpath","E:\\Github\\javaLife\\WebContent\\WEB-INF" +
                "\\classes\\production\\javaLife\\","test.testProcess.TestSleep");
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

            boolean ret = process.waitFor(30, TimeUnit.SECONDS);

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
            //一定要记得关闭自己的子进程
//            process.destroy();
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
}
