/**
 * asdf
 */
package com.zhangpei.study.base.exam;
import java.awt.*;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Test extends Thread{
    public static void main(String[] args) throws InterruptedException {
        int i;
        int j;
        outer:
            for(i = 1 ; i < 3;i++)
                inner:
            for (j = 1 ; j < 3;j++){
                if (j == 2) {
                    continue outer;
                }
                System.out.println("Value for i = " + i + "Value for j=" + j);
            }
    }
     class Test11 {

    }
}


