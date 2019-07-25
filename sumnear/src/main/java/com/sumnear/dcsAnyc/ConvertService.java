package com.sumnear.dcsAnyc;

import java.util.Date;
import java.util.HashMap;

public class ConvertService {
	private static final ConvertService convertService = new ConvertService();

	private ConvertService() {
	}

	public static ConvertService getInstance() {
		return convertService;
	}

	public IResult<MapConvertParam> convert(ConvertParam param) {
		MapConvertParam mapparam = new MapConvertParam();
		IResult<MapConvertParam> convertResult;
		// TODO:可以写一些方法 判断是否?? 线程通信加???转??
		if (param.getType().equals("TIF")) {
			convertResult = asynDccConvert(param, null, mapparam);
		} else {
			convertResult = dccConvert(param, null, mapparam);
		}
		return convertResult;
	}

	public IResult<MapConvertParam> asynDccConvert(ConvertParam param, String convertMd5, MapConvertParam mapparam) {
		//
		IResult<Integer> resutl  = new MyConvertContrallar().exec(param);
		System.out.println(new Date() + "asynDccConvert结束");
		if (resutl.isSuccess()) {
			// 成功
			System.out.println("success source file");
			mapparam.setResultInfo(resutl.getMessage());
			mapparam.setPagecount(resutl.getData());
			mapparam.setResultvalue(0);
			mapparam.setState(1);
			return DefaultResult.successResult(resutl.getMessage(), mapparam);
		} else {
			System.out.println("failuer source file");
			mapparam.setResultInfo(resutl.getMessage());
			mapparam.setResultvalue(resutl.getData());
			mapparam.setState(2);
			return DefaultResult.failResult(resutl.getMessage(), mapparam);
		}
	}

	private class MyConvertContrallar {
		HashMap<String, String> asynData;

		MyConvertContrallar() {
			asynData = new HashMap<>();
		}

		IResult<Integer> exec(ConvertParam param) {
			synchronized (asynData) {
				Runnable r = new Runnable() {
					public void run() {
						System.out.println(new Date() + "线程通信转码 获取转换实例");
						ConvertInstance convertInstance = ConvertManager.instance.get();
						try {
							convertInstance.convert(param, asynData); // 转换结果
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println(e);
						} finally {
							System.out.println(new Date() + "线程通信转码 获取归还实例");
							ConvertManager.instance.free(convertInstance); // 确保即使转换过程发生异常，释放阻塞队??
						}
					}
				};
				try {
					Thread t = new Thread(r);
					t.setDaemon(true);
					t.start();
					asynData.wait(10000);
					if ("ok".equals(asynData.get("ok"))) {
						System.out.println("okokokokok");
						return DefaultResult.successResult("convert asynData 返回结果", 0);
					} else {
						System.out.println("null ok ok ok");
						return DefaultResult.failResult("convert asynData 返回结果", 1);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return DefaultResult.failResult("convert asynData 超时", 2);
				}
			}

		}
	}

	public IResult<MapConvertParam> dccConvert(ConvertParam param, String convertMd5, MapConvertParam mapparam) {
		ConvertInstance convertInstance = ConvertManager.instance.get();
		IResult<Integer> resutl = null;
		try {
			resutl = convertInstance.convert(param); // 转换结果
		} catch (Exception e) {
			System.out.println(e);
			resutl = DefaultResult.failResult();
		} finally {
			ConvertManager.instance.free(convertInstance); // 确保即使转换过程发生异常，释放阻塞队??
		}
		if (resutl.isSuccess()) {
			// 成功
			System.out.println("success source file");
			mapparam.setResultInfo(resutl.getMessage());
			mapparam.setPagecount(resutl.getData());
			mapparam.setResultvalue(0);
			mapparam.setState(1);
			return DefaultResult.successResult(resutl.getMessage(), mapparam);
		} else {
			System.out.println("failuer source file");
			mapparam.setResultInfo(resutl.getMessage());
			mapparam.setResultvalue(resutl.getData());
			mapparam.setState(2);
			return DefaultResult.failResult(resutl.getMessage(), mapparam);
		}
	}
}