package com.zhangpei.study.base.bigDecimal;

import java.math.BigDecimal;

public class Main {

    //https://www.cnblogs.com/banxian/p/3781130.html Java中浮点型数据Float和Double进行精确计算的问题

    /**
     * double float类型的变量在参与计算时,会转成2进制,带有小数的10进制转2进制时,有时不能准确转换,
     * 所以会出现精度缺失问题
     * @param args
     */
    public static void main(String[] args) {
        double a = 1.2 - 0.4;
        System.out.println(a);

        double b = 0.8 * 0.05;
        System.out.println(b);


        Double c = 1.2;
        Double d = 0.4;
        BigDecimal bd = new BigDecimal(c.toString());
        BigDecimal bd1 = new BigDecimal(d.toString());
        System.out.println(bd.subtract(bd1));
    }
}
