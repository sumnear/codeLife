package com.sumnear.myMap;

/**
 * @authore sumnear
 * @create 2019-4-30 13:37
 */
public class TestMap {
    public static void main(String[] args) {
        MyMap map = new MyHashMap();
        map.put("a1",1);
        map.put("a2",2);
        System.out.println("size:"+map.size());
        System.out.println("isEmpty:"+map.isEmpty());
        System.out.println(map.get("a1"));
    }
}
