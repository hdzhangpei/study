package com.zhangpei.study.base.multiThread.threadMX;

import com.google.gson.Gson;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        for(ThreadInfo threadInfo : threadInfos) {
            Gson gson = new Gson();
            System.out.println("[" + threadInfo.getThreadId() + "]" + gson.toJson(threadInfo));
        }
    }
}
