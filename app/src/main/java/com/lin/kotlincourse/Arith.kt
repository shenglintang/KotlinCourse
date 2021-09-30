package com.lin.kotlincourse

/**
 *Time:2021/9/30
 *Author:lin
 *Description：操作符重载 operator
 */
open class Arith(var value: Int) {
    /**
     * 重载乘法
     */
    operator fun times(arith: Arith): Arith {
        this.value = this.value * arith.value
        return this
    }

    /**
     * 重载加法
     */
    operator fun plus(int: Int): Arith {
        this.value = this.value + int
        return this
    }

    operator fun minus(int: Int): Arith {
        this.value = this.value + int
        return this
    }

    override fun toString(): String {
        return value.toString()
    }

    /**
     * 使用重载后的times方法
     */
    fun useOperatorFunc() {
        val arithl = Arith(6)
        val arith2 = Arith(5)
        println(arithl * arith2)
        println(arithl + 9)
        println(arithl - 9)
    }

}