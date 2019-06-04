package com.zhangpei.study.base.multiThread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 验证守护线程中的finally在所有非守护线程执行完毕时|当系统exit()时,会强制所有守护进程.导致finally代码未执行
 */
public class DaemonUnInvokeFinally {
    public static void main(String[] args) {
        //验证守护线程中的finally在所有非守护线程执行完毕时,会强制所有守护进程.导致finally代码未执行
        testDaemonUnInvokeFinally();

        ////验证守护线程中的finally当系统exit()时,会强制所有守护进程.导致finally代码未执行
//        testSystemExitUNInvokeFinally();
    }

    private static void testSystemExitUNInvokeFinally() {
        Thread t2 = new Thread(() -> {
            try {
                synchronized(DaemonUnInvokeFinally.class) {
                    System.out.println("t2 enter try");
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t2 enter finally");
            }
        });

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private static void testDaemonUnInvokeFinally() {
        Thread t1 = new Thread(() -> {
            try {
                synchronized(DaemonUnInvokeFinally.class) {
                    System.out.println("t1 enter try");
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t1 enter finally");
            }
        });

        // 设置t1为守护线程
        t1.setDaemon(true);
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
