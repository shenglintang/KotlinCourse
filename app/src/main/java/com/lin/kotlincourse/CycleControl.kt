package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 循环控制
 */
class CycleControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_control)
        text2()
    }

    /**
     * for循环
     */
    fun text1() {
        var array = arrayOf(1, 2, 3)
        //遍历数组或者集合
        for (item in array) {

//            Log.e("lin", "item is $item")
        }
        //使用库函数遍历
        val items = listOf("apple", "banana", "kiwi")
        for ((items, value) in items.withIndex()) {
            Log.e("lin", "the array[$items] is $value")

        }
        items.forEach{
            Log.e("lin", "it is $it")
        }
    }
    /**
     * while 与do...while循环
     * 与java一样
     */

    /**
     * 返回与跳转
     * return break continue
     * 与java一样
     */
    fun text2() {
        var array = arrayOf(1, 2, 3)
        for (item in array) {
//            if (item == 2) break
            if (item == 2) continue
            Log.e("lin", "item0 is $item")
        }
        val items = listOf("apple", "banana", "kiwi")
       /* items.forEach{
            if (it.equals("banana")) return//加上了return标签，将会从最外层函数返回 后面的语句将不执行
            Log.e("lin", "it1 is $it")
        }*/
        items.forEach{
            if (it.equals("banana")) return@forEach//加上了@forEach标签，只会从表达式中返回，该标签与函数名相同
            Log.e("lin", "it2 is $it")
        }

        items.forEach(fun (value :String){
            if (value.equals("banana")) return//匿名函数内部的 return 语句将从该匿名函数自身返回
            Log.e("lin", "it3 is $value")
        })

    }
}
