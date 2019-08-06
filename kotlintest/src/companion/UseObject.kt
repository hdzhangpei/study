package companion

/**
 * companion关键字用于代替java static关键字
 * 下列用法常用于类实例化工程方法
 *
 * class后使用private constructor用于私有化构造方法,并声明构造放方法
 */
class UseObject private constructor(val nickname : String){
    companion object {
        fun testStaticMethod(param: String) {
            printStr(param)
        }

        fun newUseObjectInstance(param: String): UseObject {
            return UseObject(param)
        }

        private fun printStr(param: String) {
            println(param)
        }
    }


    fun printStr(param: String) {
        println(param)
    }
}
