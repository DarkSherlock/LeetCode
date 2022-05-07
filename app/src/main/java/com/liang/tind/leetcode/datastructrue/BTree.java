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
        private final K key;
        private V value;
        private Node left, right;
        private int n;//以该节点为根的子树中的结点总数

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
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
        else return node.n;
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
        node.n = size(node.left) + size(node.right) + 1;
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
        return max(node.right);
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

    public void DLR() {
        DLR(root);
    }

    public void LDR() {
        LDR(root);
    }

    public void LRD() {
        LRD(root);
    }

    /**
     * 前序遍历: 先根节点 再左子树 再右子树
     *
     * @param node
     */
    private void DLR(Node node) {
        if (node == null) return;
        System.out.println("DLR: " + node.key);
        DLR(node.left);
        DLR(node.right);
    }

    /**
     * 中序遍历: 先左子树 再根节点 再右子树
     *
     * @param node
     */
    private void LDR(Node node) {
        if (node == null) return;
        LDR(node.left);
        System.out.println("LDR: " + node.key);
        LDR(node.right);
    }

    /**
     * 后序遍历: 先右子树 再根节点 再左子树
     *
     * @param node
     */
    private void LRD(Node node) {
        if (node == null) return;
        LRD(node.left);
        LRD(node.right);
        System.out.println("LRD: " + node.key);
    }

    /**
     * Breadth First Search 广度优先搜索
     */
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

    private int getDepth(Node node) {
        if (node == null) return 0;
        else {
            return (Math.max(getDepth(node.left), getDepth(node.right)) + 1);
        }
    }
}
