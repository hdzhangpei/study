package com.zhangpei.study.base.multiThreadOrderInvolke;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 实现多线程顺序打印 {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        Thread t1 = new CustomThread(lock, c1, c2, "X");
        Thread t2 = new CustomThread(lock, c2, c3, "Y");
        Thread t3 = new CustomThread(lock, c3, c1, "Z");

        t1.start();
        Thread.sleep(20);
        t2.start();
        Thread.sleep(20);
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("end");
    }


}

class CustomThread extends Thread {
    private Condition cond;
    private Condition next;
    private Lock lock;
    private String printStr;

    CustomThread(Lock lock, Condition cond, Condition next, String printStr) {
        super();
        this.cond = cond;
        this.next = next;
        this.lock = lock;
        this.printStr = printStr;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (实现多线程顺序打印.num.incrementAndGet() <= 30) {
                    System.out.println(printStr);
                }

                next.signalAll();

                if(实现多线程顺序打印.num.get() > 30) {
                    return;
                } else {
                    cond.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }



    }
}