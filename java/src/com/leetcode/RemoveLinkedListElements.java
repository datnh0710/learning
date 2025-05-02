package com.leetcode;

import com.sun.source.tree.IfTree;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode ahead = new ListNode(2);
        ListNode a = new ListNode(1);
        ahead.next = a;
//        ListNode b = new ListNode(2);
//        a.next = b;
//        ListNode c = new ListNode(2);
//        b.next = c;
//        ListNode d = new ListNode(4);
//        c.next = d;
//        ListNode e = new ListNode(3);
//        d.next = e;

        ;
        ListNode curr = removeElements(ahead, 1);
        while (curr != null) {
            System.out.printf("%d", curr.val);
            curr = curr.next;
        }
    }

    static ListNode removeElements(ListNode head, int val) {
        ListNode currNode = new ListNode(-1);
        currNode.next = head;
        ListNode preNode = currNode;


        while (head != null) {
            if (head.val != val) {
                preNode.next = head;
                preNode = preNode.next;
            }
            head = head.next;
        }
        return currNode.next;
    }

    static ListNode removeElements1(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode currNode = head;
        while (currNode != null && currNode.next != null) {

            if (currNode.next.val == val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }


        }
        return head;
    }
}
