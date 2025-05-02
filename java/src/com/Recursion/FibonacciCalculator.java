package com.Recursion;

import java.math.BigInteger;
import java.util.SplittableRandom;

public class FibonacciCalculator {
    public static void main(String[] args) {
        for (int counter = 0; counter <= 10; counter++)
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));

    }

    private static BigInteger fibonacci(BigInteger number) {
        if (number.equals(BigInteger.ONE) || number.equals(BigInteger.ZERO))
            return number;
        else {
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(BigInteger.TWO)));
        }
    }

    public int fib(int N) {

        if (N == 1) return 1;
        int val = 0;
        int fin = 1;
        int num = 0;
        for (int i = 0; i <= N - 2; i++) {
            num = val + fin;
            val = fin;
            fin = num;

        }
        return num;
    }

    /**
     * Dymamic program // Memoized solution
     * @param n
     * @return
     */
    public int fib_mempo(int n){
        int[] arr = new int[n+1];
        return fib(n,arr);
    }

    /**
     * Dymamic program // Memoized solution
     *
     * @param number
     * @param memo
     * @return
     */
    public int fib(int number, int[] memo) {
        int res = 0;
        if (memo[number] != 0)
            return memo[number];
        if (number == 1 || number == 0)
            res = 1;
        else
            res = fib(number - 1, memo) + fib(number - 2, memo);
        memo[number] = res;
        return res;
    }

    /**
     * Dymamic program // Buttom Up
     * @param n
     * @return
     */
    public int fib_buttom_up(int n) {

        if (n == 1 || n == 2)
            return 1;
        int[] buttom_up = new int[n + 1];
        buttom_up[0] = 1;
        buttom_up[1] = 1;
        for (int i = 2; i < n; i++) {
            buttom_up[i] = buttom_up[i - 1] + buttom_up[i - 2];
        }

        return buttom_up[n];
    }
}
