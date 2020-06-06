package test;

public interface InterfaceB {
	public default void ddd() {
		System.out.println("B--DDD");
	}

	public default void ccc() {
		System.out.println("B--CCC");
	}
}
