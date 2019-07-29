package d4.flyweight.section2;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class Client {

	public static void main(String[] args) {
		System.gc();
		Runtime r = Runtime.getRuntime();
		System.out.println(r.maxMemory() / 1024/ 1024);
		System.out.println(r.totalMemory() / 1024/ 1024);
		System.out.println(r.freeMemory() / 1024/ 1024);
		SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");
		SignInfo signInfo2 = SignInfoFactory.getSignInfo("科目2考试地点1");
		System.gc();
		System.out.println(r.freeMemory() / 1024/ 1024);
		SignInfo signInfo3 = SignInfoFactory.getSignInfo("科目2考试地点1");
	}

}
