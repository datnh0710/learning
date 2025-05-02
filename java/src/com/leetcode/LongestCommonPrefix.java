package com.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.printf("%n%s", longestCommonPrefix(a));

    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (String s : strs) {
            prefix = cPrefix(prefix,s);
            if (prefix.equals(""))
                break;
        }
        return prefix;
    }

    private static String cPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
