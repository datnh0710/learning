package com.leetcode;

import java.util.ArrayList;

public class CheckPowersOfThree {
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(3));
    }

    public static boolean checkPowersOfThree(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        double res = Math.log10(n) / Math.log10(3);
        power(n, 0, (int) res, 0, arr);
        if (arr.contains(n)) {
            return true;
        }
        return false;
    }

    public static void power(int n, int start, int po, int ans, ArrayList<Integer> arr) {

        if (ans == n) {
            arr.add(ans);

        }

        for (int i = start; i <= po; i++) {
            ans += (int) (Math.pow(3, i));

            power(n, i + 1, po, ans, arr);
            ans -= (int) (Math.pow(3, i));

        }

    }

    public boolean checkPowersOfThree1(int n) {
        int x = n;
        while(x != 0){
            if(x % 3 == 2)
                return false;
            x = x / 3;
        }

        return true;
    }
}
