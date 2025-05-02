package com.leetcode;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {-1, 0};
        System.out.printf("%n%s", Arrays.toString(twoSum(arr, -1)));

    }

    static int[] twoSum(int[] numbers, int target) {
        int midIndex = (numbers.length - 1) / 2;
        int i = 0, j = 0;
        if (numbers[numbers.length - 1] <= target || numbers[numbers.length - 1] >= target) {
            j = numbers.length - 1;
        } else if (numbers[midIndex] <= target) {
            j = midIndex;
        } else {
            i = midIndex + 1;
        }
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i + 1, j + 1};
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{0, 0};
    }
}
