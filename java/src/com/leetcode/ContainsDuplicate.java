package com.leetcode;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 2, 2};
        System.out.printf("%b%n", containsDuplicate(arr));
    }

    static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> hashtable = new Hashtable<>();
        int i = 0;
        while (i < nums.length) {
            if (hashtable.containsKey(nums[i]))
                return true;
            hashtable.put(nums[i++], 0);
        }

        return false;
    }

    static boolean containsDuplicate1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> integerSet = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (integerSet.contains(nums[i]))
                return true;
            integerSet.add(nums[i++]);
        }

        return false;
    }
}
