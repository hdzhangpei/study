package com.zhangpei.study.base.exam;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Double input = in.nextDouble();

            BigDecimal targetPrice = new BigDecimal(input);
            BigDecimal closedPrice = new BigDecimal(0);
            int M = 0;
            int N = 0;

            for(int machineNum = 1 ; machineNum <=10000 ; machineNum++) {

                Double ceilPrice = Math.ceil(targetPrice.multiply(new BigDecimal(machineNum)).doubleValue());

                BigDecimal tempClosedPrice = new BigDecimal(ceilPrice).divide(new BigDecimal(machineNum)).setScale(13).subtract(targetPrice);
                if(tempClosedPrice.compareTo(closedPrice) < 0) {
                    closedPrice = tempClosedPrice;
                    M = ceilPrice.intValue();
                    N = machineNum;
                }

                Double floorPrice = Math.floor(targetPrice.multiply(new BigDecimal(machineNum)).doubleValue());

                tempClosedPrice = new BigDecimal(floorPrice).divide(new BigDecimal(machineNum)).setScale(13).subtract(targetPrice);
                if(tempClosedPrice.compareTo(closedPrice) < 0) {
                    closedPrice = tempClosedPrice;
                    M = ceilPrice.intValue();
                    N = machineNum;
                }
            }

            System.out.println(M + " " + N);
        }
    }

}
