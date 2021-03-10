package org.example;

import org.example.model.ListNode;

/**
 * @author mouxh 2021/3/8 16:43
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        int i = 1;
        ListNode listNode = new ListNode(i++);
        ListNode listNode1 = new ListNode(i++);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(i++);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(i++);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(i++);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(i++);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(i);
        listNode5.next = listNode6;

        System.out.println(listNode);
        ListNode listNode7 = reverse(listNode);
        System.out.println(listNode7);

    }

    private static ListNode reverse(ListNode head) {

        ListNode newHead = null;
        ListNode tmp = null;

        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

}
