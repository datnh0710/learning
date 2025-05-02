package com.leetcode;


public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }

    static void deleteNode(ListNode node) {
        if (node == null)
            return;
        ListNode prev = node;
        while (node.next != null) {

            node.val = node.next.val;
            prev = node;
            node = node.next;

        }
        prev.next = null;


    }

    static void deleteNode1(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
