package e9.observer_mediator.section2;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class Client {

	public static void main(String[] args) {
		Product p2 = new ProductManager().createProduct("aaa");
		System.out.println(p2.getName());
	}
}
