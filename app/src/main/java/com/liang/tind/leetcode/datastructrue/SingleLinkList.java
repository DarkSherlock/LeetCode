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
            head.next = tail = new Node<>(val);
        }
        size++;
    }

    public void addToHead(E val) {
        Node<E> node = new Node<>(val);
        node.next = head;
        head = node;
    }

    public E removeHead() {
        if (head == null) return null;
        Node<E> remove = head;
        if (remove == tail) {
            tail = null;
        }
        head = head.next;
        size--;
        return remove.val;
    }

    public E remove() {
        Node<E> node = head;
        if (node == null) return null;
        if (node == tail) {
            E val = node.val;
            head = tail = null;
            size = 0;
            return val;
        }

        while (node.next != tail) {
            node = node.next;
        }
        Node<E> remove = tail;
        node.next = null;
        tail = node;
        size--;
        return remove.val;
    }

    public boolean remove(E val) {
        if (head == null) return false;
        else if (val == head.val){
            head = head.next;
            return true;
        }
        Node<E> node = head;
        Node<E> pre = null;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                return true;
            }
            pre = node;
            node = node.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
