package com.leetcode;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {-1,-2};
        rotate(arr, 2);

    }

    public static void rotate(int[] nums, int k) {
        if (k == 0)
            return;
        while (k > 0) {
            rotation(nums);
            k--;

        }
    }

    public static void rotation(int[] nums) {
        int key = nums[nums.length - 1];
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[i] = key;
    }
}
