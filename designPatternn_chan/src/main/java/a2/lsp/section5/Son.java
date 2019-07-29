package a2.lsp.section5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 子类重载父类方法，入参范围更大，就会出问题
 */
public class Son extends Father {

	//缩小输入参数范围
	public Collection doSomething(HashMap map){
		System.out.println("子类被执行...");
		return map.values();
	}
}
