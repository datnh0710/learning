package com.leetcode;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {0};
        System.out.printf("%d", missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (i + 1);
            sum -= nums[i];
        }
        return sum;
    }

    static int missingNumber1(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
