package org.example;

import org.example.model.TreeNode;

/**
 * 二叉树工具
 *
 * @author mouxh 2021/1/22 13:52
 */
public class TreeUtils {

    /**
     * 深度优先遍历
     * 广度优先
     * <p>
     * 时间复杂度O(log2n)
     *
     * @param root 根节点
     * @param <E>  元素类型
     */
    public static  <E> void depthFirst(TreeNode<E> root, MockLinkedList<E> mockLinkedList) {
        if (root == null) {
            return;
        }

        /**
         * 左节点
         */
        TreeNode<E> leftChild = root.getLeftChild();
        if (leftChild != null) {
            depthFirst(leftChild, mockLinkedList);
        }
        mockLinkedList.add(root.getElement());
        /**
         * 右节点
         */
        TreeNode<E> rightChild = root.getRightChild();
        if (rightChild != null) {
            depthFirst(rightChild, mockLinkedList);
        }
    }

    /**
     * 广度优先
     * <p>
     * 时间空间复杂度O(log2n)
     *
     * @param root           root
     * @param mockLinkedList mockLinkedList
     * @param <E>            e
     */
    public static  <E> void breadthFirst(TreeNode<E> root, MockLinkedList<E> mockLinkedList) {
        if (root == null) {
            return;
        }

        /**
         * 将当前节点压入栈
         */
        MockLinkedList<TreeNode<E>> queue = new MockLinkedList<>();
        queue.add(root);
        do {
            /**
             * 从栈弹出元素并处理
             */
            mockLinkedList.add(queue.remove(0).getElement());
            TreeNode<E> leftChild = root.getLeftChild();
            /**
             * 左节点压入栈
             */
            if (leftChild != null) {
                queue.add(leftChild);
            }
            TreeNode<E> rightChild = root.getRightChild();
            /**
             * 右节点压入栈
             */
            if (rightChild != null) {
                queue.add(rightChild);
            }
        } while (!queue.isEmpty());
    }

    /**
     * 层序打印树
     *
     * @param root 更节点
     * @param <E>  元素类型
     */
    public <E> void breadthPrint(TreeNode<E> root) {

    }
}
