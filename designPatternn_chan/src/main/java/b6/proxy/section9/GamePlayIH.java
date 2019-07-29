package b6.proxy.section9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 代练者
 */
public class GamePlayIH implements InvocationHandler {
	//被代理者
	// Class cls =null;
	//被代理的实例
	Object obj = null;
	
	//我要代理谁
	public GamePlayIH(Object _obj){
		this.obj = _obj;
	}
	
	//调用被代理的方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before");
		Object result = method.invoke(this.obj, args);
		System.out.println("after");
		return result;
	}
	
}
