package b1.singleton.section4;

public class A {
	static{
		System.out.println("static AAA");
	}
	public A() {
		System.out.println("AAA");
	}

	public A(int a) {
		System.out.println(a+"AAA");
	}

	public static void main(String[] args) {
		System.out.println(new B(1));
	}
}

class B extends A {
	static{
		System.out.println("static BBB");
	}
	public B() {
	      System.out.println("BBB");
		}
	public B(int a) {
      System.out.println(a+"BBB");
	}


}
