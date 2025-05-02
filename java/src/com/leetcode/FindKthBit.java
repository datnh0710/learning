package com.leetcode;

public class FindKthBit {
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));

    }

    public static char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder();
        str.append('0');
        for (int i = 1; i < n; i++) {
            String tmp = str.toString();
            str.append('1');
            str.append(invert(tmp, i));
        }
        System.out.println("Bit result: " + str.toString());
        return str.charAt(k - 1);
    }

    public static String invert(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars[k - 1] == '0') {
            chars[k - 1] = '1';
        } else {
            chars[k - 1] = '0';
        }
        return String.valueOf(chars);
    }

}
