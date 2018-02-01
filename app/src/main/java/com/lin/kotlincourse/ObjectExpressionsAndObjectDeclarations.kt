package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 对象表达式和声明
 * kotlin用对象表达式和对象声明来实现创建一个对某个类做了轻微改动的
 * 类的对象，且不需要声明新的子类
 */
class ObjectExpressionsAndObjectDeclarations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_expressions_and_object_declarations)
//        text4()
//        text5()
        textR()
        val instance = CompanionClazz.create()
    }
}

/**
 * 对象表达式
 * 对象可以继承与某个基类，或者实现其他接口
 */

open class V(x: Int) {
    open val y = x
}

interface N {}

fun text4() {
    val a = object : V(1), N {
        override val y = 9
    }
    LogUtil.e(a.y.toString())
}

/**
 * 对象表达式可以越过类的定义来创建一个类
 */
fun text5() {
    val site = object {
        var name = "aaa"
        val url = "bbb"
    }
    LogUtil.e(site.name)
    LogUtil.e(site.url)
}

/**
 * 需要注意的是匿名对象只作用于本地或者私有作用域中声明的类型
 * 如果作为公有函数的返回类型或者用作公有属性的类型，那么该函数或属性
 * 回事匿名对象的超类型，此时添加的成员无法访问
 */

class Y {
    //私有函数，返回类型为匿名对象类型
    private fun foo() = object {
        val a = 9
    }

    //公有函数。返回类型是Any
    fun publicFoo() = object {
        val b = 0
    }

    fun text() {
        val a = foo().a
//        val b = publicFoo().b//编译失败
    }
}

/**
 * 对象声明
 * 使用object关键字来声明一个对象
 * 对象可以有超类
 */

object Site {
    val name = "aaa"
    val url = "bbb"
    fun a() {
        LogUtil.e("对象中的函数")
    }
}

fun textR() {
    LogUtil.e(Site.name)
    LogUtil.e(Site.url)
    Site.a()
}

/**
 * 伴生对象
 * 类内部的对象声明可以用companion关键字标记，这样就可以与外部类关联在一起
 * 一个类里面只能声明一个伴生对象
 */
class CompanionClazz {
    companion object Factory {
        //可以省略对象名Factory
        fun create() = CompanionClazz()
    }
}
/**
 * 对象表达式与对象声明之间的差异：
 * 对象表达式实在使用它们的地方立即执行的
 * 对象声明实在第一次被访问到延迟初始化的
 * 伴生对象的初始化在相应的类被加载时初始化，与java的静态初始化器类似
 */







































