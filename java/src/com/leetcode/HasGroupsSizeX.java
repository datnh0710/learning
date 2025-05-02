package com.leetcode;

import java.util.HashMap;


public class HasGroupsSizeX {
    public static void main(String[] args) {
        int[] arr = {1, 1};
        System.out.println(hasGroupsSizeX(arr));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : deck) {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int i = 0; i < mp.size(); i++) {
            int temp = mp.get(mp.keySet().toArray()[i]);
            res = res == 0 ? temp : gcd(temp,res);
        }
        return res >= 2;
    }
    public static int gcd(int a,int b) {
        if(a == 0) return b;
        return gcd(b%a,a);
    }
}
