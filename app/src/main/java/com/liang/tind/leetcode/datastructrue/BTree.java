package com.liang.tind.leetcode.datastructrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
        private int n;//以该节点为根的子树中的结点总数

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
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

    public void remove(K key) {
        remove(key, root);
    }

    public void remove2(K key) {
        remove2(key, root);
    }

    private Node remove(K key, Node node) {
        /*
         * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
         * 找到删除的节点
         * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
         * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
         * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
         * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
         * 删除7，则需要把5放在8的左子树上
         *           2                           2
         *      1         7                1          9
         *              5      9       =》          8     10
         *           4   6  8    10              5
         *                                     4  6
         */
        //case 1
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null && node.right == null) {
                //case 2
                return null;
            } else if (node.left == null) {
                //case 3
                return node.right;
            } else if (node.right == null) {
                //case 4
                return node.left;
            } else {
                //case5
                // 找到右子树最左面的节点 即右子树最小的节点 然后让左子树成为这个节点的左子树
                Node cur = node.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = node.left;

                return node.right;
            }

        } else if (cmp < 0) {
            node.left = remove(key, node.left);
        } else {
            node.right = remove(key, node.right);
        }

        return node;
    }

    /**
     * 普通二叉树的删除节点
     * 让目标节点和右子树的最小节点交换value。然后最后便利到最小节点的时候返回null
     *
     * @param key
     * @param node
     * @return
     */
    private Node remove2(K key, Node node) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.right == null) {
                // case1: target.right == null, 直接返回左子树。
                // case2: 经由下面的swap后最后遍历到target.right的最小节点时，应该返回null，因为这时候是叶子节点直接返回left也是null.
                return node.left;
            }

            Node cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            //swap cur and target
            K tempK = cur.key;
            V tempV = cur.value;
            cur.key = node.key;
            cur.value = node.value;
            node.key = tempK;
            node.value = tempV;
        }
        node.left = remove2(key, node.left);
        node.right = remove2(key, node.right);
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

    public void DLR2() {
        DLR2(root);
    }

    public void DLR3() {
        DLR3(root);
    }

    public void LDR() {
        LDR(root);
    }

    public void LDR2() {
        LDR2(root);
    }

    public void LDR3() {
        LDR3(root);
    }

    public void LRD() {
        LRD(root);
    }

    public void LRD3() {
        LRD3(root);
    }

    /**
     * 前序遍历: 先根节点 再左子树 再右子树
     *
     * @param node
     */
    private void DLR(Node node) {
        if (node == null) return;
        System.out.println("DLR: " + node);
        DLR(node.left);
        DLR(node.right);
    }

    private void DLR2(Node root) {
        if (root == null) return;
        Node node = root;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            System.out.println("DLR2:" + node);
            if (node.right != null) {
                nodeDeque.push(node.right);
            }
            if (node.left != null) {
                nodeDeque.push(node.left);
            }
        }
    }

    private void DLR3(Node root) {
        if (root == null) return;
        Node node = root;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            if (node != null) {
                if (node.right != null) {
                    nodeDeque.push(node.right);
                }
                if (node.left != null) {
                    nodeDeque.push(node.left);
                }
                nodeDeque.push(node);
                nodeDeque.push(null);
            } else {
                node = nodeDeque.pop();
                System.out.println("DLR3:" + node);
            }
        }
    }

    /**
     * 中序遍历: 先左子树 再根节点 再右子树
     *
     * @param node
     */
    private void LDR(Node node) {
        if (node == null) return;
        LDR(node.left);
        System.out.println("LDR: " + node);
        LDR(node.right);
    }

    private void LDR2(Node root) {
        if (root == null) return;
        Node node = root;
        Deque<Node> nodeDeque = new LinkedList<>();
        while (node != null || !nodeDeque.isEmpty()) {
            if (node != null) {
                nodeDeque.push(node);
                node = node.left;
            } else {
                node = nodeDeque.pop();
                // pre root
                System.out.println("LDR:" + node);
                node = node.right;
            }
        }
    }

    private void LDR3(Node root) {
        if (root == null) return;
        Node node = root;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            if (node != null) {
                if (node.right != null) {
                    nodeDeque.push(node.right);
                }
                nodeDeque.push(node);
                nodeDeque.push(null);
                if (node.left != null) {
                    nodeDeque.push(node.left);
                }

            } else {
                node = nodeDeque.pop();
                System.out.println("DLR3:" + node);
            }
        }
    }

    /**
     * 后序遍历: 先左子树 再右子树 再根节点
     *
     * @param node
     */
    private void LRD(Node node) {
        if (node == null) return;
        LRD(node.left);
        LRD(node.right);
        System.out.println("LRD: " + node);
    }


    private void LRD3(Node root) {
        if (root == null) return;
        Node node = root;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            if (node != null) {
                nodeDeque.push(node);
                nodeDeque.push(null);

                if (node.right != null) {
                    nodeDeque.push(node.right);
                }
                if (node.left != null) {
                    nodeDeque.push(node.left);
                }

            } else {
                node = nodeDeque.pop();
                System.out.println("DLR3:" + node);
            }
        }
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
            System.out.println("BFS:" + poll.value);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    /**
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     * 层序遍历用递归方式
     */
    public void BFS2() {
        List<List<V>> res = new ArrayList<>();
        BFS2(1, root, res);
        for (List<V> row : res) {
            for (V value : row) {
                System.out.println("BFS2:" + value);
            }
        }
    }

    private void BFS2(int deep, Node node, List<List<V>> res) {
        if (node == null) return;
        if (res.size() < deep) {
            res.add(new ArrayList<>());
        }
        res.get(deep - 1).add(node.value);
        BFS2(deep + 1, node.left, res);
        BFS2(deep + 1, node.right, res);
    }

    public void BFS3() {
        //详见题解https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/
    }

    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node node) {
        if (node == null) return 0;
        else {
            return (Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1);
        }
    }

    /**
     * https://programmercarl.com/0111.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E6%B7%B1%E5%BA%A6.html#%E9%80%92%E5%BD%92%E6%B3%95
     *
     * @return
     */
    public int getMinDepth() {
        return getMinDepth(root);
    }

    private int getMinDepth(Node node) {
        if (node == null) return 0;

        int leftDepth = getMinDepth(node.left);
        int rightDepth = getMinDepth(node.right);

        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }

        if (node.left != null && node.right == null) {
            return 1 + leftDepth;
        }

        return 1 + (Math.min(leftDepth, rightDepth));
    }
}
