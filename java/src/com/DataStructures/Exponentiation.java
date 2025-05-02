package com.DataStructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.printf("%2d", pow(2, 5));

    }

    /**
     * pow(x,n) = x ^ n
     *
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (isEven(n)) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }

    }

    private static boolean isEven(long n) {
        if (n % 2 == 0)
            return true;
        return false;
    }
}
