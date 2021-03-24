package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 委托
 * Kotlin 通过关键字 by 实现委托。
 */
class Entrust : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrust)
//        text8()
        EntrustText5()
    }
}

/**
 * 类的委托
 * 一个类中定义的方法实际是调用另一个类的对象的方法来实现的
 *
 */

interface Base {
    fun print()
}

//实现接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() {
        LogUtil.e(x.toString())
    }
}

//通过关键字by建立委托类
//by子句表示，将base保存在Derived的实例中，编译器回生成
//继承自Base接口的所有方法，供Derived的实例调用
class Derived(base: Base) : Base by base

fun text8() {
    val base = BaseImpl(1)
    Derived(base).print()
}

/**
 * 属性委托
 * 指的是一个类的某个属性值不是在类中直接进行定义。而是将其托付给一个代理类，
 * 从而实现对该类的属性统一管理
 * val/var <属性名>: <类型> by <表达式>
 * 定义一个被委托的类，该类需要包含getValue()方法和setValue()方法，
 * 且参数thisRef为进行委托的类的对象，prop为进行委托的类的属性的对象
 */

/**
 *定义包含属性委托的类
 */
class Example {
    var p: String by Delegate()
}

/**
 * 委托的类
 */
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        LogUtil.e("$thisRef 的 ${property.name} 属性赋值为 $value")
    }

}

fun EntrustText1() {
    val example = Example()
    LogUtil.e(example.p)//访问该属性 调用getValue
    example.p = "qqq"//修改该属性 setValue
    LogUtil.e(example.p)

}

/**
 * 标准委托
 *延迟属性Lazy
 * lazy()是一个函数，接收一个lambda表达式作为参数，返回一个Lazy<T>实例的函数，
 * 返回的实例可以作为实现延迟属性的委托
 * 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
 */
val lazyValue: String by lazy {
    LogUtil.e("computed!")//第一次调用会打印，第二次就不会打印
    "hello"
}

fun EntrustText2() {
    LogUtil.e(lazyValue)//第一次调用
    LogUtil.e(lazyValue)//第二次调用，只输出返回值
}

/**
 * 可观察性属性observable
 *Delegates.observable函数接收两个参数
 * 第一个是初始值，第二个是属性值变化事件的响应器（handler）
 * 它有三个参数，被赋值的属性、旧值、新值
 */
class EntrustUser {
    var name: String by Delegates.observable("初始值") { prop, old, new ->
        LogUtil.e("旧值：$old -> 新值：$new")
    }
}

fun EntrustText3() {
    val entrustUser = EntrustUser()
    entrustUser.name = "第一次赋值"
    entrustUser.name = "第二次赋值"
}

/**
 * 把属性存储在映射中
 *
 */
class EntrustSite(val map: Map<String, Any>) {
    val name by map
    val url by map
}

fun EntrustText4() {
    //构造函数接受一个映射参数1
//    val entrustSite = EntrustSite(mapOf(
//            "name" to "aaa",
//            "url" to "bbb"
//    ))
//    LogUtil.e("entrustSite.name ：${entrustSite.name}")
//    LogUtil.e("entrustSite.url ：${entrustSite.url}")

    //如果使用var属性，则把map换成 mutableMap
    var map = mutableMapOf(
            "name" to "aaa",
            "url" to "bbb"
    )
    var entrustSite = EntrustSite(map)
    LogUtil.e("entrustSite.name ：${entrustSite.name}")
    LogUtil.e("entrustSite.url ：${entrustSite.url}")
    LogUtil.e("---------------------------")

    map.put("name", "ccc")
    map.put("url", "ddd")
    LogUtil.e("entrustSite.name ：${entrustSite.name}")
    LogUtil.e("entrustSite.url ：${entrustSite.url}")
}

/**
 * NOT NULL
 * 适用于在初始化阶段就确定属性值的场合
 */

class EntrustFoo {
    var notNullBar: String by Delegates.notNull<String>()
}


fun EntrustText5() {
    // 需要注意，如果属性在赋值前就被访问的话则会抛出异常。
    // Property notNullBar should be initialized before get.
    val entrustFoo = EntrustFoo()
    entrustFoo.notNullBar = "ss"
    LogUtil.e(entrustFoo.notNullBar)
}


























































