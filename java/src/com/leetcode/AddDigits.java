package com.leetcode;

public class AddDigits {
    public static void main(String[] args) {
        System.out.printf("%d", addDigits(38));
    }

    public static int addDigits(int num) {
        if (num < 10)
            return num;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
            if (sum < 10 && num < 1) {
                return sum;
            } else if (num == 0) {
                num = sum;
                sum = 0;
            }
        }
        return 1;

    }
}
