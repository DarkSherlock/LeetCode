package com.liang.tind.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/subsets/
 */
class LeetCode78 {

    fun subsets(nums: IntArray): List<List<Int>> {
        // 回溯的两种写法
        // https://leetcode.cn/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
        val ans = mutableListOf<List<Int>>()
        solution1(nums, 0, mutableListOf(), ans)
        return ans
    }

    private fun solution1(
        nums: IntArray,
        start: Int,
        path: MutableList<Int>,
        ans: MutableList<List<Int>>
    ) {
        //二叉树写法
        if (start == nums.size) {
            ans.add(ArrayList(path))
            return
        }

        path.add(nums[start])
        solution1(nums, start + 1, path, ans)

        //不选当前
        path.removeAt(path.size - 1)
        solution1(nums, start + 1, path, ans)
    }

    private fun solution2(
        nums: IntArray,
        start: Int,
        path: MutableList<Int>,
        ans: MutableList<List<Int>>
    ) {
        ans.add(ArrayList(path))
        // n叉树 写法
        if (start == nums.size) {
            return
        }

        for (i in start until nums.size) {

            path.add(nums[i])
            solution2(nums, i + 1, path, ans)
            path.removeAt(path.size - 1)
        }
    }
}