package com.sumnear.dcsAnyc;

import java.util.HashMap;

public class ConvertInstance {
	private Convert converter;

	public ConvertInstance(Integer index) {
		converter = new Convert();
	}
	public IResult<Integer> convert(ConvertParam param) {
		return convert(param,null);
	}


	public IResult<Integer> convert(ConvertParam param, HashMap<String,String> asynData) {
		Integer re = 7;
		switch (param.getType()) {
			//加???的TIF
			case "TIF":
				//todo判断asynData不会null??
				re = converter.convertTIF(param.getInput(), param.getOutput(),asynData);
				break;
			case "JPG":
				re = converter.convertJPG(param.getInput(), param.getOutput());
				break;
			default:
				re = 6;
				break;
		}
		return DefaultResult.successResult("convert返回结果", re);
	}
}
