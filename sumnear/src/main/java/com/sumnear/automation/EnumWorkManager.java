package com.sumnear.automation;

public enum EnumWorkManager {
	DOWNLOAD_WORKER(0, "下载"), 
	CONVERT_WORKER(1, "转换"),
	UPLOAD_WORKER(2, "上传");
	private Integer value;
	private String info;
	EnumWorkManager(Integer value, String info) {
		this.value = value;
		this.info = info;
	}

	public Integer getValue() {
		return value;
	}

	public String getInfo() {
		return info;
	}


	public static EnumWorkManager getEnum(Integer value) {
		for (EnumWorkManager code : values()) {
			if (value == code.getValue())
				return code;
		}
		return null;
	}
}
