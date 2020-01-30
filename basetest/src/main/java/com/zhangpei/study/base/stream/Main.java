package com.zhangpei.study.base.stream;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0 ; i < 10000; i++) {
            list.add(i + "");
        }

        list.parallelStream().forEach(str -> {
            double sleepTime = Math.random() * 2000;
            System.out.println(str + "----sleep_time:" + sleepTime);

            try {
                Thread.sleep((long) sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}
