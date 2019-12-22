package com.liang.tind.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by sherlock
 * <p>
 * date 2019/12/22
 * <p>
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * <p>
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 案例:
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 60; j++) {
//                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
//                    res.add(String.format("%d:%02d", i, j));
//                }
//            }
//        }
        int[] book = new int[10];
        dfs(num, 0, book, res);
        Collections.sort(res);
        return res;
    }

    /**
     * book[i] = 1;
     * dfs(num -1, i + 1, book)
     * book[i]= 0;
     */
    private void dfs(int num, int cur, int[] book, List<String> res) {
        if (num == 0) {
            int hour = 1 * book[0] + 2 * book[1] + 4 * book[2] + 8 * book[3];
            int minute = 1 * book[4] + 2 * book[5] + 4 * book[6] + 8 * book[7]
                    + 16 * book[8] + 32 * book[9];

            if (hour < 12 && minute < 60) {
                res.add(String.format("%d:%02d", hour, minute));
            }

            return;
        } else {
            for (int i = cur; i < book.length; i++) {
                book[i] = 1;
                dfs(num - 1, i + 1, book, res);
                book[i] = 0;
            }
        }
    }
}
