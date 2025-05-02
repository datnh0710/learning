package com.leetcode;

import com.array.Array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.printf("%s", Arrays.toString(arr));
    }

    static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            i++;
        }
    }
}
