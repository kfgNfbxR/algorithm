package org.example;

import org.example.model.LinkedNode;
import org.example.model.TreeNode;

/**
 * @author mouxh 2021/3/9 15:50
 */
public class TreeToList {

    public static void main(String[] args) {

        TreeNode<Integer> rootNode = TreeNode.newNode(2);
        rootNode.setLeftChild(TreeNode.newNode(1));
        rootNode.setRightChild(TreeNode.newNode(3));

        LinkedNode<Integer> node = treeToList(rootNode);
        while (node.getNextNode() != null) {
            System.out.println(node.getElement());
            node = node.getNextNode();
        }

    }

    private static LinkedNode<Integer> treeToList(TreeNode<Integer> treeNode) {

        LinkedNode<Integer> head = null;

        if (treeNode == null) {
            return head;
        }

        TreeNode<Integer> leftChild = treeNode.getLeftChild();
        TreeNode<Integer> rightChild = treeNode.getRightChild();

        LinkedNode<Integer> leftNode = treeToList(leftChild);
        if (leftNode != null) {
            head = leftNode;
        }

        LinkedNode<Integer> rootNode = new LinkedNode<>();
        rootNode.setElement(treeNode.getElement());
        if (head != null) {
            rootNode.setPreNode(head);
            head.setNextNode(rootNode);
        } else {
            head = rootNode;
        }

        LinkedNode<Integer> rightNode = treeToList(rightChild);
        if (rightNode != null) {
            rootNode.setNextNode(rightNode);
            rightNode.setPreNode(rootNode);
        }

        return head;
    }

    private static LinkedNode<Integer> treeToList(TreeNode<Integer> treeNode, LinkedNode<Integer> preNode) {
        TreeNode<Integer> leftChild = treeNode.getLeftChild();
        TreeNode<Integer> rightChild = treeNode.getRightChild();

        LinkedNode<Integer> leftNode = null;
        if (leftChild != null) {
            leftNode = treeToList(leftChild, preNode);
            leftNode.setPreNode(preNode);
        }

        LinkedNode<Integer> rootNode = new LinkedNode<>();
        rootNode.setElement(treeNode.getElement());
        rootNode.setPreNode(leftNode == null ? leftNode : preNode);

        if (rightChild != null) {
            LinkedNode<Integer> rightNode = treeToList(treeNode, rootNode);
        }

        return rootNode;
    }



}

