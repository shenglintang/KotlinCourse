package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 *接口
 */
class InterFaceAc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inter_face)
        val interfaceDemo = ImplInterfaceDemo()
        interfaceDemo.a()
        interfaceDemo.b()
        LogUtil.e(interfaceDemo.name)
    }
}

/**
 * 使用interface关键字定义，允许有默认实现的方法
 * 接口中的属性一定是抽象的 不允许赋值
 */
interface InterfaceDemo {
    var name : String
    fun a()
    fun b() {
        LogUtil.e("默认实现的方法")
    }
}

class ImplInterfaceDemo() : InterfaceDemo {
    override var name:String = "lin"
    override fun a() {
        LogUtil.e("实现了a方法")
    }

    override fun b() {
        LogUtil.e("重写了b方法")
//        super.b()
    }
}
