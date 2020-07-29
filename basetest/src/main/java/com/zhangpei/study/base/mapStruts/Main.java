package com.zhangpei.study.base.mapStruts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zhangpei");
        user.setPassword("passo11111");
        user.setString2integerTest("22222");
        user.setDate(LocalDateTime.now());

        UserVo userVo = UserMapper.INSTANCE.trans2UserVo(user);
        System.out.println(userVo);
        System.out.println(userVo.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
