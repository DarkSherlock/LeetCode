package com.liang.tind.leetcode.strings;

import java.util.Stack;

/**
 * created by sherlock
 * <p>
 * date 2019/12/29
 */
public class LeetCode20 {
    int[] countArray = new int[3];
    Stack<Integer> stack = new Stack<>();
    static final int little = 0, mid = 1, big = 2;

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c == '(') {
                pushRecord(little);
            } else if (c == '[') {
                pushRecord(mid);
            } else if (c == '{') {
                pushRecord(big);
            } else if (c == ')') {
                if (stack.isEmpty()) return  false;
                Integer pop = stack.pop();
                if (pop != little) {
                    return false;
                } else {
                    countArray[little] = --countArray[little];
                }
            } else if (c == ']') {
                if (stack.isEmpty()) return  false;
                Integer pop = stack.pop();
                if (pop != mid) {
                    return false;
                } else {
                    countArray[mid] = --countArray[mid];
                }
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                Integer pop = stack.pop();
                if (pop != big) {
                    return false;
                } else {
                    countArray[big] = --countArray[big];
                }
            }
        }

        for (int count : countArray) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    private void pushRecord(int type) {
        stack.push(type);
        int count = countArray[type];
        countArray[type] = ++count;
    }
}
