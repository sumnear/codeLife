package b6.proxy.test1;

public class Subject implements SubjectI {

	@Override
	public void doSomething() {
		System.out.println("我要做点事情");
	}

	public void doSomething2() {
		System.out.println("我要做点事情2");
	}
}
