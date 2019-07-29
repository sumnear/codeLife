package d1.visitor.test2;

public class Client {
	public static void main(String[] args) {
		Actor a = new ActorA();
		role r = new roleA();
		r.accept(a);
		r.accept(new ActorA());
}
}
