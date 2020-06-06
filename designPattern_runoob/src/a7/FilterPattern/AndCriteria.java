package designPattern_runoob.a7.FilterPattern;

/**
 * ������ģʽ

������ģʽ��Filter Pattern�����׼ģʽ��Criteria Pattern����һ�����ģʽ������ģʽ��������Աʹ�ò�ͬ�ı�׼������һ�����ͨ���߼������Խ���ķ�ʽ�����������������������͵����ģʽ���ڽṹ��ģʽ������϶����׼����õ�һ��׼��

ʵ��

���ǽ�����һ�� Person ����Criteria �ӿں�ʵ���˸ýӿڵ�ʵ���࣬������ Person ������б�CriteriaPatternDemo�����ǵ���ʾ��ʹ�� Criteria ���󣬻��ڸ��ֱ�׼�����ǵĽ�������� Person ������б�
 */
import java.util.List;

public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}
}