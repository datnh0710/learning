package com.leetcode;

import java.util.Random;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(divisorGame(2));


    }


    public static boolean divisorGame(int n) {
        return n % 2 == 0;

    }

    public static int pickOne(int n) {
        Random rm = new Random();
        int res = 0;
        do {
            res = rm.nextInt(n) + 1;
        } while (n % res != 0);
        return res;
    }

}
