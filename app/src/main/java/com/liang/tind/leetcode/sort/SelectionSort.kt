package com.liang.tind.leetcode.sort

/**
 * created by sherlock
 *
 *
 * date 2019/12/10
 */
class SelectionSort : Sort() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            selectSort(arr)
            println(arr.joinToString())
        }

        /**
         * 从index = 0开始往后遍历，寻找后面数据中最小的数来和当前的数比较交换
         */
        fun selectSort(intArray: IntArray) {
            for (i in 0 until intArray.size - 1) {
                var min = i
                for (j in i + 1 until intArray.size) {
                    if (intArray[min] > intArray[j]) {
                        min = j
                    }
                }
                if (min != i) {
                    swap(intArray, min, i)
                }
            }
        }
    }
}