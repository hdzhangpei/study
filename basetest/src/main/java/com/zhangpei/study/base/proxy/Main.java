package com.zhangpei.study.base.proxy;

public class Main {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = ProxyFactory.getInstance();
        TestService testService = proxyFactory.get();
        System.out.println(testService);
        testService.invoke("zhangying");


        TestService testService1 = new TestServiceImpl();
        System.out.println(testService1);
        testService1.invoke("zhangying");
    }
}
