package com.zhangpei.study.base.transmThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThradLocalTest {
    public static final TransmittableThreadLocal threadLocal = new TransmittableThreadLocal();

    public void test() {
        threadLocal.set("test threadLocal");

        new Thread(() -> {
            System.out.println(threadLocal.get());
        }).start();


    }

    public static void main(String[] args) {
        ThradLocalTest test = new ThradLocalTest();

        test.test();
    }
}
