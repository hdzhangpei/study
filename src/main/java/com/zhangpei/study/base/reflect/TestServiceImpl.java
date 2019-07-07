package com.zhangpei.study.base.reflect;

public class TestServiceImpl implements TestService {
    @Override
    public void run(String runName) {
        System.out.println(runName);
    }

    @Override
    public String back(String backName) {
        return backName;
    }
}
