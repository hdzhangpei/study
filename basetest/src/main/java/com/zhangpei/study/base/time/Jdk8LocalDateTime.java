package com.zhangpei.study.base.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jdk8LocalDateTime {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        System.out.println(LocalDate.now().format(dateFormatter));
        System.out.println(LocalTime.now().format(timeFormatter));


    }

}
