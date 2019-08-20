package com.zhangpei.study.base.abstractDemo;

public abstract class AbstractTest implements InterfaceTest{

    public void run() {
        test();
    }

    @Override
    public void test() {
        System.out.println("AbstractTest");
    }
}
