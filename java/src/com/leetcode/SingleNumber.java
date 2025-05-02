package com.leetcode;

import java.util.Hashtable;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] a = {1, 1, 3, 2, 2};
        System.out.printf("%n%d ", singleNumber1(a));

    }

    public static int singleNumber(int[] nums) {
        Hashtable<Integer, Integer> integerHashtable = new Hashtable<>();
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (integerHashtable.containsKey(nums[i])) {
                integerHashtable.put(nums[i], integerHashtable.get(nums[i]) + 1);
                if (index == nums[i]) {
                    index = -1;
                }
            } else {
                integerHashtable.put(nums[i], 1);
                index = nums[i];
            }
        }
//        for (Map.Entry m : integerHashtable.entrySet()) {
//            if ((int) m.getValue() == 1)
//                return (int) m.getKey();
//        }
        return index;
    }
    public static int singleNumber1(int[] nums) {
        int i =0;
        for (Integer num:nums) {
            i^=num;
        }
        return i;

    }
}
