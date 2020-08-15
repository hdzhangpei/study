package com.zhangpei.study.base.algorithm;

import java.util.Scanner;

public class 质数因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            long ulDataInput = sc.nextLong();

            if(ulDataInput < 2) {
                continue;
            }
            System.out.println(getResult(ulDataInput));

        }


    }

    public static String getResult(long ulDataInput) {
        StringBuilder sb = new StringBuilder();
        int index = 2;

        while(index <= ulDataInput) {
            if(ulDataInput % index == 0) {
                if(index == ulDataInput) {
                    sb.append(index).append(" ");
                    break;
                } else {
                    sb.append(index).append(" ");
                    ulDataInput = ulDataInput/index;
                }
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
