package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 枚举类
 */
class EnumClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enum_class)
        LogUtil.e("State.WAITTING is ${State.WAITTING.stateTest()}")
        textw()
    }
}

/**
 * 枚举初始化
 */

enum class Color(rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 支持声明匿名类以及相应的方法，覆盖基类的方法
 */
enum class State {
    WAITTING {
        override fun stateTest() = 0
    },
    WRITTING {
        override fun stateTest() = true
    };

    abstract fun stateTest(): Any
}
/**
 * 使用枚举常量
 * kotlin中的枚举类具有合成方法，允许遍历定义的枚举常量,State.values()，
 * 并通过其名称获取枚举常数,  State.valueOf(String)
 * 如果没有匹配到则会抛异常 No enum constant com.lin.kotlincourse.State.WAITTIN
 */
fun textw(){
    LogUtil.e("State.valueOf(\"WAITTING\") is ${State.valueOf("WRITTING")}")
    LogUtil.e("State.values() is ${State.values().joinToString { it.name }}")
    //1.1以上可以使用泛型访问枚举类
    LogUtil.e(" enumValues<State>().joinToString {it.name  } is ${ enumValues<State>().joinToString {it.name  }}")
    LogUtil.e("enumValueOf<State>(\"WRITTING\")is ${enumValueOf<State>("WRITTING")}")

}

























