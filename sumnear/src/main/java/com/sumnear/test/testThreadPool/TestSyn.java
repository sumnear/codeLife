package test.testThreadPool;

class PublicVar {

    public String username = "A";
    public String password = "AA";

    //ͬ��ʵ������
    public  void setValue(String username, String password) {
    	synchronized(this){
    		try {
                this.username = username;
                Thread.sleep(5000);
                this.password = password;

                System.out.println("method=setValue " +"\t" + "threadName="
                        + Thread.currentThread().getName() + "\t" + "username="
                        + username + ", password=" + password);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }

    //��ͬ��ʵ������
    public void getValue() {
    	synchronized(this){
        System.out.println("method=getValue " + "\t" +  "threadName="
                + Thread.currentThread().getName()+ "\t" + " username=" + username
                + ", password=" + password);
    	}
    }
}

//�߳���
class ThreadA extends Thread {

    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}

//������
public class TestSyn {

    public static void main(String[] args) {
        try {
            //�ٽ���Դ
            PublicVar publicVarRef = new PublicVar();

            //�����������߳�
            ThreadA thread = new ThreadA(publicVarRef);
            thread.start();

            Thread.sleep(200);// ��ӡ����ܴ�ֵ��СӰ��

            //�����߳��е���
            publicVarRef.getValue();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}