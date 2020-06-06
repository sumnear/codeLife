package test.testHeap;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import com.sun.management.OperatingSystemMXBean;

public class TestMap {
   public static void main(String[] args) {
	   OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory  
	            .getOperatingSystemMXBean();  
	   System.out.println("系统物理内存总计：" +osmb.getTotalPhysicalMemorySize()/ 1024 / 1024 + "MB<br>");
	   System.out.println(("系统物理可用内存总计："+osmb.getFreePhysicalMemorySize()/ 1024 / 1024 + "MB<br>"));
	  System.gc();
	  long start =Runtime.getRuntime().freeMemory();
	  System.out.println("map之前的内存"+start);
	  Map<String,String> map = new HashMap();
	  String a = "abcdefghijklmnopqrstuvwxyz";
	  for (int i = 0; i < 50000; i++) {
		String k = a+i;
		String v = i+a;
		map.put(k, v);
	}
	  long end =Runtime.getRuntime().freeMemory();
	  System.out.println("map之后的内存"+end);
	  System.out.println(("系统物理可用内存总计："+osmb.getFreePhysicalMemorySize()/ 1024 / 1024 + "MB<br>"));
	  System.out.println("差"+(start-end));
	  map.put("dd", "ee");
}
}
