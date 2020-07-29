package com.zhangpei.study.base.mapStruts;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class User {
    private String username;
    private String password;
    private String string2integerTest;
    private LocalDateTime date;
}
