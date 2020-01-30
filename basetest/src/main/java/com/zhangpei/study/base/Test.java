package com.zhangpei.study.base;


import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("111");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.run();

        t1.join();

        System.out.println("222");
    }


}

