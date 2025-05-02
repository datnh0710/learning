package com.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this(0, null );
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }
}
