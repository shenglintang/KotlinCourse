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
 * 懒汉式单例
 * 显式声明构造方法为private
 * companion object用来在class内部声明一个对象
 * LazySingleton的实例instance 通过lazy来实现懒汉式加载
 * lazy默认情况下是线程安全的，这就可以避免多个线程同时访问生成多个实例的问题
 */
class lazySingleton private constructor() {
    companion object {
        val instances by lazy {
            lazySingleton()
        }
    }
    fun text(){
        LogUtil.e("text()")
    }
}


















