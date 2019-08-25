package com.zhangpei.study.base.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TestService testService1() {
        TestService testService = new TestService();
        System.out.println(testService);
        return testService;
    }
}
