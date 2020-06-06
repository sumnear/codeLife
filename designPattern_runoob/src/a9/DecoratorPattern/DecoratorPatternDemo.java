package designPattern_runoob.a9.DecoratorPattern;

/**
 * װ����ģʽ
 * 
 * װ����ģʽ��Decorator
 * Pattern��������һ�����еĶ�������µĹ��ܣ�ͬʱ�ֲ��ı���ṹ���������͵����ģʽ���ڽṹ��ģʽ��������Ϊ���е����һ����װ��
 * 
 * ����ģʽ������һ��װ���࣬������װԭ�е��࣬���ڱ����෽��ǩ�������Ե�ǰ���£��ṩ�˶���Ĺ��ܡ�
 * 
 * ����ͨ�������ʵ������ʾװ����ģʽ���÷������У����ǽ���һ����״װ���ϲ�ͬ����ɫ��ͬʱ�ֲ��ı���״�ࡣ ����
 * 
 * ��ͼ����̬�ظ�һ���������һЩ�����ְ�𡣾����ӹ�����˵��װ����ģʽ������������Ϊ��
 * 
 * ��Ҫ�����һ��ģ�����Ϊ����չһ���ྭ��ʹ�ü̳з�ʽʵ�֣����ڼ̳�Ϊ�����뾲̬����������������չ���ܵ����࣬���������͡�
 * 
 * ��ʱʹ�ã��ڲ������Ӻܶ�������������չ�ࡣ
 * 
 * ��ν���������幦��ְ�𻮷֣�ͬʱ�̳�װ����ģʽ��
 * 
 * �ؼ����룺 1��Component ��䵱�����ɫ����Ӧ�þ���ʵ�֡� 2�����������úͼ̳� Component �࣬������չ����д���෽����
 * 
 * Ӧ��ʵ���� 1��������� 72 �䣬�������"����"�����ĸ�������һֻ���ӣ�����������������Ĺ��ܡ�
 * 2������һ������û�л��򶼿��Թ���ǽ�ϣ�����ͨ�������л���ģ�����ʵ�����ǻ��򱻹���ǽ�ϡ��ڹ���ǽ��֮ǰ�������Ա����ϲ�����װ���������ʱ����
 * �����ͻ����γ���һ�����塣
 * 
 * �ŵ㣺װ����ͱ�װ������Զ�����չ�������໥��ϣ�װ��ģʽ�Ǽ̳е�һ�����ģʽ��װ��ģʽ���Զ�̬��չһ��ʵ����Ĺ��ܡ�
 * 
 * ȱ�㣺���װ�αȽϸ��ӡ�
 * 
 * ʹ�ó����� 1����չһ����Ĺ��ܡ� 2����̬���ӹ��ܣ���̬������
 * 
 * ע������ɴ���̳С� ʵ��
 * 
 * ���ǽ�����һ�� Shape �ӿں�ʵ���� Shape �ӿڵ�ʵ���ࡣȻ�����Ǵ���һ��ʵ���� Shape �ӿڵĳ���װ����
 * ShapeDecorator������ Shape ������Ϊ����ʵ��������
 * 
 * RedShapeDecorator ��ʵ���� ShapeDecorator ��ʵ���ࡣ
 * 
 * DecoratorPatternDemo�����ǵ���ʾ��ʹ�� RedShapeDecorator ��װ�� Shape ����
 * 
 * @author Near
 *
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}