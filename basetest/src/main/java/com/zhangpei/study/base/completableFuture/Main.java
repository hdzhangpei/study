package com.zhangpei.study.base.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "5秒";
        });

        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "2秒";
        });

        String result = (String) CompletableFuture.anyOf(future1, future2).get();

        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) + "结果:" + result);
    }
}
