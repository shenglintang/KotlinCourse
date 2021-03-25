package com.lin.kotlincourse

/**
 * Created by lin on 2018/2/2.
 * 单例模式
 */
/**
 * 超简版单例
 * 使用object来实现
 */
//object SingletonDemo {
//
//    fun text() {}
//}

/**
 * 饿汉式单例模式
 */
//object SingletonDemo1

//懒汉式
/*class SingletonDemo2 private constructor() {
    companion object {
        private var instance: SingletonDemo2? = null
            get() {
                if (field == null) {
                    field = SingletonDemo2()
                }
                return field
            }

        //这里不用getInstance作为为方法名，是因为在伴生对象声明时，
        // 内部已有getInstance方法，所以只能取其他名字
        fun getSingletonDemo2(): SingletonDemo2 {
            return instance!!
        }
    }
}*/

//双重校验锁式单例
class SingletonDemo() {
    companion object {
        val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDemo()
        }
    }
}






















