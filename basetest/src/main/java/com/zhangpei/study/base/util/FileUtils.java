package com.zhangpei.study.base.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static File openFile(String url) throws IOException {
        File file = new File(url);
        File parentFile = file.getParentFile();

        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }


    public static void main(String[] args) throws IOException {
        FileUtils.openFile("/Users/pei.zhang/Desktop/123123213.txt");
    }
}
