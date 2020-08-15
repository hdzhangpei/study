package com.zhangpei.study.base.algorithm;

import java.util.Scanner;

public class 打印一句话中最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;

        if(null == str || str.length() == 0) {
            System.out.println(count);
            return;
        }

        for(int i = str.length() - 1 ; i >= 0 ; i--) {
            if(' ' == str.charAt(i)) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
