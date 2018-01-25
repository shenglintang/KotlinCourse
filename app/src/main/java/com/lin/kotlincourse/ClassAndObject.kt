package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 类和对象
 *
 */
class ClassAndObject : AppCompatActivity() {
    //Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
    //主构造器只能含有init关键字作为前缀的初始化代码，不能含有其他代码
    class ClassAndObject constructor(name: String,age: Int) {
        init {
            Log.e("lin", " constructor name is $name ")
            Log.e("lin", " constructor age is $age ")
        }

    }

    //如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
    //class ClassAndObject (name: String,age: Int) {}

    /**
     * getter和setter
     * kotlin中类不能有字段，提供了 Backing Fields(后端变量) 机制，
     * 备用字段使用filed关键字声明，filed关键字只能用于属性的访问器
     */
    var age: Int = 10
        get() = field//后端变量
        set(value) {
            if (value == 1) {
                field = 100
            }
        }
    var name: String = "Lin"
        get() = field.toUpperCase()//后端变量
        set(value) {
            if (value.equals("tom")) {
                field = "tom"
            }
        }

    //非空属性必须在定义的时候初始化，kotlin提供了lateinit关键字来延迟初始化
    lateinit var basicGrammar: BasicGrammar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_and_object)
        //创建对象 kotlin中没有new关键字
        basicGrammar = BasicGrammar()
    }

    fun text1() {

    }

}
