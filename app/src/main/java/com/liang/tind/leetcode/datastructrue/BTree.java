package com.liang.tind.leetcode.datastructrue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * created by sherlock
 * <p>
 * date 2019/12/19
 */
public class BTree<K extends Comparable<K>, V> {
    private static final String TAG = "BTree";
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;//以该节点为根的子树中的结点总数

        public Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return min(node.right);
    }

    public K floor(K key) {
        Node floor = floor(root, key);
        if (floor == null) return null;
        return floor.key;
    }

    private Node floor(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return floor(node.left, key);

        Node right = floor(node.right, key);
        if (right != null) return right;
        else return node;
    }

    /**
     * 前序遍历: 先左子树 再根节点 再右子树
     *
     * @param node
     */
    public void DLR(Node node) {
        if (node == null) return;
        System.out.println("LDR: " + node.key);
        DLR(node.left);
        DLR(node.right);
    }

    /**
     * 中序遍历: 先左子树 再根节点 再右子树
     *
     * @param node
     */
    public void LDR(Node node) {
        if (node == null) return;
        LDR(node.left);
        System.out.println("LDR: " + node.key);
        LDR(node.right);
    }

    /**
     * 前序遍历: 先左子树 再根节点 再右子树
     *
     * @param node
     */
    public void LRD(Node node) {
        if (node == null) return;
        LRD(node.left);
        LRD(node.right);
        System.out.println("LDR: " + node.key);
    }

    public void BFS() {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(Node root) {
        if (root == null) return 0;
        else {
            return (Math.max(getDepth(root.left), getDepth(root.right)) + 1);
        }
    }
}
