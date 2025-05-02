package com.leetcode;

public class ImplementstrStr {
    public static void main(String[] args) {
//        System.out.printf("%n%d",strStr("hello","ll"));
        System.out.printf("%n%d",strStr("mississippi","pi"));



    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (haystack.equals(needle))
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }

        }


        return -1;


    }

    public static int strStr1(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        return haystack.indexOf(needle);

    }
}
