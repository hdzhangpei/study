package com.zhangpei.study.base.abstractDemo;

public class TestImpl extends AbstractTest {

    @Override
    public void test(String name) {
        super.name = name;

        System.out.println("TestImpl" + name);



    }
}
