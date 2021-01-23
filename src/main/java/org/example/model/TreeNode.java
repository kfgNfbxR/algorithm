package org.example.model;

/**
 * 树节点
 *
 * @param <E> 元素类型
 * @author mouxh 2021/1/22 13:36
 */
public class TreeNode<E> {

    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;
    private E element;

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public static <E> TreeNode<E> newNode(E element) {
        TreeNode<E> treeNode = new TreeNode<>();
        treeNode.element = element;
        return treeNode;
    }

}
