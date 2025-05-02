package com.leetcode;


import java.util.ArrayList;

/**
 * @author datnh0710
 * @created 01/12/2021 - 10:41 PM
 * @packege com.leetcode
 * @project java
 */
public class RemoveZeroSumSublists {
    public static void main(String[] args) {

    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode lst = head;
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (lst.next != null) {
            sum += lst.val;
            if (sum > 0) {
                arr.add(lst.val);
            }
            lst = lst.next;

        }
        lst = null;
        ListNode reHead = null;
        if (arr.size() > 0) {
            reHead = new ListNode(arr.get(0));
            reHead.next = lst;
        }

        for (int i = 1; i < arr.size(); i++) {
            ListNode tmp = new ListNode(arr.get(i));
            lst.next = tmp;
            lst = lst.next;
        }
        return reHead;

    }
}
