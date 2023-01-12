package com.liang.tind.leetcode.backtrace

import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 */
class LeetCode78Test {

    @Test
    fun test() {
        val sample = LeetCode78()
        val result = sample.subsets(intArrayOf(1, 2, 3))
        println(result)
    }

    val res = mutableListOf<List<Int>>()

    fun subsets(nums: IntArray): List<List<Int>> {
        //nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        res.clear()
        val list = LinkedList<Int>()
        backtracking(nums, 0, list)
        return res
    }

    private fun backtracking(nums: IntArray, start: Int, path: MutableList<Int>) {
        res.add(ArrayList<Int>(path))
        if (start == nums.size) {
            return
        }

        for (i in start until nums.size) {
            path.add(nums[i])
            backtracking(nums, i + 1, path)
            path.removeLast()
        }
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        //https://leetcode.cn/problems/subsets-ii/
        res.clear()
        Arrays.sort(nums)
        val list = LinkedList<Int>()
        backtracking1(nums, 0, list)
        return res
    }

    private fun backtracking1(nums: IntArray, start: Int, path: MutableList<Int>) {
        res.add(ArrayList<Int>(path))
        if (start == nums.size) {
            return
        }

        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i-1]) continue
            path.add(nums[i])
            backtracking1(nums, i + 1, path)
            path.removeLast()
        }
    }
}