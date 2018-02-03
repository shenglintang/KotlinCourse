package com.lin.kotlincourse

/**
 * Created by lin on 2018/2/3.
 * 使用companion object相当于java的静态方法
 */
class StaticClassDemo {
    companion object {
        fun showMessage() {
            LogUtil.e("这是静态方法")
        }
    }
}