package com.sumnear.myMap;

import java.util.HashMap;

/**
 * @authore sumnear
 * @create 2019-4-30 14:08
 */
public class ExceptionTest
{
    public static void main(String[] args)
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("3", "3");
        map.put("2", "2");
        map.put("2", "2");
        //循环的结果和  put的顺序无关；
        for (String t : map.keySet()){
            System.out.println(map.get(t));
            if(t=="2"){
                //运行到这的时候，transient int modCount;  被改变了
                map.remove(t);
            }
        }
    }
}
