package com.liang.tind.leetcode.datastructrue;

/**
 * created by sherlock
 * <p>
 * date 2019/12/26
 */
public class Stack<E extends Comparable<E>> {
    private Node<E> head;
    private int size;

    private static class Node<T> {
        T min;
        T val;
        Node<T> next;

        public Node(T min, T val) {
            this.min = min;
            this.val = val;
        }
    }

    public void push(E val) {
        E min;
        if (head == null) {
            min = val;
        } else {
            min = val.compareTo(head.val) < 0 ? val : head.val;
        }
        Node<E> node = new Node<>(min, val);
        node.next = head;
        head = node;
        size++;
    }

    public E pop() {
        if (head != null) {
            E val = head.val;
            head = head.next;
            size--;
            return val;
        }
        throw new IllegalStateException("Stack is empty");
    }

    public E top() {
        if (head != null) {
            return head.val;
        }
        throw new IllegalStateException("Stack is empty");
    }

    public E min(){
        if (head != null) {
            return head.min;
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
