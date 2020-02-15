package com.zhangpei.study.base.algorithm;

import com.alibaba.fastjson.JSON;

public class 冒泡排序 {
    public static void main(String[] args) {
        Integer[] ints = {1,5,2,0,3,8,2,6,5};

        for (int i = 0 ; i < ints.length ; i++) {
            for (int j = ints.length - 1; j > i;j--) {
                if (ints[j] < ints[i]) {
                    int g = ints[i];
                    ints[i] = ints[j];
                    ints[j] = g;
                }
            }
        }

        System.out.println(JSON.toJSONString(ints));
    }
}
