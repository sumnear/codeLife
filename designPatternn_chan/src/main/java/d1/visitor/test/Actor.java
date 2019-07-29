package d1.visitor.test;

public abstract class Actor {
	public void act(role r) {
		System.out.println("演员演任何角色");
	}
	public void act(roleA r) {
		System.out.println("演员演任何角色A");
	}

	public void act(roleB r) {
		System.out.println("演员演任何角色B");
	}
}
