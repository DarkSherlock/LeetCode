package com.liang.tind.leetcode.backtrace

import java.util.*
import java.util.stream.Collectors

/**
 *@author: lonnie.liang
 *date: 2022/05/20 23:32
 *
 */
class LeetCode78 {
    private val results: MutableList<List<Int>> = LinkedList()

    fun subsets(nums: IntArray): List<List<Int>> {


        // solution1(nums)
        solution2(nums)
        return results
    }

    private fun solution1(nums: IntArray) {
        results.clear()
        // 空集
        results.add(LinkedList())
        for (num in nums) {
            // 遍历nums 把之前结果中的每一个子集 都 copy出来 然后add num， 然后把copy 重新添加回去results中
            // 初始： results = [[]]
            // 第一轮：results[[]], subList = [[1]] map结束以后 -> results=[[], [1]]
            // 第二轮：results=[[], [1]], subList = [[2], [1,2]] map结束以后 -> results=[[], [1], [2], [1,2]]
            val subList = results.map { subset: List<Int> ->
                val newSubset: MutableList<Int> = LinkedList(subset)
                newSubset.add(num)
                newSubset
            }

            results.addAll(subList)
        }
    }

    private fun solution2(nums: IntArray) {
        results.clear()
        backStrace(0, mutableListOf(), nums)
    }
    private fun backStrace(cur: Int, track:MutableList<Int>, nums: IntArray) {
        //         [ ]
        //     [1]    [2] [3]
        //   [2] [3] [3]
        // [3]
        // 决策树入行，遍历可以当前选择列表，进入节点先把当前走过的路径添加进去

        results.add(ArrayList(track))
        for (i in cur until nums.size) {
            track.add(nums[i])
            backStrace(i+1, track, nums)
            track.removeAt(track.lastIndex)
        }
    }
}