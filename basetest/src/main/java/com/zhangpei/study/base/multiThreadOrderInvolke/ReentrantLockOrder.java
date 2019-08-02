package com.zhangpei.study.base.multiThreadOrderInvolke;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOrder {
    public static final Integer total = 100;
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();


        Thread t1 = new MyReentrantLock(lock, c1, c2, "t1");
        Thread t2 = new MyReentrantLock(lock, c2, c3, "t2");
        Thread t3 = new MyReentrantLock(lock, c3, c1, "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("end");
    }


}

class MyReentrantLock extends Thread {
    private Condition cond;
    private Condition next;
    private Lock lock;

    public MyReentrantLock(Lock lock, Condition cond, Condition next, String threadName) {
        super(threadName);
        this.cond = cond;
        this.next = next;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (ReentrantLockOrder.num.get() < ReentrantLockOrder.total) {

            try {
                lock.lock();

                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "==>" + ReentrantLockOrder.num.incrementAndGet());
                }


                next.signal();

                if (ReentrantLockOrder.num.incrementAndGet() < ReentrantLockOrder.total) {

                    cond.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


        if(ReentrantLockOrder.num.get() >= ReentrantLockOrder.total) {
            System.out.println(Thread.currentThread().getName() + "==>over");
            return;
        }
    }
}
//https://blog.csdn.net/Yahuvi/article/details/78742800