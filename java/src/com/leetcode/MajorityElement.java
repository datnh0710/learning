package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        majorityElement(arr);


    }

    public static int majorityElement(int[] nums) {
        int m = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for (Integer key : map.keySet()) {
            int tmpValue = map.get(key);
            if (tmpValue > m)
                return key;

        }
        return -1;

    }
}
