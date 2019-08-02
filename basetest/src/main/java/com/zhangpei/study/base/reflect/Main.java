package com.zhangpei.study.base.reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        TestService testService = new TestServiceImpl();

        TestService proxyService = (TestService) ProxyUtil.newProxyInstance(testService);
        proxyService.run("gogogogogogo");
        System.out.println(proxyService.back("回来~~~~"));
    }
}
