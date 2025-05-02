package com.leetcode;

public class MySqrt {
    public static void main(String[] args) {
        System.out.printf("%d",mySqrt1(808201));
    }

    // solution 1:
    //sqrtn+1=(sqrt n +( num/sqrtn))/2.0
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        double temp;

        double sr = x / 2;

        do {
            temp = sr;
            sr = (temp + (x / temp)) / 2;
        } while ((temp - sr) != 0);

        return (int) sr;
    }

    //solution 2:  binary search
    public static int mySqrt1(int x) {
        if (x < 2)
            return x;
        int left = 1;
        int right = x;

        while (left < right) {
            double middle = left + ((right - left) / 2);

            if (middle * middle == x)
                return (int)middle;
            else if (middle * middle > x) {
                right = (int)middle;
            } else if (middle * middle < x) {
                left = (int)middle + 1;
            }
        }
        return left - 1;
    }





}
