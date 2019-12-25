package com.zhangpei.study.base.proxy;

public class TestServiceImpl implements TestService{
    public String invoke(String name) {
        System.out.println("你的名字:" + name);

        return "zhangpei";
    }
}
