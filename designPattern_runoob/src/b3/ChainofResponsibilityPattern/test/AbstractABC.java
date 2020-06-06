package designPattern_runoob.b3.ChainofResponsibilityPattern.test;

public abstract class AbstractABC {
	public static final int A = 1;
	public static final int B = 2;
	public static final int C = 3;

	protected int level;

	protected AbstractABC nextABC;

	public void setNextABC(AbstractABC abc) {
		nextABC = abc;
	}

	public void chainFilter(int level, String msg) {
		if (level >= this.level) {
			doSomething(msg);
		}
		if (nextABC != null) {
			nextABC.doSomething(msg);
		}
	}

	protected abstract void doSomething(String msg);

}
