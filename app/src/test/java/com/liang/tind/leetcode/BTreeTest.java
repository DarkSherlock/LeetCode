package com.liang.tind.leetcode;

import com.liang.tind.leetcode.datastructrue.DoubleLinkList;
import com.liang.tind.leetcode.datastructrue.SingleLinkList;
import com.liang.tind.leetcode.datastructrue.Stack;

/**
 * created by sherlock
 * <p>
 * date 2019/12/23
 */
public class BTreeTest {

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

    @org.junit.Test
    public void testSingleLink(){
        SingleLinkList<Integer> linkList = new SingleLinkList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);

        System.out.println("--------------");
        System.out.println(linkList.remove(2));
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
        System.out.println(linkList.removeHead());
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
        System.out.println(linkList.removeTail());
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
    }


    @org.junit.Test
    public void testLink(){
        DoubleLinkList<Integer> linkList = new DoubleLinkList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);

        System.out.println("--------------");
        System.out.println(linkList.remove(2));
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
        System.out.println(linkList.removeHead());
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
        System.out.println(linkList.removeTail());
        System.out.println("--------------");
        linkList.println();
        System.out.println("--------------");
    }
}
