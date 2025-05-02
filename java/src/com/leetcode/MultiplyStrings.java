package com.leetcode;

import javax.xml.stream.events.Characters;

public class MultiplyStrings {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.printf("%s", multiply(s1, s2));

    }

    static String multiply(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        long sum1 = 0;
        long sum2 = 0;
        long multip = 1;
        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                sum1 += ((long)(num1.charAt(i--) - '0') * multip);
            }
            if (j >= 0) {
                sum2 += (long)(num2.charAt(j--) - '0') * multip;
            }
            multip *= 10L;

        }

        return String.valueOf(sum1 * sum2);
    }
}
