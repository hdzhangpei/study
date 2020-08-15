package com.zhangpei.study.base.exam;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            try {
                int num = in.nextInt();

                if(0 == num) {
                    System.out.println("end");
                    return;
                }

                if(num > 1000000) {
                    continue;
                }

                System.out.println(compute(1, num -1, 0));

            } catch (Exception e) {
                continue;
            }
        }


    }

    private static int compute(int startNum , int endNum, int count) {

        if(startNum > endNum) {
            return count;
        }

        if (isZhishu(startNum) && isZhishu(endNum)) {
            return compute(++startNum, --endNum, ++count);
        } else {
            return compute(++startNum, --endNum, count);
        }
    }

    private static boolean isZhishu(int num) {

        for(int i = 2 ; i < num ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
