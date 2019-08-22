package com.zhangpei.study.base.abstractDemo;

public abstract class AbstractTest implements InterfaceTest{

    public String name;
    public void run(String name) {
        test(name);
    }

    @Override
    public void test(String name) {
        System.out.println("AbstractTest");
    }
}
