package com.leetcode;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.printf("%b", isPerfectSquare(808201));

    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 2;
        long right = (num / 2) + 1;
        while (left < right) {
            long mid = left + ((right - left) / 2);
            double val = mid * mid;
            if (val == num)
                return true;
            if (val > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
