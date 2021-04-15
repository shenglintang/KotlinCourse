package com.lin.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.*

/**
 * 协程:本质是轻量级的线程
 */
class CoroutineActivity : AppCompatActivity() {
val scope= MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        GlobalScope.launch { text7() }

        scope.launch {
            text5()
        }

        CoroutineScope(Dispatchers.Default).launch {
            text5()
        }
    }

    /**
     * GlobalScope 全局协程，生命周期只受整个应用程序的生命周期限制
     */
    fun text1() {
        GlobalScope.launch {
            delay(500)
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    }

    /**
     * 阻塞(runBlocking)与非阻塞(delay)
     */
    fun text2() {
        GlobalScope.launch {
            delay(500)
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        runBlocking {
            //这个表达式阻塞了主线程
            delay(2000)
        }
    }

    /**
     * 结构化的并发
     */
    fun text3() = runBlocking {
        // this: CoroutineScope
        launch {
            // 在 runBlocking 作用域中启动一个新协程
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }

    /**
     * 作用域构建器
     *runBlocking 与 coroutineScope 的主要区别在于后者在等待所有子协程执行完毕时不会阻塞当前线程。
     */
    fun text4() = runBlocking {
        // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope {
            // 创建一个协程作用域
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }

    /**
     * 取消协程
     * 协程的取消是 协作 的
     * 如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的，
     */
    suspend fun text5()= withContext(Dispatchers.IO) {
        val job = GlobalScope.launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(2500L) // 延迟一段时间
        println("main: I'm tired of waiting!")
        job.cancel() // 取消该任务
        job.join() // 等待任务执行结束
        println("main: Now I can quit.")
    }

    /**
     *有两种方法来使执行计算的代码可以被取消
     *第一种方法是定期调用挂起函数来检查取消。对于这种目的 yield 是一个好的选择。
     *  另一种方法是显式的检查取消状态
     */
    suspend fun text6() {
        val startTime = System.currentTimeMillis()
        val job = GlobalScope.launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // 可以被取消的计算循环使用isActive代替 i<5
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // 等待一段时间
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // 取消该任务并等待它结束
        println("main: Now I can quit.")
    }

    /**
     * 超时
     * 使用 withTimeout 函数来做这件事
     * withTimeoutOrNull
     */
    suspend fun text7(){
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    }
}
