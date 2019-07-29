package b6.proxy.test1;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		SubjectI sub = new Subject();
		SubjectI proxyS = (SubjectI) Proxy.newProxyInstance(sub.getClass().getClassLoader(),
				new Class[] { SubjectI.class }, new SubProxy(sub));
		proxyS.doSomething();
	}
}
