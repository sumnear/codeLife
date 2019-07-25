package com.sumnear.automation;

/**
 * 
 * @author SumNear
 * @date 2017年8月7日 上午9:10:44 
 * @Description: 任务过程的标识enum
 */
public enum EnumTaskStep {
	READY(0, "就绪状态"), 
	
	DOWNLOAD_ING(1, "下载开始"),
	DOWNLOAD_CALLBACK(2, "下载回调"),
	DOWNLOAD_FAIL(3, "下载失败"),
	DOWNLOAD_SUCCESS(4, "下载成功"),
	
	CONVERT_ING(5, "转换开始"),
	CONVERT_CALLBACK(6, "转换回调"),
	CONVERT_FAIL(7, "转换失败"),
	CONVERT_SUCCESS(8, "转换成功"),
	
	UPLOAD_ING(9, "上传开始"),
	UPLOAD_CALLBACK(10, "上传回调"),
	UPLOAD_FAIL(11, "上传失败"),
	UPLOAD_SUCCESS(12, "上传成功");
	private Integer value;
	private String info;
	private EnumTaskStep(Integer value, String info) {
		this.value = value;
		this.info = info;
	}

	public Integer getValue() {
		return value;
	}

	public String getInfo() {
		return info;
	}


	public static EnumTaskStep getEnum(Integer value) {
		for (EnumTaskStep code : values()) {
			if (value == code.getValue())
				return code;
		}
		return null;
	}
}
