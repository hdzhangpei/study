package com.zhangpei.study.base.multiThread;

/**
 * 有1000000个数字,分别开启三个线程,按顺序分别打印三个数,直到1000000;例线程1:1 2 3...10,线程2: 11 12 ....20,线程3: 21 22......30
 * 低效实现,在量级大的情况下,锁竞争会非常激烈.而且循环匹配条件,消耗cpu资源
 */
public class MultiThreadOrderInvoke {
    public static final Integer total = 1000000;
    public static Integer num = 0;

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
                        for (int i = 0 ; i < 10 ; i++) {
                            System.out.println("ThreadName-"+ Thread.currentThread().getName() + " " + ++MultiThreadOrderInvoke.num);
                        }
                        lock.setLockName(next);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LockObject lock = new LockObject("A");

        long startTime = System.currentTimeMillis();

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
