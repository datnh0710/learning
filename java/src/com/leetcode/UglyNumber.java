package com.leetcode;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.printf("%b", isUgly(2));
    }

    /**
     * simple solution
     *
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if (num == 1)
            return true;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }

            if (num % 3 == 0) {
                num /= 3;
                continue;
            }

            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;

        }
        return num == 1 ? true : false;
    }



}
