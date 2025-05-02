package com.leetcode;

public class UglyNumberII {
    public static void main(String[] args) {

        System.out.printf("%d", nthUglyNumber(1));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int least = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (least == dp[i2] * 2)
                i2++;
            if (least == dp[i3] * 3)
                i3++;
            if (least == dp[i5] * 5)
                i5++;
            dp[i] = least;
        }
        return dp[n - 1];
    }


}
