package d1.visitor.test2;

public class roleB implements role {
	@Override
	public void accept(Actor a) {
		a.act(this);
	}
}
