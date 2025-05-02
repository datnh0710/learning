package com.leetcode;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode ahead = new ListNode(0);
        ListNode a = new ListNode(1);
        ahead.next = a;
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(2);
        b.next = c;
        ListNode d = new ListNode(3);
        c.next = d;
        ListNode e = new ListNode(3);
        d.next = e;

        reverseList(ahead);

    }

    static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(stack.pop());
        ListNode curr = newHead;
        while (!stack.empty()) {
            ListNode tmp = new ListNode(stack.pop());
            curr.next = tmp;
            curr = curr.next;

        }
        return newHead;

    }

    static ListNode reverseList1(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;

    }
}
