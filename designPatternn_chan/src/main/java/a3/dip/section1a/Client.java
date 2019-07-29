package a3.dip.section1a;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 业务场景类
 */
public class Client {
	public static void main(String[] args) {
		Driver zhangSan = new Driver();
		Benz benz = new Benz();
		
		//张三开奔驰车
		zhangSan.drive(benz);
	}
}
