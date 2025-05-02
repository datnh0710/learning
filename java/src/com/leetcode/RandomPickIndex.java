package com.leetcode;

import java.util.Random;

public class RandomPickIndex {
    int[] nums;
    Random rm;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        rm = new Random();

    }

    public int pick(int target) {
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                count++;
                if (rm.nextInt(count) == 0) {
                    idx = i;
                }
            }

        }
        return idx;
    }
}
