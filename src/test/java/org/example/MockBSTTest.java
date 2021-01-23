package org.example;

import org.example.model.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author mouxh 2021/1/22 13:51
 */
public class MockBSTTest {

    @Test
    public void test1() {
        TreeNode<Integer> root = TreeNode.newNode(4);
        TreeNode<Integer> leftNode = TreeNode.newNode(2);
        root.setLeftChild(leftNode);
        leftNode.setLeftChild(TreeNode.newNode(1));
        leftNode.setRightChild(TreeNode.newNode(3));
        MockLinkedList<Integer> linkedList = new MockLinkedList<>();
        TreeUtils.breadthFirst(root, linkedList);
        System.out.println(Arrays.toString(linkedList.toArray()));
    }

}
