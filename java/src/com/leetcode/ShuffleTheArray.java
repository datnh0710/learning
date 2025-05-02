package com.leetcode;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        System.out.printf("%s", shuffle1(nums, 3));
    }

    public static int[] shuffle(int[] nums, int n) {
        if (nums.length == 0)
            return nums;
        int[] arr = new int[nums.length];
        int i = 0;
        int j = n;
        while (i < n) {
            arr[j - n + i] = nums[i];
            arr[j - n + i + 1] = nums[j];
            i++;
            j++;
        }
        return arr;
    }

    public static int[] shuffle1(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int i = 0;
        int j = 0;
        while (i < 2*n) {
            arr[i++] = nums[j];
            arr[i++] = nums[j + n];
            j++;

        }
        return arr;
    }
}
