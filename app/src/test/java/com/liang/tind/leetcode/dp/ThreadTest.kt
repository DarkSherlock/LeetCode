package com.liang.tind.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashSet

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ThreadTest {
    @Test
    fun testThread() {
        val countDown = CountDownLatch(1)
        Buffer().apply {
            repeat(3) {
                produce("producer$it")
            }

            repeat(1) {
                consume("consumer$it")
            }
        }
        countDown.await(10, TimeUnit.SECONDS)
    }


    inner class Buffer {
        var prodution = 0
        val lock = ReentrantLock()
        val produceCondition = lock.newCondition()
        val consumeCondition = lock.newCondition()

        fun produce(name: String) {
            println("producer name=$name")
            Thread(Producer(this), name).start()
        }

        fun consume(name: String) {
            println("consumer name=$name")
            Thread(Consumer(this), name).start()
        }
    }


    inner class Producer(private val buffer: Buffer) : Runnable {
        private val lock = buffer.lock

        override fun run() {
            while (true) {
                Thread.sleep(100)
                lock.lock()
                if (buffer.prodution > 100) {
                    println("Thread:${Thread.currentThread().name} pause to produce")
                    buffer.produceCondition.await()
                } else {
                    buffer.prodution++
                    println("Thread:${Thread.currentThread().name} produce:${buffer.prodution}")
                }
                buffer.consumeCondition.signal()
                lock.unlock()
            }
        }
    }


    inner class Consumer(private val buffer: Buffer) : Runnable {
        private val lock = buffer.lock
        override fun run() {
            while (true) {
                Thread.sleep(100)
                lock.lock()
                if (buffer.prodution <= 50) {
                    println("Thread:${Thread.currentThread().name} pause to consume")
                    buffer.consumeCondition.await()
                } else {
                    buffer.prodution--
                    println("Thread:${Thread.currentThread().name} consume=${buffer.prodution}")
                }
                if (buffer.prodution <= 75) {
                    buffer.produceCondition.signal()
                }
                lock.unlock()
            }
        }
    }
}
