package com.leetcode;

public class PowXN {
    public static void main(String[] args) {
        System.out.printf("%12.12f", myPow(2, 10));

    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        if (isEven(n)) {
//            if (n > 0)
//                return myPow(x * x, n / 2);
//            else
//                return myPow(1 / (x * x), n / 2);
            return myPow(x * x, n / 2);
        } else {
            if (n > 0)
                return myPow(x * x, n / 2) * x;
            else
                return myPow(x * x, n / 2) * (1 / x);
//            return myPow(x * x, n / 2) * 1 / x;
        }

    }

    private static boolean isEven(double x) {
        if (x % 2 == 0)
            return true;
        return false;
    }
}
