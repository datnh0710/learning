package com.leetcode;

import java.util.*;

/**
 * @author datnh0710
 * @created 06/11/2023 - 3:32 PM
 * @packege com.leetcode
 * @project java
 */
public class ArrayRankTransform {

    public static void main(String[] args) {
        int[] arr = new int[]{10,10,10};
        arrayRankTransform(arr);
    }

    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] tmp = arr.clone();
        Arrays.sort(arr);
        int rank = 1;
        int pre = arr[0];
        for (int num : arr){
            if (pre != num){
                rank++;
            }
            map.putIfAbsent(num,rank);
            pre = num;
        }

        for (int i = 0; i < arr.length; i++) {

            tmp[i] = map.get(tmp[i]);


        }


        return tmp;
    }
}
