package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.printf("%b", isHappy(1111111));
    }

    public static boolean isHappy(int n) {
        double sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
            if ((sum == 1 || sum == 7) && n == 0) {
                return true;
            } else if (n == 0 && sum > 9) {
                n = (int) sum;
                sum = 0;
            } else if (n == 0 && sum < 9) {
                break;
            }
        }
        return false;

    }
}
