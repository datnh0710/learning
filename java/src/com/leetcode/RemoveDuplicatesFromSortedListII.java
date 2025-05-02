package com.leetcode;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode ahead = new ListNode(0);
        ListNode a = new ListNode(1);
        ahead.next = a;
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(2);
        b.next = c;
        ListNode d = new ListNode(2);
        c.next = d;
        ListNode e = new ListNode(3);
        d.next = e;

        ;
        ListNode curr = deleteDuplicates(ahead);
        while (curr != null) {
            System.out.printf("%d", curr.val);
            curr = curr.next;
        }
    }

    static ListNode deleteDuplicates(ListNode head) {

        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }
}
