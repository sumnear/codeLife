package designPattern_runoob.b9.ObserverPattern;

/*
 * �۲���ģʽ

����������һ�Զ��ϵʱ����ʹ�ù۲���ģʽ��Observer Pattern�������磬��һ�������޸�ʱ������Զ�֪ͨ�����������󡣹۲���ģʽ������Ϊ��ģʽ��
����

��ͼ�����������һ��һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�

��Ҫ�����һ������״̬�ı����������֪ͨ�����⣬����Ҫ���ǵ����ú͵���ϣ���֤�߶ȵ�Э����

��ʱʹ�ã�һ������Ŀ����󣩵�״̬�����ı䣬���е��������󣨹۲��߶��󣩶����õ�֪ͨ�����й㲥֪ͨ��

��ν����ʹ����������������Խ�����������ϵ������

�ؼ����룺�ڳ���������һ�� ArrayList ��Ź۲����ǡ�

Ӧ��ʵ���� 1��������ʱ������ʦ�۲���߱�ۣ�Ȼ��֪ͨ�����������߾��ۡ� 2�����μ���������������������캢������������һ��ˮ����һ�����ڹ꣬����ڹ���ǹ۲��ߣ����۲�������ˮ���������

�ŵ㣺 1���۲��ߺͱ��۲����ǳ�����ϵġ� 2������һ�״������ơ�

ȱ�㣺 1�����һ�����۲��߶����кܶ��ֱ�Ӻͼ�ӵĹ۲��ߵĻ��������еĹ۲��߶�֪ͨ���Ứ�Ѻܶ�ʱ�䡣 2������ڹ۲��ߺ͹۲�Ŀ��֮����ѭ�������Ļ����۲�Ŀ��ᴥ������֮�����ѭ�����ã����ܵ���ϵͳ������ 3���۲���ģʽû����Ӧ�Ļ����ù۲���֪�����۲��Ŀ���������ô�����仯�ģ�������ֻ��֪���۲�Ŀ�귢���˱仯��

ʹ�ó����� 1���ж�����๲�еķ��������߼���ͬ�� 2����Ҫ�ġ����ӵķ��������Կ�����Ϊģ�巽����

ע����� 1��JAVA ���Ѿ����˶Թ۲���ģʽ��֧���ࡣ 2������ѭ�����á� 3�����˳��ִ�У�ĳһ�۲��ߴ���ᵼ��ϵͳ���ǣ�һ������첽��ʽ��
ʵ��

�۲���ģʽʹ�������� Subject��Observer �� Client��Subject ������а󶨹۲��ߵ� Client ����ʹ� Client ������۲��ߵķ��������Ǵ��� Subject �ࡢObserver ���������չ�˳����� Observer ��ʵ���ࡣ

ObserverPatternDemo�����ǵ���ʾ��ʹ�� Subject ��ʵ�����������ʾ�۲���ģʽ��
 */
public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}
}