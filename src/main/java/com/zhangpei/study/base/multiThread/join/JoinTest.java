package com.zhangpei.study.base.multiThread.join;

import java.util.concurrent.TimeUnit;

import static com.zhangpei.study.base.multiThread.join.Util.getSencond;

/**
 * a b 在竞争b对象锁,b.join时会释放b的锁,b.start在争锁.   join先执行时当前线程获取b锁,b线程等待.  b获取b锁,main线程等待.
 * join(时间)会释放锁,但会等待线程执行完成.
 *
 */
public class JoinTest {

    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);

            a.start();
            b.start();

            b.join(2000);

            System.out.println("main end " + getSencond());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try{
            synchronized (b) {
                System.out.println("begin a " + getSencond());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("end a " + getSencond());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    synchronized public void run() {
        try {
            System.out.println("begin b " + getSencond());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("end b " + getSencond());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Util {
    public static String getSencond() {
        return String.valueOf(System.currentTimeMillis()).substring(8, 10);
    }
}
