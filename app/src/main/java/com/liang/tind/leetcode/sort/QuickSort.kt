package com.liang.tind.leetcode.sort

import java.util.Arrays
import java.util.LinkedList

/**
 *created by sherlock
 *
 *date 2019/12/10
 */
class QuickSort : Sort() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            quickSort(arr)
            println(arr.joinToString())
        }

        fun quickSort(intArray: IntArray) {
            realQuickSort(intArray, 0, intArray.size - 1)
        }

        fun realQuickSort(arr: IntArray, low: Int, high: Int) {
            if (low < high) {
                val index = getIndex(arr, low, high)
                realQuickSort(arr, low, index - 1)
                realQuickSort(arr, index + 1, high)
            }
        }

        /**
         * 找第一个数为基准数，高位指针向低位遍历，遇到比基准数小的，就把地位指针的坑赋值为高位指针的值
         * 低位指针再向高位遍历，遇到比基准数大的再把高位指针赋值为低位指针的值
         * 当两个指针相遇，就确定基准数的位置，此时，基准数左边的都比基准数小，
         * 右边的数都比基准数大，此时在让两边的递归寻找基准数，完成排序。
         */
        fun getIndex(arr: IntArray, low: Int, high: Int): Int {
            val temp = arr[low]
            var lowVar = low
            var highVar = high
            while (lowVar < highVar) {
                while (lowVar < highVar && temp <= arr[highVar]) {
                    highVar--
                }

                arr[lowVar] = arr[highVar]

                while (lowVar < highVar && temp >= arr[lowVar]) {
                    lowVar++
                }

                arr[highVar] = arr[lowVar]
            }

            arr[lowVar] = temp

            return lowVar
        }
    }

    class Solution {

        private val res = mutableListOf<List<Int>>()

        fun permuteUnique(nums: IntArray): List<List<Int>> {
            // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

            // 输入：nums = [1,1,2]
            // 输出：
            //      [[1,1,2],
            //      [1,2,1],
            //      [2,1,1]]

            //https://leetcode.cn/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
            res.clear()
            Arrays.sort(nums)
            val used = BooleanArray(nums.size)
            backtracking(nums, used, LinkedList<Int>())
            return res
        }

        private fun backtracking(nums: IntArray, used: BooleanArray, path: MutableList<Int>) {
            if (path.size == nums.size) {
                res.add(kotlin.collections.ArrayList<Int>(path))
                return
            }
            for (i in nums.indices) {
                if (used[i]) continue

                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue
                used[i] = true
                path.add(nums[i])
                backtracking(nums, used, path)
                path.removeAt(path.lastIndex)
                used[i] = false
            }
        }
    }
}