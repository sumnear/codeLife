package a3.dip.section5;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 司机
 */
public class Driver implements IDriver{
	private ICar car;
	
	@Override
	public void setCar(ICar car){
		this.car = car;
	}
	
	//司机的主要职责就是驾驶汽车
	@Override
	public void drive(){
		this.car.run();
	}


}
