package com.leetcode;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.printf("%d", trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        if (n <= 4)
            return 0;
        int count = 0;
        while (n >= 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}
