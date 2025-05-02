package com.leetcode;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.printf("%s", twoSum1(nums, target).toString());
//        System.out.println(reverseArray(nums));


    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            int value = target - nums[i];
            int j;
            for (j = i + 1; j < nums.length; j++) {
                if (value == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }

        }
        System.out.printf("%d %s", res[0], res[1]);
        return res;
    }

    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value))
                return new int[]{map.get(value), i};
            map.put(nums[i], i);

        }
        return new int[]{};
    }

    static int[] reverseArray(int[] a) {
        int[] res = new int[a.length];
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            res[j] = a[i];
            ++j;
        }
        return res;

    }
}
