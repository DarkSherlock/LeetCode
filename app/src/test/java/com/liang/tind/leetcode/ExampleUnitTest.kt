package com.liang.tind.leetcode

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun mySqrt(x: Int): Int {
        var l = 0
        var r = x
        var ans = -1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (mid.toLong() * mid <= x) {
                ans = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return ans
    }


    @Test
    fun test() {
        val set = LinkedHashSet<Int>()
        repeat(10) {
            set.add(it)
        }
        println(set.joinToString())
        val removeFirst = set.removeFirst()
        println("$removeFirst")
        println(set.joinToString())

        val removeFirst1 = set.removeFirst()
        println("$removeFirst1")
        println(set.joinToString())
    }

    fun <T> LinkedHashSet<T>.removeFirst(): T? {
        this.iterator().let { i ->
            if (i.hasNext()) {
                i.next().let {
                    i.remove()
                    return it
                }
            } else {
                return null
            }
        }
    }
}
