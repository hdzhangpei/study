package com.zhangpei.study.base.enumTest;

public class Main {

    public static void main(String[] args) {
//        EnumTest.one.run("哈哈");
//        System.out.println(EnumTest.one.getDesc());
//        System.out.println(EnumTest.one.isSuccess());
//        EnumTest.one.Test();


        new Thread(() -> {
            for (; ; ) {
                EnumTest.one.run(0);
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                EnumTest.one.run(1);
            }
        }).start();


    }
}
