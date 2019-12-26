package com.liang.tind.leetcode.datastructrue;

/**
 * @author 梁天德
 * @date 2019/12/26 14:20
 * desc
 */
public class DoubleLinkList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkList() {

    }

    private static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E val;

        public Node(Node<E> pre, Node<E> next, E val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }

        public Node() {
        }
    }

    public void addToHead(E val) {
        Node<E> node = new Node<>();
        if (head == null) {
            head = tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }

        size++;
    }

    public void add(E val) {
        Node<E> node = new Node<>();
        node.val = val;
        if (tail == null) {
            head = tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public boolean remove(E val) {
        if (head == null) return false;

        if (size == 1 && head.val == val) {
            head = tail = null;
            size = 0;
            return true;
        }
        Node<E> node = head;
        while (node != null) {
            if (node.val == val) {
                Node<E> pre = node.pre;
                if (pre != null) {
                    pre.next = node.next;
                }
                Node<E> next = node.next;
                if (next != null) {
                    next.pre = pre;
                }
                if (node == head) {
                    head = next;
                } else if (node == tail) {
                    tail = pre;
                }
                size--;
                return true;
            }

            node = node.next;
        }

        return false;
    }


    public E removeHead() {
        if (head == null) return null;

        E val = head.val;
        return remove(val) ? val : null;
    }


    public E removeTail() {
        if (tail == null) return null;

        E val = tail.val;
        return remove(val) ? val : null;
    }

    public int size(){
        return size;
    }
    public void println() {
        Node<E> node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
