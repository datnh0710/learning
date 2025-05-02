package com.leetcode;

public class LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        System.out.println(findLUSlength(a, b));
    }

    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
