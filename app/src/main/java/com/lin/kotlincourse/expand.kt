package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 扩展
 * kotlin可以对一个类进行扩展属性和方法，且不用继承或者装饰模式
 * 扩展是一个静态行为，不会对被扩展的类有任何影响
 */
class expand : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extend)
        var user = User("lin")
        user.log()
        user.text()
        LogUtil.e("${user.age}")
        printA(Q())//实际上输出的是W.a()方法

        val d = D()
        d.caller(user)

    }

}

/**
 * 扩展函数
 * 可以在已有类中添加新的方法
 */
class User(var name: String) {
    fun text() {
        LogUtil.e("成员函数")
    }
}

fun User.log() {
    LogUtil.e("扩展了User类，添加了一个log()方法")
}

/**
 * 扩展函数是静态解析的，具体被调用的是哪个函数，由调用函数的对象表达式决定的，而不是由动态地类型决定的
 * 若扩展函数与成员函数一致，则优先使用成员函数
 */
fun User.text() {
    LogUtil.e("扩展函数")
}

open class W

class Q : W()

fun W.a() = "W.a"
fun Q.a() = "Q.a"
fun printA(w: W) {
    LogUtil.e(w.a())
}

/**
 * 扩展属性
 * 属性不能定义在函数中，只能有val修饰
 * 初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
 */
val User.age: Int
    get() = 2
//val User.age = 1 // 错误：扩展属性不能有初始化器
/**
 * 伴生对象的扩展
 * 伴生对象被称为companion
 */

class Myclass {
    companion object {}
}

fun Myclass.Companion.text() {
    LogUtil.e("伴生对象的扩展函数")
}

val Myclass.Companion.a: Int
    get() = 1

/**
 * 扩展声明为成员
 * 在一个类（分发接受者）内部可以为另一个类（扩展接受者）声明扩展
 *
 */

class D{
    fun text() {
        LogUtil.e("D.text()")
    }
    fun a() {
        LogUtil.e("D.a()")
    }
    fun User.foo(){
        a()
        text()//调用User.text()
        this@D.text()//D.text()
    }
    fun caller(user: User){
        user.foo()//调用扩展函数
    }
}








