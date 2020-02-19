package com.zhangpei.study.base.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这里为了实现简单,还是使用了ArrayBlockingQueue的pop方法.
 */
public class 手写阻塞队列 {
    public static void main(String[] args) {
        SimpleBlockingQueue sbq = new SimpleBlockingQueue();
        Thread t1 = new Thread(() -> {
            try {
                sbq.add(1);
                Thread.sleep(1000);
                sbq.add(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                while (true){
                    Integer item = sbq.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

    }
}

/**
 * 自定义queue
 */
class SimpleBlockingQueue {

    //队列容器
    private ArrayBlockingQueue container = new ArrayBlockingQueue(10);
    //用于记录容器中元素的个数
    private int count;
    //申明锁
    private Lock lock = new ReentrantLock();
    //标识，可以表示具体的线程
    private final Condition conditionNull = lock.newCondition();
    private final Condition conditionFull = lock.newCondition();

    /**
     * 将数据加入到队列中
     * @param item
     * @throws InterruptedException
     */
    public void add(Integer item) throws InterruptedException {
        if(item == null){
            throw new NullPointerException();
        }
        //申明可中断锁，简单起见也可以直接使用lock.lock(),lock.tryLock()
        lock.lockInterruptibly();
        try{
            System.out.println("添加元素:"+item);
            ++count;
            container.add(item);
            System.out.println("唤醒阻塞线程...");
            conditionNull.signal();
            Thread.sleep(2000);
        }finally {
            System.out.println("添加方法释放锁...");
            lock.unlock();
        }
    }

    /**
     * 从队列中后去数据
     * @return
     * @throws InterruptedException
     */
    public Integer take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            try {
                while (count == 0){
                    System.out.println("队列元素为空，进入阻塞...");
                    conditionNull.await();
                }
            } catch (InterruptedException ie) {
                System.out.println("出现异常，唤醒阻塞线程conditionNull");
                conditionNull.signal();
                throw ie;
            }

            --count;
            Integer x = (Integer) container.poll();
            System.out.println("取出方法取出元素:"+x);
            conditionFull.signal();
            return x;

        } finally {
            System.out.println("取出方法释放锁...");
            lock.unlock();
        }
    }
}
