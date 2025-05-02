package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author datnh0710
 * @created 08/11/2023 - 2:30 PM
 * @packege com.leetcode
 * @project java
 */
public class TargetIndices {
    public static void main(String[] args) {

    }

    public static List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                res.add(i);
            }
        }

        return res;

    }
}
