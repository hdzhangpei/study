package com.zhangpei.study.base.algorithm;

public class IntTest {
    public static void main(String[] args) {
        char aa = 'a';
        char bb = 'b';

        aa ^= bb;
        bb ^= aa;
        aa ^= bb;

        System.out.println(aa);
        System.out.println(bb);

    }
}
