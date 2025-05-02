package com.Recursion;

public class UnboundedKnapsack {
    public static void main(String[] args) {

    }

    /**
     * simple solution
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    /**
     * simple solution
     *
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @return
     */
    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || currentIndex >= profits.length || currentIndex < 0)
            return 0;
        int profit1 = 0;
        // recursive call after choosing the items at the currentIndex, note that we recursive call on all
        // items as we did not increment currentIndex
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);
        }
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

    private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int n = profits.length;
        // populate the capacity=0 columns
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        // process all sub-arrays for all capacities
        for (int i = 0; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i][c - weights[i]];
                }
                if (i > 0) {
                    profit2 = dp[i - 1][c];
                }
                dp[i][c] = profit1 > profit2 ? profit1 : profit2;
            }

        }
        return dp[n-1][capacity];

    }


}
