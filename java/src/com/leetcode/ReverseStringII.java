package com.leetcode;

public class ReverseStringII {
    public static void main(String[] args) {
        System.out.printf("%s", reverseStr("abcdefg", 0));
    }

    static String reverseStr(String s, int k) {
        if (s.length() <= 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0;


        while (i < s.length()) {
            int end = (i + k) > arr.length ? arr.length - 1 : i + k - 1;
            swap(arr, i, end);
            i = i + (2 * k);

        }
        return String.copyValueOf(arr);
    }

    static void swap(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }
}
