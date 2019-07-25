package com.sumnear.limiting;

/**
 * 
 * @author SumNear
 * @date 2017年11月1日 上午10:37:46
 * @Description: 限流最先单位
 */
public class Drop implements LimitingInterface {
	private Integer key; // 唯一标识 duc中域名key
	private Integer position = 0; // 流量指针 所有操作该指针的动作都要线程安全
	private Integer capacity = 10; // 流量上限
	private Integer timeNode = 30; // 时间节点 单位秒 每node秒 算一次流量
	private Long timeStamp = 0L; // 时间戳 用来比较

	public Drop(Integer key, Integer capacity, Integer timeNode) {
		super();
		this.key = key;
		this.capacity = capacity;
		this.timeNode = timeNode;
	}

	@Override
	public boolean isAllow() {
		// 1、获取当前用来对比的时间节点，如果过了 就重置 position，放行。
		// 没过 指针加一 比较 上限，根据上限决定是否放行
		Long timeNow = getTimeStamp(timeNode);
		// 如果不阻塞判断是过载的就直接返回false
		if (timeNow.equals(timeStamp) && (this.position >= capacity)) {
			return false;
		} else {
			// 如果没有过载就进入 安全线程进行计算
			synchronized (this) {
				if (timeNow.equals(timeStamp)) {
					if (this.position >= capacity) {
						return false;
					} else {
						this.position++;
						return true;
					}
				} else {
					if (timeNow - timeStamp == -1) {
						return false;
					} else {
						// 重置并放行
						timeStamp = timeNow;
						this.position = 1;
						return true;
					}
				}
			}
		}
	}
	private Long getTimeStamp(Integer seconds) {
		seconds = seconds == null ? 30 : seconds;
		return System.currentTimeMillis() / 1000 / seconds;
		// String hms = DateViewUtils.format(new Date(), "HH:mm:ss");
		// String[] time = hms.split(":");
		// Integer totalSeconds = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
		// return totalSeconds / seconds;
	}
	@Override
	public String toString() {
		return "Drop [key=" + key + ", position=" + position + ", capacity=" + capacity + ", timeNode=" + timeNode + ", timeStamp=" + timeStamp + "]";
	}
	public static void main(String[] args) throws InterruptedException {
		// Date d = new Date();
		// d.setHours(0);
		// d.setMinutes(2);
		// d.setSeconds(20);
		// String a = DateViewUtils.formatDatePattern(d,"HH:mm:ss");
		// Integer time = Integer.parseInt(a.replace(":", ""));
		// System.out.println(a);
		// System.out.println(time);
		// System.out.println(time/30);
	}
}
