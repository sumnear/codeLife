package b6.proxy.test2;

public class BeforeAdvice implements IAdvice {

	@Override
	public void exec() {
		System.out.println("beforeAdvice");
	}

}
