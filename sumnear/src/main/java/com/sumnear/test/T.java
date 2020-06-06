package test;

public class T {
	final int d;


	static {
		System.out.println("静态方法可");
		a = 5;
	}
	private static int a = 6;

	{
		d = 5;
	}

	public T() {
		System.out.println("构造函数" + a);
	}

	public static void main(String[] args) {
		T t = new T();
		System.out.println(t.a);
		System.out.println(t.d);
		t.getClass();
	}
}
