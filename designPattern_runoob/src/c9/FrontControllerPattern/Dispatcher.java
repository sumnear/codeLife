package designPattern_runoob.c9.FrontControllerPattern;

/**
 * ǰ�˿�����ģʽ
 * 
 * ǰ�˿�����ģʽ��Front Controller
 * Pattern���������ṩһ�����е���������ƣ����е����󶼽���һ����һ�Ĵ���������ô�������������֤/��Ȩ/��¼��־�����߸�������
 * Ȼ������󴫸���Ӧ�Ĵ�������������������ģʽ��ʵ�塣
 * 
 * ǰ�˿�������Front Controller�� - ����Ӧ�ó���������������ĵ����������Ӧ�ó�������ǻ��� web
 * ��Ӧ�ó���Ҳ�����ǻ��������Ӧ�ó��� ��������Dispatcher�� - ǰ�˿���������ʹ��һ������������������������Ӧ�ľ��崦�����
 * ��ͼ��View�� - ��ͼ��Ϊ����������Ķ���
 * 
 * ʵ��
 * 
 * ���ǽ����� FrontController��Dispatcher �ֱ���ǰ�˿������͵�������HomeView �� StudentView
 * ��ʾ����Ϊǰ�˿��������յ����������������ͼ��
 * 
 * FrontControllerPatternDemo�����ǵ���ʾ��ʹ�� FrontController ����ʾǰ�˿��������ģʽ��
 * 
 * @author Near
 *
 */
public class Dispatcher {
	private StudentView studentView;
	private HomeView homeView;

	public Dispatcher() {
		studentView = new StudentView();
		homeView = new HomeView();
	}

	public void dispatch(String request) {
		if (request.equalsIgnoreCase("STUDENT")) {
			studentView.show();
		} else {
			homeView.show();
		}
	}
}