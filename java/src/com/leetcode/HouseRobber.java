package com.leetcode;

public class HouseRobber {
    public static void main(String[] args) {

        int[] arr = {2, 1, 1, 2};
        System.out.printf("%d", rob(arr));

    }

    static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] buttom_up = new int[n + 2];
        buttom_up[0] = nums[0];
        for (int i = n - 1; i >= 0; i--) {
            buttom_up[i] = Math.max(buttom_up[i + 1], buttom_up[i + 2] + nums[i]);
        }
        return buttom_up[0];
    }
    
}
