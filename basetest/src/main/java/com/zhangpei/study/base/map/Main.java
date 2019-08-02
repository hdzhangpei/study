package com.zhangpei.study.base.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(list);
        Compare compare = new Compare();
        list.sort(compare);
        System.out.println(list);


        Map<String, String> map = new ConcurrentHashMap<>();
        List vector = new Vector();
        vector.add(1);
        map.put("","");

        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put(1,2);

    }

    static class Compare implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            return (int)o1 > (int)o2 ? 1 : -1;
        }
    }
}
