package com.liang.tind.leetcode.datastructrue;

/**
 * created by sherlock
 * <p>
 * date 2019/12/26
 */
public class SingleLinkList<E extends Comparable<E>> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public void add(E val) {
        if (head == null) {
            head = tail = new Node<>(val);
        } else {
            Node<E> node = new Node<>(val);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addToHead(E val) {
        Node<E> node = new Node<>(val);
        node.next = head;
        head = node;
        size++;
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

    public boolean remove(E val) {
        if (head == null) return false;
        Node<E> pre = null;
        Node<E> remove = head;

        if (size == 1 && remove.val == val) {
            head = tail = null;
            size = 0;
            return true;
        }

        while (remove != null) {
            if (remove.val == val) {
                if (remove == head) {
                    head = head.next;
                } else if (remove == tail) {
                    pre.next = null;
                    tail = pre;
                } else {
                    pre.next = remove.next;
                }

                size--;
                return true;
            }
            pre = remove;
            remove = remove.next;
        }

        return false;
    }

    public E head() {
        if (head == null) return null;
        else return head.val;
    }

    public E tail() {
        if (tail == null) return null;
        else return tail.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
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
