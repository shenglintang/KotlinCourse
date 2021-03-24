package com.lin.kotlincourse

import android.os.Parcel
import android.os.Parcelable
import java.io.BufferedReader
import java.io.FileReader
import java.nio.Buffer

/**
 *Time:2021/3/24
 *Author:lin
 *Description： 高阶函数
 */
fun main(args: Array<String>) {
    //map
//    val list = listOf(1, 2, 3)
//    val newList = list.map { it * 2 + 1 }
//    newList.forEach(::println)


    //flatMap
    val list = listOf(1..3, 4..10, 5..9)
    val newlist = list.flatten()
//    newlist.forEach(::println)
//    val newlist2 = list.flatMap { intRange ->
//        intRange.map {
//            "NO.$it"
//        }
//    }
//    newlist2.forEach(::println)

    //求和 reduce
//    println("reduce =" + newlist.reduce { acc, i -> acc + i })
//
//    //fold 添加初始值
//    println("fold =" + newlist.fold(5) { acc, i ->
//        acc + i
//    })

    //过滤
//    println("filter =${newlist.filter { it % 2 == 1 }}")
    //takeWile
//    println("takeWile =${newlist.takeWhile { it % 2 == 1 }}")

    //let apply
    findPerson()?.let { persons -> persons.name;persons.work() }
    findPerson()?.apply { name;work() }
    //with 必须不为null
    with(findPerson2()) {
        work();
        name
    }
    //use 不用谢close
    BufferedReader(FileReader("")).use {
        var line: String?
        while (true) {
            line = readLine() ?: break
            println(line)
        }
    }
}

fun findPerson2(): Persons {
    return Persons("lin", 18)
}

data class Persons(val name: String, val age: Int) {
    fun work() {
        println("$name is working")
    }

}

fun findPerson(): Persons? {
    return null
}