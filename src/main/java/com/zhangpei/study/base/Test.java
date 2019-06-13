package com.zhangpei.study.base;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 start");
                try {
                    lock.wait(2000);
                    System.out.println("t1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(5);

//                    lock.notify();
//                    System.out.println("lock notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}

