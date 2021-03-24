package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 继承
 *
 */
class Inherit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inherit)
        val student = Student("lin", 12, 1)
        Log.e("lin", "${student.name}")
        Log.e("lin", "${student.age}")
        Log.e("lin", "${student.sex}")
        val programmer = Programmer("cathy", 22, 2)
    }

}

/**
 * kotlin 中的超类是any类
 * any类中提供了三个函数
 * equals()
 * hashCode()
 * toString()
 */
class AnyTextClass : Any() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}
/**
 * 构造函数
 */
/**
 * 1、如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
 */
open class Person(var name: String, var age: Int) {}

class Student(name: String, age: Int, var sex: Int) : Person(name, age) {}

/**
 * 2、如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，
 * 或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
 */

class Programmer : Person {
    constructor(name: String, age: Int, sex: Int) : super(name, age) {
        Log.e("lin", "Programmer name : $name")
        Log.e("lin", "Programmer age : $age")
        Log.e("lin", "Programmer sex : $sex")
    }
}

/**
 * 重写
 * 多个方法相同时 使用super泛型的选择重写哪个父类的方法
 */

open class A {
    open fun f() {}
    open val a: Int = 0
}

interface B {
    fun f() {}
}

class C() : A(), B {

    override val a: Int = 2//重写属性
    override fun f() {
        super<A>.f()//调用A的f()
        super<B>.f()//调用B的f()
    }
}
















