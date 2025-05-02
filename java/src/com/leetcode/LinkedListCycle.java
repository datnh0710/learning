package com.leetcode;

public class LinkedListCycle {
    public static void main(String[] args) {
        System.out.printf("%b", hasCycle(null));
    }

    static boolean hasCycle(ListNode head) {
        if (head.next == null)
            return false;
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast)
                return true;
        }
        return false;
    }

    static boolean hasCycle1(ListNode head) {
        if (head.next == null)
            return false;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            if (curr == curr.next.next)
                return true;
        }
        return false;
    }
}
