package com.leetcode;

import java.util.HashMap;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode ahead = new ListNode(1);
//        ListNode a = new ListNode(1);
//        ahead.next = a;
//        ListNode b = new ListNode(2);
//        a.next = b;
//        ListNode c = new ListNode(2);
//        b.next = c;
//        ListNode d = new ListNode(1);
//        c.next = d;
//        ListNode e = new ListNode(1);
//        d.next = e;

        System.out.printf("%b", isPalindrome(ahead));

    }

    static boolean isPalindrome(ListNode head) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (head != null) {
            if (hashMap.containsKey(head.val)) {
                hashMap.put(head.val, hashMap.get(head.val) + 1);
            } else {
                hashMap.put(head.val, 1);
            }
            head = head.next;
        }
        int i = 0;
        for (int val : hashMap.values()) {
            if (val % 2 != 0)
                i++;

        }
        return i > 1 ? false : true;
    }
}
