package com.leetcode;

public class PowerOfFour {
    public static void main(String[] args) {
        isPowerOfFour1(16);
    }

    public static boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        while (num >= 4 && num % 4 == 0) {

            num /= 4;

        }
        return num == 1;

    }

    public static boolean isPowerOfFour1(int num) {
        if (num < 0) return false;
        String bin = Integer.toBinaryString(num);
        if (bin.substring(0, 1).equals("1") && bin.lastIndexOf("1") == 0 && (bin.length() - 1) % 2 == 0) return true;
        else return false;

    }

}
