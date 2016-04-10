package com.liebe.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sjtu on 16-4-1.
 */
public class simpleTest {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("1", "1st");
        map.put("2", "2nd");
        map.put("3", "3rd");
        System.out.println("1 old value "+map.put("1","1st2"));

//        System.out.println(map);

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println((String) entry.getKey() + (String) entry.getValue());
        }
        String test = "test";
//        System.out.println(test.hashCode());
        System.out.println(map.get("1"));
        System.out.println("map contains 1st is "+map.containsValue("1st"));


        HashSet<String> set = new HashSet<>();
        set.add("test1");
        set.add("test1");
        set.add("test2");
        System.out.println("set size " +set.size());
        System.out.println("set contain test1 "+set.contains("test1"));
        System.out.println(set);
        Object[] array = set.toArray();
        for(Object ele:array)
        System.out.println(ele);

    }
}
