package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author datnh0710
 * @created 20/04/2022 - 12:19 AM
 * @packege com.leetcode
 * @project java
 */
public class Maximum_Erasure_Value {
    public int maximumUniqueSubarray(int[] nums) {
        int max =0;
        int start =0;
        int end = 0;
        int tmp_max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(end < nums.length){
            int tmp = nums[end];
            if(map.containsKey(nums[end])){
                int start_value = nums[start++];
                tmp_max = tmp_max - start_value;
                map.remove(start_value);

            }else{
                tmp_max += tmp;
                map.put(nums[end],end);
                max = Math.max(max, tmp_max);
                end++;
            }

        }
        return max;

    }
}
