package com.liang.tind.leetcode.search

import com.liang.tind.leetcode.sort.BobbleSort
import com.liang.tind.leetcode.sort.Sort

/**
 *created by sherlock
 *
 *date 2019/12/4
 */
class BinarySearch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arg = arrayOf("")
            BobbleSort.main(arg)
            val index = binarySearch(Sort.arr, 45)
            println("index = $index")

            val noContain = binarySearch(Sort.arr, 88)
            println("noContain = $noContain")
        }

        fun binarySearch(arr: IntArray, target: Int): Int {
            var low = 0
            var high = arr.size - 1
            while (low <= high) {
                val mid = (low + high) / 2
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