package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {
    public static void main(String[] args) {
        String a = "abc";
        String b = "ahbgdc";
        System.out.printf("%b", isSubsequence1(a, b));
    }

    public static boolean isSubsequence(String s, String t) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    count++;
                } else {
                    map.put(c, 0);
                }
            }
            if (i < t.length()) {
                char c = t.charAt(i);
                if (map.containsKey(c)) {
                    count++;
                } else {
                    map.put(c, 0);
                }
            }
        }
        return count == s.length();
    }

    public static boolean isSubsequence1(String s, String t) {
        if (t.length() == 0 && s.length() == 0 || s.length() == 0)
            return true;
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        int j = 0;
        for (int i = 0; i < chT.length; i++) {
            if (j < chS.length && chT[i] == chS[j] ) {
                j++;
            }
        }

        return j >= s.length();

    }
}
