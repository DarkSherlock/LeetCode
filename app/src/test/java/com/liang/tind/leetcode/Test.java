package com.liang.tind.leetcode;

import com.liang.tind.leetcode.datastructrue.Stack;

/**
 * created by sherlock
 * <p>
 * date 2019/12/23
 */
public class Test {

    @org.junit.Test
    public void test(){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(-1);
        stack.push(-3);
        System.out.println(stack.min());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
