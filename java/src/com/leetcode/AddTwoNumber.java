package com.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
//        ListNode n4 = new ListNode(9);
//        ListNode n5 = new ListNode(9);
//        ListNode n6 = new ListNode(9);
//        ListNode n7 = new ListNode(9);
//        ListNode n8 = new ListNode(9);
//        ListNode n9 = new ListNode(9);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next=n5;
//        n5.next= n6;
//        n6.next=n7;
//        n7.next= n8;
//        n8.next=n9;

        ListNode n = new ListNode(9);

//        System.out.printf("%n%d", getSumNode(head));
//        System.out.println(addTwoNumbers(head, n));

        System.out.println(mergeTwoLists(head, n));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    public static int getSumNode(ListNode listNode) {
        ListNode node = listNode;
        int i = 1;
        int sum = 0;
        while (node != null) {
            System.out.printf("%n%d", node.val);
            sum += node.val * i;
            i *= 10;
            node = node.next;
        }
        return sum;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> sortList = new ArrayList<>();
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = null;
        while (p != null ) {

                sortList.add(p.val);





             p = p.next;
        }
        while (q != null) {


                sortList.add(q.val);



                q = q.next;
        }
        Integer[] arr = new Integer[sortList.size()];
        arr = sortList.toArray(arr);
        Arrays.sort(arr);
        ListNode head = new ListNode(arr[0]);
        curr = head;
        for (int i = 1; i < arr.length; i++) {

            ListNode tmp = new ListNode(arr[i]);
            curr.next = tmp;
            curr = curr.next;
        }
        return head;

    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode cur = merged;

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : Integer.MAX_VALUE;
            int val2 = (l2 != null) ? l2.val : Integer.MAX_VALUE;

            if (val1 < val2) {
                cur.next = new ListNode(val1);
                l1 = l1.next;
            }
            else {
                cur.next = new ListNode(val2);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return merged.next;

    }
}
