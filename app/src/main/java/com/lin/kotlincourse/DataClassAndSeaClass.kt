package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 数据类和密封类
 */
class DataClassAndSeaClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_class_and_sea_class)
//        text()
//        text2()

        LogUtil.e("eval(Const) is  ${eval(Const(11.0))}")
        LogUtil.e("eval(NotNumber) is  ${eval(NotNumber)}")
        LogUtil.e("eval(Sum) is  ${eval(Sum(Const(1.0),Const(1.0)))}")
    }
}

/**
 * kotlin可以创建一个只包含数据的类 关键字为data
 * 数据类需要满足以下条件：
 * 1、至少包含一个参数
 * 2、参数必须表示为val或者var
 * 3、数据类不可以声明为abstract、open、sealed和inner
 * 4、数据类不可以继承其他类，可以实现接口
 */
data class People(var name: String, var age: Int)

/**
 * 复制
 * 复制使用copy()函数，可以修改部分属性
 */
fun text() {
    val lin = People("lin", 12)
    val tom = lin.copy("tom", 13)
    val jack = tom.copy("jack")
    LogUtil.e(lin.toString())
    LogUtil.e(tom.toString())
    LogUtil.e(jack.toString())
}

/**
 * 数据类以及解构声明
 * 组件函数允许数据类在解构声明中使用
 */
fun text2() {
    val lin = People("lin", 12)
    val (name, age) = lin
    LogUtil.e("name is $name and age is $age")
}

/**
 * 密封类
 * 密封类用来表示受限的类继承结构
 * 声明一个密封类用sealed关键字，密封类可以有子类，但所有子类必须嵌套在密封类中
 *
 */
sealed class SealedClass

data class Const(var number: Double) : SealedClass()

data class Sum(var s1: SealedClass, var s2: SealedClass) : SealedClass()

object NotNumber : SealedClass()

// 使用密封类的关键好处在于使用 when 表达式 的时候，
// 如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了。
fun eval(sealedClass: SealedClass): Double = when (sealedClass) {
    is Const -> sealedClass.number
    is Sum -> eval(sealedClass.s1) + eval(sealedClass.s2)
    NotNumber -> Double.NaN
}









































