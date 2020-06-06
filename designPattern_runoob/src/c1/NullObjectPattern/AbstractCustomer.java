package designPattern_runoob.c1.NullObjectPattern;

/*
 * �ն���ģʽ

�ڿն���ģʽ��Null Object Pattern���У�һ���ն���ȡ�� NULL ����ʵ���ļ�顣Null �����Ǽ���ֵ�����Ƿ�Ӧһ�������κζ����Ĺ�ϵ�������� Null ����Ҳ���������ݲ����õ�ʱ���ṩĬ�ϵ���Ϊ��

�ڿն���ģʽ�У����Ǵ���һ��ָ������Ҫִ�еĲ����ĳ��������չ�����ʵ���࣬������һ��δ�Ը������κ�ʵ�ֵĿն����࣬�ÿն����ཫ�޷��ʹ������Ҫ����ֵ�ĵط���
ʵ��

���ǽ�����һ�����������������ǿͻ������ƣ��� AbstractCustomer �����࣬����չ�� AbstractCustomer ���ʵ���ࡣ������ CustomerFactory ���ڿͻ����ݵ����������� RealCustomer �� NullCustomer ����

NullPatternDemo�����ǵ���ʾ��ʹ�� CustomerFactory ����ʾ�ն���ģʽ���÷���
 */
public abstract class AbstractCustomer {
	protected String name;

	public abstract boolean isNil();

	public abstract String getName();
}