//package com.zhangpei.study.base.spring;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
///**
// * @Bean的使用
// * SpringBootBeanUtil的使用
// */
//@SpringBootApplication
//public class ManApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(ManApplication.class, args);
//
//        TestService t1 = (TestService) SpringBootBeanUtil.getBean("testService");
//        System.out.println(t1);
//
//
//        TestService t2 = (TestService) SpringBootBeanUtil.getBean("testService1");
//        System.out.println(t2);
//        t2.test();
//    }
//}
