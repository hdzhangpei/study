package com.zhangpei.study.base.algorithm;

import java.util.Scanner;

public class 计算字符个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char ch = sc.nextLine().toLowerCase().charAt(0);

        int count = 0;
        if(null == str || str.length() == 0) {
            System.out.println(count);
            return;
        }


        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == ch ) {
                count++;
            }
        }

        System.out.println(count);
    }

}
