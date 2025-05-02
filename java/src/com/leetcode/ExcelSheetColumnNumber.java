package com.leetcode;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.printf("%d", titleToNumber("ABA"));

    }

    public static int titleToNumber(String s) {
        int res = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, count++);
        }
        return res;
    }
}
