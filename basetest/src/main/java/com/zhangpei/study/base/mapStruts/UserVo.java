package com.zhangpei.study.base.mapStruts;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class UserVo {
    private String username;
    private String password;
    private Integer integerTest;
    private LocalDateTime date;
}
