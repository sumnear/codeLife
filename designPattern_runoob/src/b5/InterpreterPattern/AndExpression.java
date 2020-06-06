package designPattern_runoob.b5.InterpreterPattern;

/**
 * ������ģʽ
 * 
 * ������ģʽ��Interpreter
 * Pattern���ṩ���������Ե��﷨����ʽ�ķ�ʽ����������Ϊ��ģʽ������ģʽʵ����һ�����ʽ�ӿڣ��ýӿڽ���һ���ض��������ġ�����ģʽ������ SQL
 * ���������Ŵ�������ȡ� ����
 * 
 * ��ͼ������һ�����ԣ����������ķ���ʾ��������һ�������������������ʹ�øñ�ʶ�����������еľ��ӡ�
 * 
 * ��Ҫ���������һЩ�̶��ķ�����һ�����;��ӵĽ�������
 * 
 * ��ʱʹ�ã����һ���ض����͵����ⷢ����Ƶ���㹻�ߣ���ô���ܾ�ֵ�ý�������ĸ���ʵ������Ϊһ���������еľ��ӡ������Ϳ��Թ���һ����������
 * �ý�����ͨ��������Щ��������������⡣
 * 
 * ��ν���������﷨���������ս������ս����
 * 
 * �ؼ����룺���������࣬����������֮���һЩȫ����Ϣ��һ���� HashMap��
 * 
 * Ӧ��ʵ������������������ʽ���㡣
 * 
 * �ŵ㣺 1������չ�ԱȽϺã��� 2���������µĽ��ͱ��ʽ�ķ�ʽ�� 3������ʵ�ּ��ķ���
 * 
 * ȱ�㣺 1�������ó����Ƚ��١� 2�����ڸ��ӵ��ķ��Ƚ���ά���� 3��������ģʽ�����������͡� 4��������ģʽ���õݹ���÷�����
 * 
 * ʹ�ó����� 1�����Խ�һ����Ҫ����ִ�е������еľ��ӱ�ʾΪһ�������﷨���� 2��һЩ�ظ����ֵ����������һ�ּ򵥵����������б�
 * 3��һ�����﷨��Ҫ���͵ĳ�����
 * 
 * ע����������ó����Ƚ��٣�JAVA ��������������� expression4J ���档 ʵ��
 * 
 * ���ǽ�����һ���ӿ� Expression ��ʵ���� Expression �ӿڵ�ʵ���ࡣ������Ϊ����������Ҫ�������� TerminalExpression
 * �ࡣ�������� OrExpression��AndExpression ���ڴ������ʽ���ʽ��
 * 
 * InterpreterPatternDemo�����ǵ���ʾ��ʹ�� Expression �ഴ���������ʾ���ʽ�Ľ�����
 * 
 * @author Near
 *
 */
public class AndExpression implements Expression {

	private Expression expr1 = null;
	private Expression expr2 = null;

	public AndExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) && expr2.interpret(context);
	}
}