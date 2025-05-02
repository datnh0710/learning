package com.leetcode;

public class RemoveDuplicatesFromSortedList {
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

        deleteDuplicates(ahead);
        ListNode curr = ahead;
        while (curr != null) {
            System.out.printf("%d", curr.val);
            curr = curr.next;
        }

    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode key = head;
        ListNode current = key.next;


        while (key != null) {

            if (current == null || key.val != current.val) {
                key.next = current;
                key = current;
            }
            if (current != null) {
                current = current.next;
            }


        }
        return head;
    }

    static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;


        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
