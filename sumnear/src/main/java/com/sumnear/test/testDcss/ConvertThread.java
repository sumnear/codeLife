package test.testDcss;

import java.util.concurrent.Callable;

/**
 * 
 * @author SumNear
 * @date 2017年9月28日 下午4:11:10 
 * @Description: DCC线程体
 */
public class ConvertThread implements Callable<Integer>{
	private Object convertParamater;
	private ConvertInstance converter;
	
	public ConvertThread(Object convertParamater,ConvertInstance converter){
		this.convertParamater = convertParamater;
		this.converter = converter;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		try{
			System.out.println("执行DCC转码，"+converter);
			Integer result = converter.converTest();
			//TODO:记录一些日志 之类；
			return result;
		}catch(Exception e){
			return 888;
		}
		
	}

}
