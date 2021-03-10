package org.example;

import org.example.model.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author mouxh 2021/3/9 13:58
 */
public class IsSubTree {

    public static void main(String[] args) {

    }

    private boolean isSubTree(TreeNode<Integer> treeNode, TreeNode<Integer> subTree) {

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(treeNode);

        do {
            TreeNode<Integer> treeNode1 = queue.poll();
            if (isSubTree0(treeNode1, subTree)) {
                return true;
            }
            TreeNode<Integer> leftChild = treeNode1.getLeftChild();
            if (leftChild != null) {
                queue.add(leftChild);
            }
            TreeNode<Integer> rightChild = treeNode1.getRightChild();
            if (rightChild != null) {
                queue.add(rightChild);
            }
        } while (!queue.isEmpty());
        return false;
    }

    private boolean isSubTree0(TreeNode<Integer> treeNode, TreeNode<Integer> subTree) {
        return Objects.equals(treeNode.getElement(), subTree.getElement())
                && isSubTree0(treeNode.getLeftChild(), subTree.getLeftChild())
                && isSubTree0(treeNode.getRightChild(), subTree.getRightChild());
    }

}
