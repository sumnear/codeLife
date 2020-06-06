package designPattern_runoob.c7.CompositeEntityPattern;

/**
 * ���ʵ��ģʽ
 * 
 * ���ʵ��ģʽ��Composite Entity Pattern������ EJB �־û������С�һ�����ʵ����һ�� EJB ʵ��
 * bean�������˶����ͼ�⡣������һ�����ʵ��ʱ���ڲ��������� beans ���Զ����£���Ϊ�������� EJB ʵ�� bean ����ġ����������ʵ��
 * bean �Ĳ����ߡ�
 * 
 * ���ʵ�壨Composite Entity�� - ������Ҫ��ʵ�� bean���������Ǵ����ģ����߿��԰���һ�������ȶ������ڳ����������ڡ�
 * �����ȶ���Coarse-Grained Object�� - �ö�������������������Լ����������ڣ�Ҳ�ܹ�������������������ڡ�
 * ��������Dependent Object�� - ����������һ�������������������ڴ����ȶ���Ķ��� ���ԣ�Strategies�� -
 * ���Ա�ʾ���ʵ�����ʵ�塣
 * 
 * @author Near
 *
 */
public class Client {
	private CompositeEntity compositeEntity = new CompositeEntity();

	public void printData() {
		for (int i = 0; i < compositeEntity.getData().length; i++) {
			System.out.println("Data: " + compositeEntity.getData()[i]);
		}
	}

	public void setData(String data1, String data2) {
		compositeEntity.setData(data1, data2);
	}
}