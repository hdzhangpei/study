package com.zhangpei.study.base.singleton;

/**
 * 非线程安全的懒汉单例模式
 */
public class SingletonLazyUnsafe {
    private static SingletonLazyUnsafe instance;

    private SingletonLazyUnsafe() {
    }

    public static SingletonLazyUnsafe getInstance() {
        if (null == instance) {
            instance = new SingletonLazyUnsafe();
        }
        return instance;
    }
}
