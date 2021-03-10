package org.example;

import org.example.model.ListNode;

import java.util.List;

/**
 * @author mouxh 2021/1/25 10:54
 */
public class 剑指Offer_24_反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(reverseList1(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseList2(head));
    }

    /**
     * 递归实现
     *
     * @param head 头结点
     * @return 新的头结点
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next); // 反转head的下一个节点
        head.next.next = head; //head.next是newHead的尾结点，将head挂到newHead的尾结点后边
        head.next = null; //将head和newHead的尾结点的关系断开
        return newHead;
    }

    /**
     * 循环实现
     *
     * @param head 头结点
     * @return 新的头结点
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null; //定义新链表的头结点
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next; //暂存head的下一个节点
            head.next = newHead; //将head从旧链表上摘下，采用头插法插入到新的链表头
            newHead = head; //将新链表的头指针向前移动
            head = tmp; //head指向旧链表的新的头
        }
        return newHead;
    }

    /**
     * 链表部分反转
     *
     * @param head  head
     * @param start start
     * @param end   end
     * @return node
     */
    public static ListNode reverseList3(ListNode head, int start, int end) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmpHead = head;
        ListNode tmpNewHead = null;
        ListNode tmp = null;
        for (int i = 0; i < end + 1; i++) {
            if (i >= start) {
                tmp = tmpHead.next;
                tmpHead.next = tmpNewHead;
                tmpNewHead = tmpHead;
                tmpHead.next = tmp;
            } else {
                tmpHead = tmpHead.next;
            }
        }
        return null;
    }
}
