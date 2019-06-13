package com.zhangpei.study.base.multiThreadOrderInvolke;

/**
 * 有10000000个数字,分别开启三个线程,按顺序分别打印三个数,直到1000000;例线程1:1 2 3...10,线程2: 11 12 ....20,线程3: 21 22......30
 * 低效实现,在量级大的情况下,锁竞争会非常激烈.而且循环匹配条件,消耗cpu资源
 *
 * 轮询          数据量      单次执行数据量     执行时间
 *              10000       10              0.069s/0.065s/0.073s
 *              10000       100             0.069s/0.097s/0.078s
 *              1000000     10              3.514s/3.850s/3.551s
 *              1000000     100             3.721s/3.770s/3.701s
 *              1000000     1000            3.934s/3.921s/3.459s
 *              10000000    10              40.345s/37.755s/36.357s
 *              10000000    100             37.713s/34.177s/37.276s
 *              10000000    1000            33.436s/33.704s/34.629s
 *              10000000    10000           35.397s/37.487s/35.680s
 */
public class MultiThreadOrderInvoke {
    public static final int total = 10000000;
    public static int num = 0;
    public static final int batchNum = 10000;

    static class LockObject {
        private volatile String lockName;

        public LockObject(String name) {
            this.lockName = name;
        }

        public String getLockName() {
            return this.lockName;
        }

        public void setLockName(String name) {
            this.lockName = name;
        }
    }

    static class MyThread implements Runnable {
        private String name;
        private String next;
        private LockObject lock;

        public MyThread(String name, String next, LockObject lock) {
            this.name = name;
            this.next = next;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (MultiThreadOrderInvoke.num < MultiThreadOrderInvoke.total) {
                if (lock.lockName.equals(name)) {
                    synchronized (lock) {
                        for (int i = 0 ; i < MultiThreadOrderInvoke.batchNum ; i++) {
                            System.out.println("ThreadName-"+ Thread.currentThread().getName() + " " + ++MultiThreadOrderInvoke.num);
                        }
                        lock.setLockName(next);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        LockObject lock = new LockObject("A");


        Thread t1 = new Thread(new MyThread("A", "B", lock));
        Thread t2 = new Thread(new MyThread("B", "C", lock));
        Thread t3 = new Thread(new MyThread("C", "A", lock));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("total invoke time:" + (System.currentTimeMillis() - startTime)/1000.0 + "s");
    }
}
