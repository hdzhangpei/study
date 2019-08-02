package com.zhangpei.study.base.lock;

import java.util.concurrent.TimeUnit;

/**
 * 模拟死锁,对象锁
 *
 * 排查:
 * 查看当前是否有死锁,可以通过
 * 1:jconsole工具,提供可视化java管理工具,选择可能发生死锁的当前进程类,界面点击线程,最下方检查死锁.
 * 2:jstack工具,提供系统指令查看dump文件方式,jps查看当前java进程,记录可能发生死锁类pid. 通过制定jstack -l pid,查看当前进程类dump文件.
 *
 * 解决:
 * 确定死锁后,制定界面通过kill -9 pid. 杀死死锁进程.
 *
 * 产生死锁的四个比要条件:
 * 互斥条件：指进程对所分配到的资源进行排它性使用，即在一段时间内某资源只由一个进程占用，如果此时有其它进程请求资源，则必须等到该进程完成任务并释放资源。
 * 请求和保持条件：指进程已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它进程占有，此时请求进程阻塞，但又对自己已获得的其它资源保持不放。
 * 不可剥夺条件：指进程已获得的资源，在未使用完之前，不能被剥夺，只能在完成任务后由自己释放。
 * 环路等待条件：指在发生死锁时，必然存在一个进程-资源的环形链，即进程集合{P0，P1，P2，…，Pn}中的P0正在等待一个P1占用的资源；P1正在等待P2占用的资源，……，Pn正在等待已被P0占用的资源。
 */
public class DeadLock {
    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();

        Thread t1 = new Thread(() -> {
            synchronized(a) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    b.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized(b) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    a.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("not dead lock");
    }
}


class TestA {
    public synchronized void print() {
        System.out.println("testA");
    }
}

class TestB {
    public synchronized void print() {
        System.out.println("testB");
    }
}
