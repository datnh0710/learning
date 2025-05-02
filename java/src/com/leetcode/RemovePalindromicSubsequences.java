package com.leetcode;

/**
 * @author datnh0710
 * @created 27/05/2022 - 10:41 AM
 * @packege com.leetcode
 * @project java
 */
public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        System.out.printf("Test: " + removePalindromeSub("abaa"));
    }

    public static int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s) ? 1 : 2;

    }
}
