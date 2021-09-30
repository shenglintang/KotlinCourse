package com.lin.kotlincourse

/**
 * 内联函数
 * 通过内联函数声明，可以将高阶函数对函数类型变量的函数式调用转换为直接对
一个普通函数的调用，甚至直接将被调用的函数内嵌到高阶函数内部，连函数调用都
省却掉
避免函数类型的实例化以及实例对象的内存分配
• 避免函数调用所带来的压战与出枝性能开销
 */
internal object InlineDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        //::的意思是返回一个函数
        advance(5f, ::square)

        val a= IntArray(4){ it*8}
        for (i in a){
            println("i =$i")
        }
    }

     fun advance(m: Float, square: (Float) -> Float) {
        val product = square(9f)
        println("product =$product")
    }

    fun square(x: Float = 4f) = x * x
}