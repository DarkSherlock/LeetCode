package com.liang.tind.leetcode.sort

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
         * 找第一个数为基准数，高位指针向低位遍历，遇到比基准数小的就和基准数
         * 交换位置，地位指针再向高位遍历，遇到比基准数大的再和基准数交换位置，
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
}