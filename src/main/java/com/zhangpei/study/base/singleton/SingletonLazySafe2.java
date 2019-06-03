package com.zhangpei.study.base.singleton;

/**
 * 线程安全懒汉单例模式,除了初始化可能会出现竞争锁,每次调用不会上锁,推荐
 */
public class SingletonLazySafe2 {
    private static SingletonLazySafe2 instance;

    private SingletonLazySafe2() {
    }

    public static SingletonLazySafe2 getInstance() {

        if (null == instance) {
            synchronized (SingletonLazySafe2.class) {
                if (null == instance) {
                    instance = new SingletonLazySafe2();
                }
            }
        }
        return instance;
    }
}
