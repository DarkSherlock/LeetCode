package com.liang.tind.leetcode.sort

/**
 *created by sherlock
 *
 *date 2019/12/4
 */
class BobbleSort : Sort() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            bobbleSort(arr)
            println(arr.joinToString())
        }

        fun bobbleSort(arr: IntArray) {
            var flag = true
            for (i in 0 until arr.size - 1) {
                for (j in 0 until arr.size - 1 - i) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1)
                        flag = false
                    }
                }
                if (flag) break
            }
        }
    }

}