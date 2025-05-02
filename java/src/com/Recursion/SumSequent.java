package com.Recursion;

public class SumSequent {
    public static void main(String[] args) {
        System.out.printf("%d", sum(12345));
        System.out.printf("%d", recur_sum(5));

    }

    private static int sum(int n) {
        if (n == 0)
            return 0;
        else {
            return (n % 10) + sum(n / 10);
        }
    }

    private static int recur_sum(int n) {
        if (n == 0)
            return 0;
        else
            return n + recur_sum(n - 1);
    }
}
