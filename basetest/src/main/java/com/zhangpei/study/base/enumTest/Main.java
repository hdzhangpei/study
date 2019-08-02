package com.zhangpei.study.base.enumTest;

public class Main {

    public static void main(String[] args) {
        EnumTest.one.run("哈哈");
        System.out.println(EnumTest.one.getDesc());
        System.out.println(EnumTest.one.isSuccess());
        EnumTest.one.Test();
    }
}
