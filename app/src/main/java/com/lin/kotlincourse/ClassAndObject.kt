package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 类和对象
 *
 */
class ClassAndObject : AppCompatActivity() {
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
            } else {
                field = value
            }
        }
    var name: String = "Lin"
        get() = field.toUpperCase()//后端变量

    var sex = 1
    //非空属性必须在定义的时候初始化，kotlin提供了lateinit关键字来延迟初始化
    lateinit var basicGrammar: BasicGrammar

    /**
     * 构造器
     * Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
     * 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
     */
    class ClassAndObject constructor(name: String, age: Int) {

        init {
            Log.e("lin", "main constructor name is $name ")
            Log.e("lin", "main constructor age is $age ")
        }

        fun text1() {
            Log.e("lin", "text1")
        }

        /**
         *  次构造函数 注意参数不能跟主构造器一样
         * 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。
         * 在同一个类中代理另一个构造函数使用 this 关键字：
         */

        constructor(name: String, age: Int, sex: Int) : this(name, age) {
            when (sex) {
                1 -> Log.e("lin", "is a girl")
                2 -> Log.e("lin", "is a boy")
            }
            Log.e("lin", "seconed constructor age is $age ")
            Log.e("lin", "seconed constructor name is $name ")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_and_object)
        //创建对象 kotlin中没有new关键字
        basicGrammar = BasicGrammar()
        text2()
        var anonymousInnerClass =AnonymousInnerClass()
        anonymousInnerClass.setInterface(object :TextInterface{
            override fun text() {
                Log.e("lin", "this is an anonymousInnerClass")
            }
        } )
    }

    fun text2() {
        Log.e("lin", " text2 ")
        NestedClass().NestedClassText()

    }

    /**
     * 嵌套类
     */
    class NestedClass() {
        fun NestedClassText() {
            Log.e("lin", " NestedClassText ")

        }
    }
    /**
     * 内部类 使用inner关键字来表示
     */
    inner class InnerClass(){

        val innerAge = age //访问外部类成员属性
        fun innerTest() {
            var o = this@ClassAndObject //获取外部类的成员函数
            o.text2()
        }

    }

}

/**
 * 抽象类
 * 可以省略open关键字
 */
open class AbstractClassBase {
    open fun text() {}
}

/**
 * 具体类继承抽象类
 */
class ConcreteClass : AbstractClassBase() {
    override fun text() {

    }
}

/**
 * 抽象类继承抽象类
 */
abstract class AbstractClass : AbstractClassBase() {
    override abstract fun text()
}

class ConcreteClass2 : AbstractClass() {
    override fun text() {

    }
}

/**
 * 匿名内部类
 */
class AnonymousInnerClass(){
    fun setInterface(text: TextInterface){
        text.text()
    }



}

/**
 * 定义一个接口
 */
interface TextInterface{
    fun text()
}








