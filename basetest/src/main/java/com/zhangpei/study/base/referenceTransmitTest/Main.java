package com.zhangpei.study.base.referenceTransmitTest;

public class Main {
    public static void main(String[] args) {
        UserBean userBean = new UserBean();
        userBean.setName("zhangpei");

        changeUserReference(userBean);

        System.out.println(userBean.getName());
    }

    private static void changeUserReference(UserBean userBean) {
        userBean = new UserBean();
        userBean.setName("pei.zhang");
        System.out.println(userBean.getName());
    }

}
