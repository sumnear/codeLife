package com.sumnear.dcsAnyc;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * dcc?? converter对象
 */
public class Convert {
	public int convertTIF(String source, String target, Map<String, String> map) {
		try {
			System.out.println(new Date() + " 进入DCC转TIF接口");
			Integer waitTime = 25; // ??要等待时间s
			Thread.sleep(5 * 1000);// 5秒在map中写入数??
			synchronized (map) {
				System.out.println(new Date() + "TIF 写入MAP");
				map.put("ok", "ok");
				System.out.println(new Date() + "TIF 唤醒MAP");
				map.notifyAll();
			}
			System.out.println(new Date() + "TIF 继续转换");
			Thread.sleep(waitTime * 1000);
			System.out.println(new Date() + "TIF 转换完成");
			return waitTime < 3 ? 1 : 0;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(new Date() + "TIF 转换异常");
			e.printStackTrace();
			return 2;
		}
	}

	public int convertJPG(String source, String target) {
		try {
			System.out.println(new Date() + " 进入DCC转JPG接口");
			Integer waitTime = new Random().nextInt(10);
			Thread.sleep(waitTime * 1000);
			return waitTime < 3 ? 1 : 0;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
	}
}
