package com.zhangpei.study.base.multiThreadOrderInvolke;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOrder {
    public static final Integer total = 10000000;
    public static Integer num = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();


        Thread t1 = new MyReentrantLock(lock, c1, c2);
        Thread t2 = new MyReentrantLock(lock, c2, c3);
        Thread t3 = new MyReentrantLock(lock, c3, c1);

        t1.start();
        t2.start();
        t3.start();
    }


}

class MyReentrantLock extends Thread {
    private Condition cond;
    private Condition next;
    private Lock lock;

    public MyReentrantLock(Lock lock, Condition cond, Condition next) {
        this.cond = cond;
        this.next = next;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (ReentrantLockOrder.num < ReentrantLockOrder.total) {
            lock.lock();
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(++ReentrantLockOrder.num);
                }
                cond.await();
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
