package designPattern_runoob.b6.IteratorPattern;

/*
 * ������ģʽ

������ģʽ��Iterator Pattern���� Java �� .Net ��̻����зǳ����õ����ģʽ������ģʽ����˳����ʼ��϶����Ԫ�أ�����Ҫ֪�����϶���ĵײ��ʾ��

������ģʽ������Ϊ��ģʽ��
����

��ͼ���ṩһ�ַ���˳�����һ���ۺ϶����и���Ԫ��, �������뱩¶�ö�����ڲ���ʾ��

��Ҫ�������ͬ�ķ�ʽ�������������϶���

��ʱʹ�ã�����һ���ۺ϶���

��ν��������Ԫ��֮�����ߵ����ν����������������Ǿۺ϶���

�ؼ����룺����ӿڣ�hasNext, next��

Ӧ��ʵ����JAVA �е� iterator��

�ŵ㣺 1����֧���Բ�ͬ�ķ�ʽ����һ���ۺ϶��� 2�����������˾ۺ��ࡣ 3����ͬһ���ۺ��Ͽ����ж�������� 4���ڵ�����ģʽ�У������µľۺ���͵������඼�ܷ��㣬�����޸�ԭ�д��롣

ȱ�㣺���ڵ�����ģʽ���洢���ݺͱ������ݵ�ְ����룬�����µľۺ�����Ҫ��Ӧ�����µĵ������࣬��ĸ����ɶ����ӣ�����һ���̶���������ϵͳ�ĸ����ԡ�

ʹ�ó����� 1������һ���ۺ϶�������ݶ����뱩¶�����ڲ���ʾ�� 2����ҪΪ�ۺ϶����ṩ���ֱ�����ʽ�� 3��Ϊ������ͬ�ľۺϽṹ�ṩһ��ͳһ�Ľӿڡ�

ע�����������ģʽ���Ƿ����˼��϶���ı�����Ϊ�������һ���������������������ȿ�����������¶���ϵ��ڲ��ṹ���ֿ����ⲿ����͸���ط��ʼ����ڲ������ݡ�
ʵ��

���ǽ�����һ���������������� Iterator �ӿں�һ�����ص������� Container �ӿڡ�ʵ���� Container �ӿڵ�ʵ���ཫ����ʵ�� Iterator �ӿڡ�

IteratorPatternDemo�����ǵ���ʾ��ʹ��ʵ���� NamesRepository ����ӡ NamesRepository �д洢Ϊ���ϵ� Names��
 * 
 * */
public interface Container {
	public Iterator getIterator();
}