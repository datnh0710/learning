package com.leetcode;

/**
 * @author datnh0710
 * @created 14/11/2023 - 3:54 PM
 * @packege com.leetcode
 * @project java
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (nums[i] == nums[j]) res++;
                
            }
        }

        return res;

    }
}
