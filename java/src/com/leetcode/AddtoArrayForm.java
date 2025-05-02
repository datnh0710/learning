package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddtoArrayForm {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4};
        int k = 181;
        System.out.printf("%s", addtoArrayForm(arr, k).toString());
        String s = "";



    }

    static List<Integer> addtoArrayForm(int[] arr, int k) {
        if (arr.length < 1)
            return null;
        List<Integer> list = new ArrayList<>();

        int i = arr.length - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || k != 0) {
            sum = carry;

            if (i >= 0) {
                sum += arr[i--];
            }
            if (k != 0) {
                sum += k % 10;
                k /= 10;
            }
            carry = sum / 10;

            list.add(sum % 10);


        }
        if (carry == 1) {
            list.add(carry);
        }
        Collections.reverse(list);
        return list;

    }
}
