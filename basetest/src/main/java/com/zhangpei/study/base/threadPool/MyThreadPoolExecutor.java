package com.zhangpei.study.base.threadPool;

import java.util.concurrent.*;

/**
 * 超出线程池最大线程, 并且queue容量满, 线程池会执行拒绝执行策略.  使用RejectedExecutionHandler作为回调, 拒绝执行的都会回调此实现
 */
public class MyThreadPoolExecutor {
    private static ExecutorService executor = new ThreadPoolExecutor(2, 3,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(2) , new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread()  + "被拒绝了");
        }
    });


    public static void main(String[] args) {
        for (int i = 0 ; i<100 ; i++) {


            executor.execute(() -> {
                System.out.println(Thread.currentThread() + "--" + "zhangpei");
            });
        }
    }
}
