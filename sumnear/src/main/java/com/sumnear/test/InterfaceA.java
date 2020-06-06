package test;

public interface InterfaceA extends InterfaceB {
	public default void ddd() {
		System.out.println("A--DDD");
	}
}
