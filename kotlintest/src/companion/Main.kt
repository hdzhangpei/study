package companion

fun main() {
    UseObject.testStaticMethod("测试静态方法")

    val ob = UseObject.newUseObjectInstance("名字")
    ob.printStr("测试实例方法")

}