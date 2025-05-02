package com.leetcode;

public class CoinChange {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0)
            return -1;
        int len = coins.length - 1;
        int[] dp = new int[len];
        dp[0] = coins[coins.length - 1];
        int i = 0;
        while (amount >= 0 && i <=len) {

        }

        return -1;
    }
}
