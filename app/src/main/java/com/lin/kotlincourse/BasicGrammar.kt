package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 基础语法
 */
//声明常量 必须在top-level和object中。
const val name = "lin"

class BasicGrammar : AppCompatActivity() {

    //@JvmField 也可以声明常量
    @JvmField
    val sex = 0

    //声明常量 必须在top-level和object中。
    companion object {
        const val age = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_grammar)
        textFun5(1, 2, 3)
        textFun6()
        textFun8()
        textFun9()
        textFun10()
    }

    /**
     * 函数声明 关键字 fun (变量 ：类型)：返回值类型
     *
     */
    fun textFun1(str: String): String {
        return str
    }

    /**
     * 当没有返回值时可以返回值类型为Unit或者省略不写
     */
    fun textFun2(str: String): Unit {
    }

    fun textFun3(str: String) {
    }

    /**
     * 默认参数
     * 参数有默认值的话，我们可以不传这个参数
     */
    fun reformat(str: String,
                 normalizeCase: Boolean = true,
                 upperCaseFirstLetter: Boolean = true,
                 divideByCamelHumps: Boolean = false,
                 wordSeparator: String = "bbb") {
    }

    /**
     * 表达式作为函数体，返回类型由kotlin自动判断
     */
    fun textFun4(a: Int, b: Int) = a + b

    /**
     * 可变长参数函数 参数用vararg修饰
     */
    fun textFun5(vararg i: Int) {
        for (v in i) {

            Log.e("lin", "v is $v")
        }
    }

    /**
     * lambda函数
     */
    fun textFun6() {
        val textLambda: (Int, Int) -> Int = { a, b -> a + b }
        Log.e("lin", "textLambda is ${textLambda(1, 2)}")
    }

    /**
     * 定义常量和变量
     * var 声明可变的变量
     * val 声明不可变对象，相当于java中的final
     * 可以不声明类型，由编译器自己判断
     */
    fun textFun7() {
        var a = 1
        var b: String = "b"
        val c = false
//        c =true //c不可变量此段编译不过

    }

    /**
     * 字符串模板
     * $表示一个变量名或者变量值
     * $varName表示变量值
     * ${varName.fun()}表示方法返回值
     */
    fun textFun8() {
        var a = 1
        Log.e("lin", "a is $a")
        Log.e("lin", "textFun4 is ${textFun4(1, 2)}")
    }

    /**
     * NULL检查机制
     * kotlin特性之一 对空指针的处理有两种方式
     * 1、字段后面加!!则抛异常
     * 2、字段后加？表示可为空或者配合？：做空处理
     */
    fun textFun9() {
        var a: String? = "1"
        Log.e("lin", "a is $a")
        var b: String = "1"
//        b= null//编译不通过

        a = null
        var c = a?.toInt()//可为空
        Log.e("lin", "c is $c")

        var d = a?.toInt() ?: "3"//为空则默认为3
        Log.e("lin", "d is $d")
    }

    /**
     * 区间
     * 操作符 a..b 表示从a到b 包含两端
     * step 指定步长
     * until 函数排除结束元素
     * downTo 与..相反
     */
    fun textFun10() {
        for (i in 1..4) {
            Log.e("lin", "i = $i")
        }
        for (i in 1..4 step 2) {
            Log.e("lin", "i = $i")
        }
        for (i in 4 downTo 4) {
            Log.e("lin", "i = $i")
        }
        for (i in 1 until 4) {
            Log.e("lin", "i = $i")
        }
    }
}
