package com.zhangpei.study.base.useRetryFor;


/**
 * break retry 跳到retry处，且不再进入循环
 * continue retry 跳到retry处，且再次进入循环
 */
public class Retry {

    public static void main(String[] args) {

        int count = 0;
        retry:

        for (; ; ) {
            System.out.println("point");

            for (int i = 0 ; i < 90 ;i++ ) {
                // retry之后，从头计数
                System.out.println("====" + i);
                count++;
                System.out.println("count==" + count);
                if (count % 5 == 0) {
                    continue retry;
                }

                if (count == 99) {
                    break retry;
                }

            }
        }

        System.out.println("end");

    }


}
