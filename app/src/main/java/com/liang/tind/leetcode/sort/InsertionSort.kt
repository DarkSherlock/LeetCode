package com.liang.tind.leetcode.sort

/**
 *created by sherlock
 *
 *date 2019/12/10
 */
class InsertionSort : Sort() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            insertionSort(arr)
            println(arr.joinToString())
        }

        /**
         * 从index=1开始，不断和它上一位数据比较，如果比上一位数据小，上一位数据就后移
         *
         */
        fun insertionSort(intArray: IntArray) {
            for (i in 1 until intArray.size) {
                val temp = intArray[i]
                var j = i
                while (j > 0 && temp < intArray[j - 1]) {
                    intArray[j] = intArray[j - 1]
                    j--
                }
                if (j != i) {
                    intArray[j] = temp
                }
            }
        }
    }
}