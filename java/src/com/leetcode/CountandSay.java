package com.leetcode;

public class CountandSay {
    public static void main(String[] args) {
        System.out.printf("%s%n", countAndSay(1));
        System.out.printf("%s%n", countAndSay(2));
        System.out.printf("%s%n", countAndSay(3));
        System.out.printf("%s%n", countAndSay(4));
        System.out.printf("%s%n", countAndSay(5));
        System.out.printf("%s%n", countAndSay(6));

    }

    public static String countAndSay(int n) {

        if (n == 1)
            return "1";

        return "1" + countAndSay(n - 1);


    }
}
