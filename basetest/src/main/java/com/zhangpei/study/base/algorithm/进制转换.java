package com.zhangpei.study.base.algorithm;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().substring(2);

        int count = 0;

        char[] chars = str.toCharArray();
        int length = str.length();
        int temp = 0;
        char ca;

        long num = 0;

        while(count < length) {
            ca = chars[length - count - 1];

            if('0' <= ca && ca <= '9') {
                temp = ca - '0';
            } else if('A' <= ca && ca <= 'Z') {
                temp = ca - 'A' + 10;
            } else if('a' <= ca && ca <= 'z') {
                temp = ca - 'a' + 10;
            } else {
                break;
            }
            num += temp * Math.pow(16, count);

            count++;
        }

        System.out.println(num);

    }
}
