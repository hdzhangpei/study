package com.zhangpei.study.base.singleton;

/**
 * 枚举类型的单例,推荐
 */
public enum SingletonEnum {
    INSTANCE;

    public void Run() {
        System.out.println("this is enum singleton");
    }

}
