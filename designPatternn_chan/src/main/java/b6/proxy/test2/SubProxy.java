package b6.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubProxy implements InvocationHandler {
	public Object target;
	public SubProxy() {
	}
	public SubProxy(Object obj) {
		this.target = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(this.target, args);
	}

}
