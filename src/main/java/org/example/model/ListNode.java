package org.example.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str =  "val=" + val;
        if (next != null) {
            str = str + "," + next.toString();
        }
        return str;
    }
}