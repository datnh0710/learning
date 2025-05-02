package com.leetcode;

public class RangeSumQueryImmutable {
    private final int[] arr;

    public RangeSumQueryImmutable(int[] nums) {
//        arr = new int[nums.length];
//        System.arraycopy(nums, 0, arr, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.arr = nums;
    }


    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += arr[k];
//        }
        if (i == 0)
            return arr[j];
        return arr[j] - arr[i-1];
    }
}
