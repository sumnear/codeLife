package a2.lsp.section6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 子类
 */
@SuppressWarnings("all")
public class Son extends Father {

	public ArrayList doSomething(HashMap map){
		System.out.println("子类被执行...");
		return new ArrayList();
	}
	@Override
	public void say(){
		System.out.println("我是儿子");
	}
}
