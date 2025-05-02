package com.leetcode;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.printf("%b", isPowerOfThree1(91));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        n = Math.abs(n);

        while (n != 1) {
            if (n % 3 != 0)
                return false;
            n /= 3;
        }
        return true;
    }


    public static boolean isPowerOfThree1(int n) {
        double res = Math.log10(n) / Math.log10(3);
        return (int)res == res;
    }
}
