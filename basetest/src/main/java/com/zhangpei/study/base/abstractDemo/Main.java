package com.zhangpei.study.base.abstractDemo;

public class Main {
    public static void main(String[] args) {
        AbstractTest a = new TestImpl();

        a.run("zhangpie");

        // 实例化抽象类引用是否变化
        AbstractTest a1 = new TestImpl();
        AbstractTest a2 = new TestImpl();
        a1.run("zhangpei1");
        a2.run("zhangpei2");

        System.out.println(a1);
        System.out.println(a2);
    }
}
