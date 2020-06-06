package designPattern_runoob.c6.BusinessDelegatePattern;

/**
 * ҵ�����ģʽ
 * 
 * ҵ�����ģʽ��Business Delegate
 * Pattern�����ڶԱ�ʾ���ҵ�����������������������ͨ�Ż�Ա�ʾ������е�ҵ�������Զ�̲�ѯ���ܡ���ҵ���������������ʵ�塣
 * 
 * �ͻ��ˣ�Client�� - ��ʾ���������� JSP��servlet �� UI java ���롣 ҵ�����Business Delegate�� -
 * һ��Ϊ�ͻ���ʵ���ṩ������࣬���ṩ�˶�ҵ����񷽷��ķ��ʡ� ��ѯ����LookUp Service�� -
 * ���ҷ���������ȡ��ص�ҵ��ʵ�֣����ṩҵ������ҵ��������ķ��ʡ� ҵ�����Business Service�� -
 * ҵ�����ӿڡ�ʵ���˸�ҵ������ʵ���࣬�ṩ��ʵ�ʵ�ҵ��ʵ���߼���
 * 
 * ʵ��
 * 
 * ���ǽ����� Client��BusinessDelegate��BusinessService��LookUpService��JMSService ��
 * EJBService ����ʾҵ�����ģʽ�еĸ���ʵ�塣
 * 
 * BusinessDelegatePatternDemo�����ǵ���ʾ��ʹ�� BusinessDelegate �� Client ����ʾҵ�����ģʽ���÷���
 * 
 * @author Near
 *
 */
public class BusinessDelegate {
	private BusinessLookUp lookupService = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}
