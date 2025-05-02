package com.leetcode;

import com.Generic.List;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA.next == null || headB.next == null) {
            return null;
        }

        Set<ListNode> setA = new HashSet<ListNode>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) return headB;
            setA.add(headB);
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA.next == null || headB.next == null) {
            return null;
        }
        ListNode curr1 = headA;
        ListNode curr2 = null;
        while (curr1 != null) {
            curr2 = headB;
            while (curr2 != null) {
                if (curr1 == curr2)
                    return curr1;
                curr2 = curr2.next;
            }
            curr1 = curr1.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode res = null;
        ListNode curr1 = headA;
        while (curr1 != null) {
            curr1.val = -curr1.val;
            curr1 = curr1.next;
        }

        curr1 = headB;
        boolean flag = true;
        while (curr1 != null) {
            if (curr1.val < 0) {
                res = curr1;
                break;
            }

            curr1 = curr1.next;
        }
        curr1 = headA;
        while (curr1 != null) {
            curr1.val = -curr1.val;
            curr1 = curr1.next;
        }


        return res;
    }
}
