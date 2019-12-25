package com.zhangpei.study.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static ProxyFactory getInstance() {
        return new ProxyFactory();
    }

    public TestService get() {
        InvocationHandler handler = new MyInvocationHandler();

        Class<?>[] interfaces = {TestService.class};
        TestService proxy = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(), interfaces, handler);

        return proxy;
    }

    class MyInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("方法前执行代理!");
            Object result = method.invoke(TestService.class, args);
            System.out.println("方法后执行代理!");

            return result;
        }
    }
}


