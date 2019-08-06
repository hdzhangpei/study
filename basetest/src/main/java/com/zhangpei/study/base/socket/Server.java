package com.zhangpei.study.base.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);

        while (true) {
            ss.accept();
            System.out.println("有人连上拉");
        }
    }

}
