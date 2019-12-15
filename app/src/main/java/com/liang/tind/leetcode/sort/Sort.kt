package com.liang.tind.leetcode.sort

/**
 *created by sherlock
 *
 *date 2019/12/10
 */

open class Sort{
    companion object{
        val arr = intArrayOf(1, 100, 23, 45, 2, 11, 45, 78, 90, 56)

         fun swap(intArray: IntArray, a: Int , b:Int){
            val temp  = intArray[a]
             intArray[a] = intArray[b]
             intArray[b] = temp
        }
    }
}