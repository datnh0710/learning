package com.leetcode;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.printf("%b", isPowerOfTwo(8));
    }

    static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return n>0 && ((n & (n-1))==0);
    }

    public boolean isPowerOfTwo2(int n) {

        while (n > 0)
        {
            if (n == 1) return true;
            else if (n % 2 != 0) return false;
            else n /= 2;
        }
        return false;
    }
}
