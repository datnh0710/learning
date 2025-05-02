package com.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = {-2147483648, -2147483647, 2147483647};
        System.out.printf("%s", summaryRanges(arr));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        } else if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int low = nums[0];
        int fast = nums[0];
        for (int i = 1; i < nums.length; i++) {
            float res = Math.abs(nums[i] - fast);
            if (res == 1) {
                fast = nums[i];
            } else if (res > 1 && low - fast == 0) {
                list.add(String.valueOf(low));
                low = fast = nums[i];
            } else if (res > 1) {
                list.add(low + "->" + fast);
                low = fast = nums[i];

            }
        }
        if (low == fast)
            list.add(String.valueOf(low));
        else
            list.add(low + "->" + fast);
        return list;
    }





}
