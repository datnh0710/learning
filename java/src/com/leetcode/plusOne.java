package com.leetcode;


public class plusOne {
    public static void main(String[] args) {
        int[] a1 = {4};
        int[] a2 = {9};
        int[] a3 = {9, 9};
        int[] a4 = {9, 9, 9};
        int[] a5 = {8, 9, 9};
        int[] a6 = {1, 2, 3};

//        System.out.printf("%n%s ", plusOne(a1).toString());
//        System.out.printf("%n%s", plusOne(a2).toString());
//        System.out.printf("%n%s", plusOne(a3).toString());
//        System.out.printf("%n%s", plusOne(a4).toString());
        System.out.printf("%n%s", plusOne1(a5).toString());
//        System.out.printf("%n%s", plusOne(a6).toString());
    }

    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int remain = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (remain == 1) {
                remain = 0;
            }
            if (digits[i] + 1 == 10) {
                remain = 1;
                res[i + 1] = 0;
                digits[i] = 0;
            } else {
                res[i + 1] = digits[i] + 1;
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (remain == 1) {
            res[0] = 1;
        } else {
            res = digits;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d", res[i]);
        }
        return res;

    }

    public static int[] plusOne1(int[] digits) {
        int remain = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tem = digits[i] + 1;
            if (tem == 10) {
                digits[i] = 0;
                remain = 1;
            } else {
                digits[i] += 1;
                remain =0;
                break;
            }
        }
        if (remain == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = remain;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }else{
            return digits;
        }
    }



}
