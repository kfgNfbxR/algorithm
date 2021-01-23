package org.example;

import org.example.model.LinkedNode;

import java.util.*;

/**
 * 链表实现
 *
 * @author mouxh 2021/1/22 13:47
 */
public class MockLinkedList<E> implements List<E>, Iterable<E> {

    /**
     * 头节点
     */
    private LinkedNode<E> head;
    /**
     * 文节点
     */
    private LinkedNode<E> tail;
    /**
     * 链表大小
     */
    private int size;
    /**
     * 并发修改控制
     */
    private transient int modCount;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == tail) && head == null;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        if (isEmpty()) {
            return false;
        }
        for (LinkedNode<E> eNode = head; eNode != null; eNode = eNode.getNextNode()) {
            if (Objects.equals(eNode.getElement(), o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MockListIterator<>(head);
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        Object[] objects = new Object[size];
        for (LinkedNode<E> eNode = head; eNode != null; eNode = eNode.getNextNode()) {
            objects[i++] = eNode;
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        size++;
        if (head == null) {
            head = new LinkedNode<>();
            head.setElement(e);
            tail = head;
            return true;
        }
        LinkedNode<E> node = new LinkedNode<>();
        node.setElement(e);
        tail.setNextNode(node);
        tail = node;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class MockListIterator<E> implements Iterator<E> {

        private LinkedNode<E> crtNode;

        public MockListIterator(LinkedNode<E> crtNode) {
            this.crtNode = crtNode;
        }

        @Override
        public boolean hasNext() {
            return crtNode != null;
        }

        @Override
        public E next() {
            LinkedNode<E> node = crtNode;
            crtNode = node.getNextNode();
            return node.getElement();
        }

        @Override
        public void remove() {

        }
    }
}
