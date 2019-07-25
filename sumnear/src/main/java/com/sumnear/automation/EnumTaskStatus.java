package com.sumnear.automation;
/**
 * 返回对象的枚举类
 */
public enum EnumTaskStatus {
	E_STOP(0, "停止状态"), 
	E_START(1, "开始状态"),
	E_STOPPING(2, "正在停止");
	private Integer value;
	private String info;
	EnumTaskStatus(Integer value, String info) {
		this.value = value;
		this.info = info;
	}

	public Integer getValue() {
		return value;
	}

	public String getInfo() {
		return info;
	}


	public static EnumTaskStatus getEnum(Integer value) {
		for (EnumTaskStatus code : values()) {
			if (value == code.getValue())
				return code;
		}
		return null;
	}

}
