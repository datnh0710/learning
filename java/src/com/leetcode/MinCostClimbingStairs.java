package com.leetcode;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1)
            return cost[0];
        int f1 = cost[0];
        int f2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int f_current = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = f_current;
        }
        return Math.min(f1, f2);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        if (len == 1)
            return cost[0];
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
