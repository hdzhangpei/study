package com.zhangpei.study.base.singleton;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int index = 0 ;
    public static void main(String[] args) {
        for (int i = 0 ;i<100000; i++) {
            index ++;
        }

        //验证此单例为非线程安全
        long startTime = System.currentTimeMillis();
        testSingletonLazyUnsafe();
        long useTime1 = System.currentTimeMillis() - startTime;

        //验证此单例为线程安全,效率低
        startTime = System.currentTimeMillis();
        testSingletonLazySafe();
        long useTime2 = System.currentTimeMillis() - startTime;

        //验证此单例为线程安全,效率高
        startTime = System.currentTimeMillis();
        testSingletonLazySafe();
        long useTime3 = System.currentTimeMillis() - startTime;

        System.out.println(useTime1 + "ms");
        System.out.println(useTime2 + "ms");
        System.out.println(useTime3 + "ms");

    }

    private static void testSingletonLazyUnsafe() {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(() -> {
                System.out.println(SingletonLazyUnsafe.getInstance());
            });
            list.add(t);
        }

        for (Thread t : list) {
            t.start();
        }
    }

    private static void testSingletonLazySafe() {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(() -> {
                System.out.println(SingletonLazySafe.getInstance());
            });
            list.add(t);
        }

        for (Thread t : list) {
            t.start();
        }
    }

    private static void testSingletonLazySafe2() {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(() -> {
                System.out.println(SingletonLazySafe2.getInstance());
            });
            list.add(t);
        }

        for (Thread t : list) {
            t.start();
        }
    }
}
