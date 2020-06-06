package designPattern_runoob.a3.BuilderPattern;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

}