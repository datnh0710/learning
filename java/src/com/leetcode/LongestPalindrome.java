package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String a = "aa";
        System.out.printf("%s%n", longestPalindrome(a));
        System.out.printf("%s%n", longestPalindrome1(a));

    }

    public static int longestPalindrome(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        boolean flag = false;
        for (Integer c : map.values()) {
            if (c % 2 != 0) {
                count += c - 1;
                flag = true;
            } else {
                count += c;
            }
        }
        return flag == true ? count + 1 : count;
    }

    public static int longestPalindrome1(String s) {
        int[] arr = new int[128];
        int length = 0;
        for (char c : s.toCharArray()) {
            if (++arr[c] == 2) {
                length += 2;
                arr[c] = 0;
            }
        }
        return (length == s.length()) ? length : length + 1;
    }
}
