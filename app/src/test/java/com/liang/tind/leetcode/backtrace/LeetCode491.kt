package com.liang.tind.leetcode.backtrace

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/increasing-subsequences/
 */
class LeetCode491 {

    @Test
    fun test() {
        val params = intArrayOf(4, 4, 3, 2, 1)
        val result = findSubsequences(params)
        Assert.assertEquals(1, result.size)
        val list = result.first()
        for (i in list) {
            Assert.assertEquals(4, i)
        }

        val test2 = intArrayOf(1,2,3,4,5,6,7,8,9,10,1,1,1,1,1)
        val result2 = findSubsequences(test2)
        result2.forEach {
            println(it.joinToString())
        }
    }

    private val res = mutableListOf<List<Int>>()

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        // 输入：nums = [4,6,7,7]
        //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

        //输入：nums = [4,4,3,2,1]
        //输出：[[4,4]]

        res.clear()

        backtracking(nums, 0, LinkedList<Int>())
        return res
    }

    private fun backtracking(nums: IntArray, start: Int, path: MutableList<Int>) {
        if (path.size > 1) {
            println("start=$start, find a list:${path.joinToString()}")
            res.add(kotlin.collections.ArrayList<Int>(path))
        }
        if (start == nums.size) return

        val used = BooleanArray(201)
        for (i in start until nums.size) {
            if (used[nums[i]+100]) continue
            val last = path.lastOrNull()
            if (last != null && nums[i] < last) continue
            println("add=${nums[i]}, start = $start,i=$i")
            path.add(nums[i])
            used[nums[i]+100] = true
            backtracking(nums, i + 1, path)
            val removed = path.removeAt(path.lastIndex)
            println("removed=$removed, start = $start,i=$i")
        }
    }
}