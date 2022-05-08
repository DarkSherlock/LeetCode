package com.liang.tind.leetcode.datastructrue


/**
 * @author: lonnie.liang
 * date: 2022/05/07 23:02
 */
class AVLTree(var root: AVLNode?) {


    fun add(node: AVLNode?) {
        if (root == null) {
            root = node
        } else {
            root?.add(node)
        }
    }

    //中序遍历
    fun infixOrder() {
        if (root == null) {
            println("该二叉树为空")
        } else {
            root?.infixOrder()
        }
    }

    //查找结点
    fun search(value: Int): AVLNode? {
        if (root == null) {
            println("该二叉树为空")
            return null
        }
        return root?.search(value)
    }

    //树的高度
    val height: Int
        get() = if (root == null) {
            0
        } else root!!.height

    class AVLNode(var value: Int) {
        private var left: AVLNode? = null
        private var right: AVLNode? = null


        override fun toString(): String {
            return "BSTNode [value=$value]"
        }

        /**
         * 向二叉排序树添加结点
         *
         * @param node
         */
        fun add(node: AVLNode?) {
            if (node == null) {
                return
            }
            if (node.value < value) {
                if (left == null) {
                    left = node
                } else {
                    left!!.add(node)
                }
            } else {
                if (right == null) {
                    right = node
                } else {
                    right!!.add(node)
                }
            }

            //当添加完一个结点后，如果：（右子树的高度-左子树的高度）>1，左旋转
            if (rightHeight - leftHeight > 1) {
                //如果它的右子树的左子树高度大于它的左子树高度，双旋转(RL)
                if (right != null && right!!.leftHeight > leftHeight) {
                    //先对这个结点的右节点进行右旋转
                    right!!.rightRotate()
                }
                //再对当前结点进行左旋转即可。
                leftRotate()//RR
            } else if (leftHeight - rightHeight > 1) {
                //如果它的左子树的右子树高度大于它的右子树高度，双旋转（LR）
                // left!!.rightHeight > rightHeight 在leftHeight - rightHeight > 1的前提下
                // 证明目前已经是左边的深度比右边大，如果 left!!.rightHeight（2） > rightHeight（1）即表示目前是插入在失衡节点
                // 的左孩子的右子树 https://www.cxyxiaowu.com/1663.html
                //e.g:      A
                //         /\
                //        B  C
                //       /\
                //      D E
                //       /
                //      F
                // 插入F后导致A失衡，A的leftHeight - rightHeight > 1， 并且 left.rightHeight(E的深度为2) > rightHeight（C的深度为1）
                if (left != null && left!!.rightHeight > rightHeight) {
                    //先对这个结点的左节点进行左旋转
                    left!!.leftRotate()
                }
                //再对当前结点进行右旋转即可。
                rightRotate()//LL
            } else {
                return
            }
        }

        //中序遍历
        fun infixOrder() {
            if (left != null) {
                left!!.infixOrder()
            }
            println(this)
            if (left != null) {
                right!!.infixOrder()
            }
        }

        //查找要删除结点
        fun search(value: Int): AVLNode? {
            if (this.value == value) {
                return this
            }
            //左子树查找
            return if (value < this.value) {
                if (left == null) {
                    null
                } else {
                    left!!.search(value)
                }
            } else {
                if (right == null) {
                    null
                } else {
                    right!!.search(value)
                }
            }
        }//妙

        //求该结点的高度
        val height: Int
            get() = Math.max(
                if (left == null) 0 else left!!.height,
                if (right == null) 0 else right!!.height
            ) + 1 //妙

        //左节点的高度
        val leftHeight: Int
            get() = if (left == null) {
                0
            } else {
                left!!.height
            }

        //右节点的高度
        val rightHeight: Int
            get() = if (right == null) {
                0
            } else {
                right!!.height
            }

        //左旋 https://blog.csdn.net/qq_37934101/article/details/81160254\
        fun leftRotate() {
            //创建新的左子树
            //创建新的结点，以当前根结点的值
            val node = AVLNode(value)
            //把新的结点的左子树设置成当前结点的左子树
            node.left = left
            //把新的结点的右子树设置成带你过去结点的右子树的左子树
            node.right = right!!.left

            //创建新的根结点
            //把当前结点的值替换成右子结点的值
            value = right!!.value

            //（根结点+右子树）
            //把当前结点的右子树设置成当前结点右子树的右子树
            right = right!!.right

            //(根结点+右子树+左子树)
            //把当前结点的左子树(左子结点)设置成新的结点
            left = node
        }

        //右旋
        fun rightRotate() {
            //创建新的右子树
            //创建新的结点，以当前根结点的值
            val node = AVLNode(value)
            //把新的结点的右子树设置成当前结点的右子树
            node.right = right
            //把新的结点的左子树设置成带你过去结点的左子树的右子树
            node.left = left!!.right

            //创建新的根结点
            //把当前结点的值替换成右子结点的值
            value = left!!.value

            //（根结点+左子树）
            //把当前结点的左子树设置成当前结点左子树的左子树
            left = left!!.left

            //(根结点+右子树+左子树)
            //把当前结点的左子树(左子结点)设置成新的结点
            right = node
        }
    }
}