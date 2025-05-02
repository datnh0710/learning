package com.Recursion;

public class Knapsack {
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
        // base checks
        if (capacity <= 0 || currentIndex <= 0 || currentIndex >= profits.length)
            return 0;

        int profit1 = 0;
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn’t process this
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);

    }

    /**
     * DP: top down
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public int solveKnapsack_DP_Top_down(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    /**
     * DP: top down
     *
     * @param dp
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @return
     */
    private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
            return 0;
        }
        if (dp[currentIndex][capacity] != -1) {
            return dp[currentIndex][capacity];
        }
        int profit1 = 0;
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn’t process this
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }


}
