package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 条件控制
 */
class ConditionControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condition_control)
        text1(1, 2)
        text2(3)
    }

    /**
     * if表达式
     * 与java差不多
     */
    fun text1(a: Int, b: Int) {
        //作为表达式 像java的三元表达式
        val max = if (a > b) a else b
        Log.e("lin", "max is $max")
    }

    /**
     * when表达式
     * 将它的参数和所有分支条件比较
     * 类似switch
     */
    fun text2(a: Int) {
        //作为表达式 像java的三元表达式

        when (a) {
            18, 12 -> Log.e("lin", "a is 18 or 12")
            in 3..5 -> Log.e("lin", "a is 3 to 5")//检测一个值在（in）或者不在（!in）一个区间或者集合中
            2 -> Log.e("lin", "a is 2")
            else -> {//else相当于default
                Log.e("lin", "this is a default block")
            }
        }
        //也可以不带参数
        val list = arrayOf(1, 2, 3)
        when {
            list[0] == 1 -> Log.e("lin", "list[0]  is ${list[0] }")
        }
    }

}
