package com.leetcode;

import java.util.Random;

public class New21Game {
    public static void main(String[] args) {

    }

    // example n = 6, k = 1, maxPts = 10
    // output: 0.60000
    public static double new21Game(int n, int k, int maxPts) {
        Random rm = new Random();
        while (k >= 0) {
            int randomNumbber = rm.nextInt(maxPts) + 1;
            k--;
        }
        return 0.0;
    }

}
