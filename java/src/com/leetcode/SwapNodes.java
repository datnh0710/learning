package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodes {
    public static void main(String[] args) {


//        ListNode d = new ListNode(5);
//        ListNode c = new ListNode(4, d);
//        ListNode b = new ListNode(3, c);
//        ListNode a = new ListNode(2, b);
        ListNode a = new ListNode(2);
        ListNode head = new ListNode(1, a);

        swapNodes(head, 1);

    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null)
            return head;
        List<Integer> arr = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            arr.add(current.val);
            current = current.next;
        }
        int len = arr.size();
        if (k > len)
            return head;
        else {
            int tmp = arr.get(k - 1);
            arr.set(k - 1, arr.get(len - k));
            arr.set(len - k, tmp);
        }
        current = head;
        int i = 0;
        while (current != null) {
            current.val = arr.get(i);
            current = current.next;
            i++;
        }

        return head;
    }
}
