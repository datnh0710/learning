package com.leetcode;

import java.util.Arrays;

/**
 * @author datnh0710
 * @created 13/11/2023 - 11:18 PM
 * @packege com.leetcode
 * @project java
 */
public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff){
                return false;
            }
        }

        return true;
    }
}
