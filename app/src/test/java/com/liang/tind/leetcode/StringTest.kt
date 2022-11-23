package com.liang.tind.leetcode

import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 *@author: lonnie.liang
 *date: 2022/05/08 15:50
 *
 */

class StringTest {

    @Test
    fun revertStringTest() {
        val s = "abcdefg"
        println(s.substring(0, 1))
        println('A'.code)

        mySqrt(2147395599)
    }


    fun mySqrt(x: Int): Int {
        // 由于 x 平方根的整数部分是满足 k^2 ≤x 的最大k 值
        var left = 0
        var right = x
        var ans = -1
        while (left <= right) {
            val mid = (left + right) / 2
            println("left=$left,right=$right,mid=$mid")
            if (mid <= x / mid) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return ans
    }

}