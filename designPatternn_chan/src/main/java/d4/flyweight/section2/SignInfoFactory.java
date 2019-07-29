package d4.flyweight.section2;

import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class SignInfoFactory {
	// 池容器
	private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();

	static {
		// 初始化对象池
		for (int i = 0; i < 1114; i++) {
			String subject = "科目" + i;
			// 初始化地址
			for (int j = 0; j < 1130; j++) {
				String key = subject + "考试地点" + j;
				SignInfoFactory.getSignInfo(key);
			}
		}
	}

	// 报名信息的对象工厂
	@Deprecated
	public static SignInfo getSignInfo() {
		return new SignInfo();
	}

	// 从池中获得对象
	public static SignInfo getSignInfo(String key) {
		// 设置返回对象
		SignInfo result = null;
		// 池中没有该对象，则建立，并放入池中
		if (!pool.containsKey(key)) {
			// System.out.println(key + "----建立对象，并放置到池中");
			result = new SignInfo4Pool(key);
			pool.put(key, result);
		} else {
			result = pool.get(key);
			System.out.println(key + "---直接从直池中取得");
		}
		return result;
	}
}
