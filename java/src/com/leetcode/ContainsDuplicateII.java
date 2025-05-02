package com.leetcode;

import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3};
        System.out.printf("%b%n", containsNearbyDuplicate(arr, 2));
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1)
            return false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            if (hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i])) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
            i++;
        }
        return false;
    }
}
