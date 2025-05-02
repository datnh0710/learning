package com.leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {3, 0, -2, -1, 1, 2};
        threeSum(arr);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 0)
            return new ArrayList<>();
        if (nums.length == 1 && nums[0] == 0) {
            return new ArrayList<>(nums[0]);
        }

        List<List<Integer>> lst = new ArrayList<>();
//        Set<List<Integer>> lst = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            int key = nums[i];
            int j = i + 1;
            while (j < nums.length) {
                int keyNext = nums[j];
                int lastValue = findValue(-key - keyNext, j + 1, nums);
                if (lastValue != Integer.MAX_VALUE) {
//                    lst.add(Arrays.asList(key, keyNext, lastValue));
                    List<Integer> tmp = new ArrayList<>();
                    if (!set.contains(key) || !set.contains(keyNext) || !set.contains(lastValue)){
                        tmp.add(key);
                        tmp.add(keyNext);
                        tmp.add(lastValue);
                        set.add(key);
                        set.add(keyNext);
                        set.add(lastValue);
                        lst.add(tmp);
                    }


                }

                j++;

            }
            i++;

        }


        return new ArrayList<>(lst);

    }

    public static int findValue(int value, int index, int[] nums) {
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == value) {
                return value;
            }


        }
        return Integer.MAX_VALUE;
    }

}
