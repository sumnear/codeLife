package b6.proxy.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubProxy implements InvocationHandler {
	public Object obj;
	public SubProxy() {
	}
	public SubProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before");
		Object result = method.invoke(obj, args);
		System.out.println("after");
		return result;
	}

}
