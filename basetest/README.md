```
base包下:基础实验
```
##### 2019-06-03
* 新增单例模式不同实现:线程不安全,线程安全低效,线程安全高效(推荐),枚举单例(推荐)
com.zhangpei.study.base.singleton
* 验证守护线程中的finally在所有非守护线程执行完毕时|当系统exit()时,会强制所有守护进程.导致finally代码未执行
com.zhangpei.study.base.daemon
* 模拟死锁(查看死锁,解决死锁办法)
com.zhangpei.study.base.lock.DeadLock
* 自定义二分查找算法
com.zhangpei.study.base.binarySearch.BinarySearchAlgorithm
* 多个线程实现顺序打印:1,轮询 2,wait/notify 3，ReentrantLock condition方式实现动态代理
com.zhangpei.study.base.multiThreadOrderInvolke.MultiThreadOrderInvoke
com.zhangpei.study.base.multiThreadOrderInvolke.MultiThreadOrderInvoke2
com/zhangpei/study/base/multiThreadOrderInvolke/ReentrantLockOrder.java
* join方法使用,在有竞争锁的情况下,join会发生在并入线程执行结果之前释放锁,但是会等待线程执行结束.
com.zhangpei.study.base.join
* 实现动态生成代理类
com.zhangpei.study.base.reflect
* java中类似goto功能实现,配合for循环
com.zhangpei.study.base.useRetryFor
* 线程池使用
com.zhangpei.study.base.threadPool
* 执行效率问题:在海量数据中查找数据是否存在
com.zhangpei.study.base.findEffective
* 实现枚举类型多态
com.zhangpei.study.base.enumTest
* 实现简单的socket编程
com.zhangpei.study.base.socket