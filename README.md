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
* 多个线程实现顺序打印:1,轮询 2,wait/notify
com.zhangpei.study.base.multiThreadOrderInvolke.MultiThreadOrderInvoke
com.zhangpei.study.base.multiThreadOrderInvolke.MultiThreadOrderInvoke2
* join方法使用,在有竞争锁的情况下,join会发生在并入线程执行结果之前释放锁,但是会等待线程执行结束.
com.zhangpei.study.base.join