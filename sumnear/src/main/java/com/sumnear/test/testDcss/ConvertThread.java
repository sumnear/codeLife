package test.testDcss;

import java.util.concurrent.Callable;

/**
 * 
 * @author SumNear
 * @date 2017��9��28�� ����4:11:10 
 * @Description: DCC�߳���
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
			System.out.println("ִ��DCCת�룬"+converter);
			Integer result = converter.converTest();
			//TODO:��¼һЩ��־ ֮�ࣻ
			return result;
		}catch(Exception e){
			return 888;
		}
		
	}

}
