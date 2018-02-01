package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 泛型
 */
class GenericParadigm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic_paradigm)

        var box = Box(2)
        LogUtil.e("box.value = ${box.value}")
        var box2 = Box(false)
        LogUtil.e("box2.value = ${box2.value}")
        var box3 = boxIn("aaa")
        LogUtil.e("box2.value = ${box3.value}")
        val outClazz = OutClazz(123)
        LogUtil.e("outClazz.text() = ${outClazz.text()}")
        InClazz("123").text("sss")

        main()

    }
}

/**
 * 声明泛型变量
 */
class Box<T>(t: T) {
    var value = t
}

/**
 * 声明泛型函数
 */
fun <T> boxIn(value: T) = Box(value)

/**
 * 型变
 * kotlin中没有通配符，它有声明处型变和类型投影
 *
 */

/**
 * 声明处型变使用注解修饰符 in，out
 * 使用out使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型，不可作为入参类型
 */
class OutClazz<out T>(val t: T) {
    //    fun text( t: T):T{//错误 只能当做返回类型 不能作为入参类型
//        return t
//    }
    fun text(): T {
        return t
    }

}

/**
 * 使用in使得一个类型参数逆变，只作为入参，不可作为返回类型
 */
class InClazz<in T>(t: T) {
    //    fun text(t: T):T{//错误 只能当做入参 不能作为返回类型
//        return t
//    }
    fun text(t: T) {
        LogUtil.e("t is $t")
    }

}

/**
 * 星投影
 * 对泛型类型定义一个类型投射，要求这个类型泛型的实体实例， * 都是这个投射的子类型
 *  假设类型定义为Foo<out T>，当对T未知时
 *  Foo<*> =Foo<out Any>
 *  Foo<*> =Foo<in Any>
 */

interface MyIfe<out C, in D> {
    fun MyFun(d: D) {
        LogUtil.e("d is $d")
    }
}

class MyClsEx<out A, in B>(val a: A, b: B) : MyIfe<Any, Any> {//用*编译不过 可以用Any  貌似星投影还未提供相应的API 等待下个版本吧
init {
    LogUtil.e("b is $b")
}

    fun foo(): A {
        return a
    }
}

fun main() {

    val myclass = MyClsEx<String, Int>("Any", 13)
    LogUtil.e("res.a is ${myclass.a}")
    myclass.MyFun("s")

}






















