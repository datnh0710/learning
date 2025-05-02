package com.leetcode;

public class ReverseString {
    public static void main(String[] args) {
//        char arr[] = {'h', 'e', 'l', 'l', 'o'};
        char arr[] = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(arr);

        System.out.printf("%s", String.copyValueOf(arr));

    }

    static void reverseString(char[] s) {
        if (s.length <= 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < s.length / 2) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
