package com.zhangpei.study.base.singleton;

/**
 * 线程安全的懒汉单例模式,每次调用锁方法,效率低
 */
public class SingletonLazySafe {
    private static SingletonLazySafe instance;

    private SingletonLazySafe() {
    }

    public static synchronized SingletonLazySafe getInstance() {

        if (null == instance) {
            instance = new SingletonLazySafe();
        }

        return instance;
    }
}
