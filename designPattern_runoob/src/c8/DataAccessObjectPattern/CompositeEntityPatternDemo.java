package designPattern_runoob.c8.DataAccessObjectPattern;

/**
 * ���ݷ��ʶ���ģʽ
 * 
 * ���ݷ��ʶ���ģʽ��Data Access Object Pattern���� DAO ģʽ���ڰѵͼ������ݷ��� API
 * ������Ӹ߼���ҵ������з�����������������ݷ��ʶ���ģʽ�Ĳ����ߡ�
 * 
 * ���ݷ��ʶ���ӿڣ�Data Access Object Interface�� - �ýӿڶ�������һ��ģ�Ͷ�����Ҫִ�еı�׼������
 * ���ݷ��ʶ���ʵ���ࣨData Access Object concrete class�� -
 * ����ʵ���������Ľӿڡ����ฺ�������Դ��ȡ���ݣ�����Դ���������ݿ⣬Ҳ������ xml�������������Ĵ洢���ơ� ģ�Ͷ���/��ֵ����Model
 * Object/Value Object�� - �ö����Ǽ򵥵� POJO�������� get/set �������洢ͨ��ʹ�� DAO ������������ݡ�
 * 
 * ʵ��
 * 
 * ���ǽ�����һ����Ϊģ�Ͷ������ֵ����� Student ����StudentDao �����ݷ��ʶ���ӿڡ�StudentDaoImpl
 * ��ʵ�������ݷ��ʶ���ӿڵ�ʵ���ࡣDaoPatternDemo�����ǵ���ʾ��ʹ�� StudentDao ����ʾ���ݷ��ʶ���ģʽ���÷���
 * 
 * @author Near
 *
 */
public class CompositeEntityPatternDemo {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();

		// ������е�ѧ��
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// ����ѧ��
		Student student = studentDao.getAllStudents().get(0);
		student.setName("Michael");
		studentDao.updateStudent(student);

		// ��ȡѧ��
		studentDao.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	}
}