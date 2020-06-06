package test.testHeap;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import com.sun.management.OperatingSystemMXBean;

public class TestMap {
   public static void main(String[] args) {
	   OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory  
	            .getOperatingSystemMXBean();  
	   System.out.println("ϵͳ�����ڴ��ܼƣ�" +osmb.getTotalPhysicalMemorySize()/ 1024 / 1024 + "MB<br>");
	   System.out.println(("ϵͳ��������ڴ��ܼƣ�"+osmb.getFreePhysicalMemorySize()/ 1024 / 1024 + "MB<br>"));
	  System.gc();
	  long start =Runtime.getRuntime().freeMemory();
	  System.out.println("map֮ǰ���ڴ�"+start);
	  Map<String,String> map = new HashMap();
	  String a = "abcdefghijklmnopqrstuvwxyz";
	  for (int i = 0; i < 50000; i++) {
		String k = a+i;
		String v = i+a;
		map.put(k, v);
	}
	  long end =Runtime.getRuntime().freeMemory();
	  System.out.println("map֮����ڴ�"+end);
	  System.out.println(("ϵͳ��������ڴ��ܼƣ�"+osmb.getFreePhysicalMemorySize()/ 1024 / 1024 + "MB<br>"));
	  System.out.println("��"+(start-end));
	  map.put("dd", "ee");
}
}
