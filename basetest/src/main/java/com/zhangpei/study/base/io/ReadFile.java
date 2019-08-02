package com.zhangpei.study.base.io;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("/Users/pei.zhang/test");
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"GBK");
            System.out.println(str);
        }
    }
}
