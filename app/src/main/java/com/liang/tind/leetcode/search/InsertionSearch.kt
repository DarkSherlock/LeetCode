package com.liang.tind.leetcode.search

import com.liang.tind.leetcode.sort.BobbleSort
import com.liang.tind.leetcode.sort.Sort

/**
 *created by sherlock
 *
 *date 2019/12/4
 * 插值查找
 */
class InsertionSearch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arg = arrayOf("")
            BobbleSort.main(arg)
            val index1 = insertionSearch(Sort.arr, 45)
            val index2 = insertionSearch(Sort.arr, 1)
            println("4,index = $index1")
            println("1,index = $index2")

            val noContain = insertionSearch(Sort.arr, 88)
            println("noContain = $noContain")
        }

        /**
         * 将2分查找的基础上，把mid按findValue在array中位置的比例做一下接近调整
         * 原先：val mid = (low + high) / 2 = low + 1/2 * (high -low)
         * 优化为：val mid = low + ((findValue - arr[low]) / (arr[high] - arr[low])) * (high -low)
         */
        private fun insertionSearch(arr: IntArray, target: Int): Int {
            var low = 0
            var high = arr.size - 1
            while (low <= high) {
                val mid = low + ((target - arr[low]) / (arr[high] - arr[low])) * (high -low)
                when {
                    arr[mid] == target -> {
                        return mid
                    }
                    arr[mid] > target -> {
                        high = mid - 1
                    }
                    else -> {
                        low = mid + 1
                    }
                }
            }
            return -1
        }
    }
}