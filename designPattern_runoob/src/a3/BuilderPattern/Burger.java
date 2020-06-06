package designPattern_runoob.a3.BuilderPattern;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

}