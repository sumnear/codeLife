package d1.visitor.test;

public class Client {
	public static void main(String[] args) {
		Actor a = new ActorA();
		role r = new roleA();
		a.act(r);
		a.act(new roleA());
}
}
