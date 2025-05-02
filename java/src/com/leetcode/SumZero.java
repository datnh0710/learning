package com.leetcode;

public class SumZero {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sumZero(n));
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = i + 1;
                } else {
                    arr[i] = -arr[i - 1];
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (i % 2 == 0) {
                    arr[i] = i + 1;
                } else {
                    arr[i] = -arr[i - 1];
                }
            }
            arr[n - 1] = 0;
        }
        return arr;
    }
}
