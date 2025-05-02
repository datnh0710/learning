package com.leetcode;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        System.out.printf("%s", findRestaurant(list1, list2));

    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;


        while (i < list1.length || j < list2.length) {
            if (i < list1.length) {
                if (map.containsKey(list1[i])) {
                    int val1 = map.get(list1[i]) * -1;
                    map.put(list1[i], val1 + i);
                } else {
                    map.put(list1[i], -(i+1));
                }

                i++;
            }
            if (j < list2.length) {
                if (map.containsKey(list2[j])) {
                    int val2 = map.get(list2[j]) * -1;
                    map.put(list2[j], val2 + j);
                } else {
                    map.put(list2[j], -(j+1));
                }

                j++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer val : map.values()) {
            if (val < min && val >= 0)
                min = val;
        }

        for (String s : map.keySet()) {
            int val = map.get(s);
            if (val == min) {
                list.add(s);
            }

        }
        return list.toArray(new String[list.size()]);
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // {name : index}
        int minIndexSum = Integer.MAX_VALUE;


        // Loop through list1, fill the hashMap with list1 items
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // Loop through list2
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) { // Note: time complexity for map.containsKey() is assumed to be O(1) here
                int sum = map.get(list2[i]) + i;

                if (sum < minIndexSum) {
                    minIndexSum = sum;
                    res.clear();
                    res.add(list2[i]);
                } else if (minIndexSum == sum) {
                    res.add(list2[i]);
                }
            }
        }

        String[] ans = res.toArray(new String[res.size()]);
        return ans;
    }
}
