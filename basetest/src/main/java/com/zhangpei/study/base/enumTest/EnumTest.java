package com.zhangpei.study.base.enumTest;

/**
 * 实现枚举类型多态
 */
public enum EnumTest {

    one(true, "测试说明") {
        @Override
        public void run(Integer index) {
            System.out.println(this.getClass());
            if (this.isSuccess()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "-" + index);
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "-" + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void Test() {
        System.out.println("测试枚举方法");
    }

    private boolean success;

    private String desc;

    private EnumTest() {
    }

    EnumTest(Boolean success, String desc) {
        this.success = success;
        this.desc = desc;
    }

    public Boolean isSuccess() {
        return this.success;
    }

    public String getDesc() {
        return this.desc;
    }


    public abstract void run(Integer index);


}
