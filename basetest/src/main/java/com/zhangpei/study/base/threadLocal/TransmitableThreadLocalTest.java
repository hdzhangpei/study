package com.zhangpei.study.base.threadLocal;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmitableThreadLocalTest {

    public static TransmittableThreadLocal transmittableThreadLocal = new TransmittableThreadLocal();
//    public static InheritableThreadLocal transmittableThreadLocal = new InheritableThreadLocal();
    public static ThreadLocal threadLocal = new ThreadLocal();
    public static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        transmittableThreadLocal.set("zhangpei");

        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread() + ":::" + transmittableThreadLocal.get());
        }, TtlExecutors.getTtlExecutorService(executorService));

        completableFuture.get();

//        CompletableFuture completableFuture1 = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread() + ":::" + transmittableThreadLocal.get());
//        }, TtlExecutors.getTtlExecutorService(executorService));
//
//        completableFuture1.get();
//
//        CompletableFuture completableFuture2 = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread() + ":::" + transmittableThreadLocal.get());
//        }, TtlExecutors.getTtlExecutorService(executorService));
//
//        completableFuture2.get();
//
//
//
//        transmittableThreadLocal.set("阿斯蒂芬");
//        for (int i= 0 ; i< 3 ; i++) {
//            executorService.execute(TtlRunnable.get(() -> {
//                System.out.println(Thread.currentThread() + "===" + transmittableThreadLocal.get());
//            }));
//        }


        executorService.shutdown();
    }

}
