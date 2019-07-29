package d1.visitor.test2;

public class ActorB extends Actor {

	@Override
	public void act(roleA r) {
		System.out.println("演员B演任何角色A");
	}
	@Override
	public void act(roleB r) {
		System.out.println("演员B演任何角色B");
	}
}
