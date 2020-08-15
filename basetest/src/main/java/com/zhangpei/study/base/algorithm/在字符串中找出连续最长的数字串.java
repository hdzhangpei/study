package com.zhangpei.study.base.algorithm;

import java.util.Scanner;

//输入一个字符串。
//输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
//输入:abcd12345ed125ss123058789
//输出:123058789,9
public class 在字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.next();

            if (str.length() == 0) {
                System.out.println("");
                continue;
            }
            char[] chars = str.toCharArray();
            for (int i = 0 ; i < chars.length ; i++) {

                if ('0' > chars[i] || '9' < chars[i]){
                    chars[i] = 'a';
                }
            }

            String[] strs = String.valueOf(chars).split("a");

            String result = "";
            int maxInt = 0;

            for (int i = 0 ; i < strs.length ; i++) {
                if (maxInt < strs[i].length()) {
                    result = strs[i];
                    maxInt = strs[i].length();
                } else if(maxInt == strs[i].length()) {
                    result += strs[i];
                }
            }

            System.out.println(result + "," + maxInt);
        }

    }
}
