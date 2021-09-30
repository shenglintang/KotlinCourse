package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_data_type.*

/**
 * 数据类型
 * kotlin的基本数据类型包括Byte Short Int Long Float Double
 * 主要注意的是字符不属于基本数据类型，是一个独立的数据类型
 */
class DataType : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_type)
//        text1()
//        text2()
//        text3()
        text5()
//
        text6()

        //区间
        val range = 1..23

    }

    /**
     * 比较两个数字
     * ==比较两个数字的值是否相等
     * ===比较两个数字的地址对否相同
     */
    fun text1() {
        val a = 1000
        val b: Int? = a
        val c: Int? = a
        Log.e("lin", "c==b is ${c == b}")//经过装箱之后值都是1000 返回true
        Log.e("lin", "c===b is ${c === b}")//经过装箱之后创建了2个对象，地址不一样 false
        // 需要注意的是：
        //JVM虚拟机中维护着有符号整形常量池（-128,127），
        //在这个范围里的数值都会直接使用常量池的内存地址，
        //所以这个范围内的数值装箱后比较内存地址依旧是相等的
        val d = a
        val e = a
        Log.e("lin", "d ==e is ${d == e}")//未经过装箱之后值都是1000 返回true
        Log.e("lin", "d ===e is ${d === e}")//未经过装箱还是一样 返回true
    }

    /**
     * 类型转换
     * 每种数据类型都有下面的这些方法，可以转化为其它的类型：
    toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char
     */
    fun text2() {
        var a: String = "2"
        val b: Int = a.toInt()
        Log.e("lin", "a is $a")
    }

    /**
     * 位操作符
     *
     */
    fun text3() {
        var a: Int = 10
        val b = a.shl(1)//左移一位
        Log.e("lin", "b is $b")
        var c = a.shr(1)//右移一位
        Log.e("lin", "c is $c")
        //and 与 or 或 xor 异或 inv 反向
        var f = true
        var e = false
        Log.e("lin", " f.and(e) is ${f.and(e)}")
        Log.e("lin", " f.or(e) is ${f.or(e)}")
        Log.e("lin", " f.xor(e) is ${f.xor(e)}")
        Log.e("lin", "   a.inv() is ${a.inv()}")
    }

    /**
     * 字符
     * kotlin中字符必须用单引号'包起来 如'1'，'c'
     * 特殊字符可以用反斜杠转义\n,\r,\',\",\$
     */
    fun text4(c: Char) {
//        if (c==1){//类型不匹配
//
//        }
    }

    /**
     * 布尔运算符 与java一样
     * || && !
     */

    /**
     * 数组
     * 数组用类Array实现
     * 数组可以通过arrayOf()或者使用工厂函数创建
     */
    fun text5() {
        var a = arrayOf(1, 2, 3)
        Log.e("lin", " a[0] is ${a[0]}")
        var b = Array(3) { i -> (i * 2) }
        Log.e("lin", " b[1] is ${b[2]}")
//除了类Array，还有ByteArray, ShortArray, IntArray，
// 用来表示各个类型的数组，
// 省去了装箱操作，因此效率更高
        val x: IntArray = intArrayOf(1, 2, 3)
    }

    /**
     * 字符串
     * Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串
     * String 可以通过 trimMargin() 方法来删除多余的空白
     * 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
     */
    fun text6() {
        var text = """
    >多行字符串
    >菜鸟教程
    >多行字符串
    >Runoob
    """
        textView.setText(text.trimMargin(">"))//  删除了>
    }

}
