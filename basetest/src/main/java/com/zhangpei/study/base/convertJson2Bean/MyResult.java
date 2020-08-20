package com.zhangpei.study.base.convertJson2Bean;

import lombok.Data;

@Data
public class MyResult<T> {
    private String code;
    private String msg;
    private T data;
}
