package com.leetcode;

/**
 * @author datnh0710
 * @created 11/01/2022 - 12:40 AM
 * @packege com.leetcode
 * @project java
 */
public class AreNumbersAscending {
    public static void main(String[] args) {
        String s = "hello world 5 x 5";
        areNumbersAscending(s);
    }

    public static boolean areNumbersAscending(String s) {
        String[] str = s.split(" ");
        int i = 0;
        int pre = -1;
        while (i < str.length) {
            int cur = 0;
            if (Character.isDigit(str[i].charAt(0))) {

                int n = Integer.parseInt(str[i]);
                if (n <= pre) return false;
                pre = n;

            }
            i++;
        }
        return true;
    }
}
