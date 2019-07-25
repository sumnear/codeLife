package com.sumnear.dcsAnyc;


//模拟 controllar
public class Client {
	public static void main(String[] args) {
		init();
//		dccConvert();
		dccAsynConvert();

		System.out.println("main结束");
		try {
			Thread.sleep(50000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//listen
	private static void init(){
		ConvertManager.instance.init();
	}
	//普通调用
	private static void dccConvert(){
		ConvertParam param = new ConvertParam();
		param.setType("JPG");
		IResult<MapConvertParam> re = ConvertService.getInstance().convert(param);
		System.out.println(re.getMessage());
		System.out.println(re.getData().getResultvalue());
	}
	//异步调用
	private static void dccAsynConvert(){
		ConvertParam param = new ConvertParam();
		param.setType("TIF");
		//进入异步处理，controllar无感是否加
		IResult<MapConvertParam> re = ConvertService.getInstance().convert(param);
		System.out.println(re.getMessage());
		System.out.println(re.getData().getResultvalue());
	}


}
