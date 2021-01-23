package org.example.model;

import java.util.Objects;

/**
 * 链表节点
 *
 * @param <E> 元素类型
 * @author mouxh 2021/1/22 13:43
 */
public class LinkedNode<E> {

    private E element;
    private LinkedNode<E> nextNode;
    private LinkedNode<E> preNode;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public LinkedNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedNode<E> getPreNode() {
        return preNode;
    }

    public void setPreNode(LinkedNode<E> preNode) {
        this.preNode = preNode;
    }

    @Override
    public String toString() {
        return Objects.toString(element);
    }
}
