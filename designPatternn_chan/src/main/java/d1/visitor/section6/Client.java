package d1.visitor.section6;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {

	public static void main(String[] args) {
		//定义一个演员
		AbsActor actor = new OldActor();
		//定义一个角色
		Role role = new KungFuRole();
		KungFuRole role2 = new KungFuRole();
		//开始演戏
		actor.act(role);
		actor.act(role2);
		actor.act(new KungFuRole());
	}
}
