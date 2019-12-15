package com.liang.tind.leetcode.commom

import android.content.Context
import android.content.Intent

/**
 *created by sherlock
 *
 *date 2019/12/4
 */

fun <T> start(context: Context, cls: Class<T>) {
    val intent = Intent(context, cls)
    context.startActivity(intent)
}
