package com.Recursion;

public class DynamicProgramming {
    public static void main(String[] args) {

    }

    /**
     * DP: Memoization (Top Down)
     *
     * @param n
     * @param memo
     * @return
     */
    private static int fib(int n, int[] memo) {
        int res = 0;
        if (n <= 1)
            return 1;
        if (memo[n] != -1) {
            return memo[n];
        } else {
            res = fib(n - 1, memo) + fib(n - 2, memo);
        }
        memo[n] = res;
        return res;
    }

    /**
     * DP: Memoization (Top Down)
     *
     * @param n
     * @return
     */
    private static int fib(int n) {
        int[] memo = new int[n + 1];
        return fib(n, memo);
    }

    /**
     * DP: Tabulation (Bottom Up)
     *
     * @param n
     * @return
     */
    private static int fib_buttom_up(int n) {

        int[] buttom_up = new int[n + 1];
        buttom_up[0] = 1;
        buttom_up[1] = 1;
        for (int i = 2; i < n; i++) {
            buttom_up[i] = fib_buttom_up(i - 1) + fib(i - 2);
        }
        return buttom_up[n];
    }


}
