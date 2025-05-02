package com.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.printf("%n%d", reverse(901000));
//        System.out.printf("%n%d", reverse(-123));
//        System.out.printf("%n%d", reverse(120));
        System.out.printf("%nTrue or False: %b", isPalindrome(121));
        System.out.printf("%nTrue or False: %b", isPalindrome(10));
        System.out.printf("%nTrue or False: %b", isPalindrome(-121));
        System.out.printf("%nTrue or False: %b", isPalindrome(-1991));
        System.out.printf("%nTrue or False: %b", isPalindrome(4554));


    }

    private static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = x * -1;
        }
        if ((x < 10 && x >= 0) || (x > -10 && x <= -1)) {
            return x;
        }

        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE/10 || (res== Integer.MAX_VALUE/10 && temp >7))return 0;
            if (res < Integer.MIN_VALUE/10 || (res== Integer.MIN_VALUE/10 && temp <-8))return 0;
            res = res*10 + temp;

        }

        return (flag == true) ? res * -1 : res;

    }

    private static boolean isPalindrome(int x){
        int tmp =x;
        if (tmp < 0) {
            return false;
        }

        int res = 0;
        while (tmp != 0) {
            int temp = tmp % 10;
            tmp = tmp / 10;
            if (res > Integer.MAX_VALUE/10 || (res== Integer.MAX_VALUE/10 && temp >7))return false;
            if (res < Integer.MIN_VALUE/10 || (res== Integer.MIN_VALUE/10 && temp <-8))return false;
            res = res*10 + temp;

        }

        return (res==x)?true:false;
    }
}
