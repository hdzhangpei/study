package com.zhangpei.study.base.multiThread.multiThreadOrderInvolke;

import java.util.concurrent.TimeUnit;

/**
 * 使用wait notify实现三个线程顺序打印.
 *
 *
 *
 * 与轮询方式相比(MultiThreadOrderInvoke)
 * 当数据量越低,轮询比wait/notify效率高
 * 当数据量越大时,每次处理的数据量越小,轮询效率比wait/notify效率高
 * 当数据量越大时,每次处理的数据量越大,轮询效率比wait/notify效率低
 *

 * wait/notify  数据量      单次执行数据量     执行时间
 *              10000       10              0.102s/0.101s/0.106s
 *              10000       100             0.078s/0.080s/0.106s
 *              1000000     10              4.714s/4.890s/4.846s
 *              1000000     100             3.776s/3.332s/3.425s
 *              1000000     1000            3.348s/3.114s/3.030s
 *              10000000    10              40.812s/40.776s/40.835s
 *              10000000    100             26.536s/26.142s/26.555s
 *              10000000    1000            25.768s/25.706s/26.019s
 *              10000000    10000           24.854s/25.258s/25.003s
 * 结论:
 * wait/notify在单次执行量越小,效率越低;在总数据量很大时,增大单次处理数据的数量可以很大提高效率.
 *
 *
 */
public class MultiThreadOrderInvoke2 {

    public static int num = 0;
    public static final int total = 10000000;
    public static final int batchNum = 10000;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        MyLock lock1 = new MyLock();
        MyLock lock2 = new MyLock();
        MyLock lock3 = new MyLock();

        MyThread t1 = new MyThread(lock1, lock2, "thread1");
        MyThread t2 = new MyThread(lock2, lock3, "thread2");
        MyThread t3 = new MyThread(lock3, lock1, "thread3");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t3.start();
        TimeUnit.MILLISECONDS.sleep(10);

        t1.join();
        t2.join();
        t3.join();

        System.out.println("total invoke time:" + (System.currentTimeMillis() - startTime)/1000.0 + "s");
    }
}


class MyThread extends Thread {
    private MyLock lock;
    private MyLock next;


    private MyThread() {
    }

    public MyThread(MyLock lock, MyLock next, String threadName) {
        this.lock = lock;
        this.next = next;
        super.setName(threadName);
    }

    @Override
    public void run() {

        while (MultiThreadOrderInvoke2.num < MultiThreadOrderInvoke2.total) {
            synchronized (lock) {
                synchronized (next) {

                    for (int i = 0; i < MultiThreadOrderInvoke2.batchNum; i++) {
                        System.out.println(Thread.currentThread().getName() + ":" + ++MultiThreadOrderInvoke2.num);
                    }
                    next.notify();

                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            synchronized (next){
                next.notify();
            }
        }

    }
}

class MyLock {

}
