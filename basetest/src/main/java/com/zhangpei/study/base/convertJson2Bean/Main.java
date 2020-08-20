package com.zhangpei.study.base.convertJson2Bean;

import com.alibaba.fastjson.JSON;

public class Main {

    public static void main(String[] args) {

        String jsonStr = "{\"data\": {\"name\":\"qwe\", \"pwd\":\"123\"},\"code\": \"111\"}";


        MyResult<MyBean> bean = JSON.parseObject(jsonStr, new MyResult<MyBean>(){}.getClass());

        System.out.println(bean.getData().getName());


    }
}
