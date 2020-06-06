package com.springboot.chapter4.main;

import com.springboot.chapter4.intercept.MyInterceptor;
import com.springboot.chapter4.proxy.ProxyBean;
import com.springboot.chapter4.service.HelloService;
import com.springboot.chapter4.service.impl.HelloServiceImpl;

public class AopMain {

	public static void main(String[] args) {
		testProxy();
	}
	
	private static void testProxy() {
		HelloService helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("zhangsan");
		System.out.println("\n###############name is null!!#############\n");
		proxy.sayHello(null);
	}

}
