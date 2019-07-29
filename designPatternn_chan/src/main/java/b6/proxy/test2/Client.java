package b6.proxy.test2;

import java.lang.reflect.InvocationHandler;

public class Client {
	public static void main(String[] args) {
		SubjectI sub = new Subject();
		InvocationHandler handler = new SubProxy(sub);
		SubjectI proxy = DynamicProxy.newProxyInstance(
				sub.getClass().getClassLoader(), sub.getClass().getInterfaces(),
				handler);
		proxy.doSomething();
	}
}
