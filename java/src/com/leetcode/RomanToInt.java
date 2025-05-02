package com.leetcode;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {

        System.out.printf("%n%d", romanToInt("III"));
        System.out.printf("%n%d", romanToInt("IV"));
        System.out.printf("%n%d", romanToInt("IX"));
        System.out.printf("%n%d", romanToInt("LVIII"));
        System.out.printf("%n%d", romanToInt("MCMXCIV"));

    }

//    private static int romanToInt(String s) {
//        int total = 0;
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("IV", 4);
//        map.put("V", 5);
//        map.put("I", 1);
//        map.put("IX", 9);
//        map.put("X", 10);
//        map.put("XL", 40);
//        map.put("L", 50);
//        map.put("XC", 90);
//        map.put("C", 100);
//        map.put("CD", 400);
//        map.put("D", 500);
//        map.put("CM", 900);
//        map.put("M", 1000);
//        int i = s.length() - 1;
//
//        while (i > -1) {
//            String last = String.valueOf(s.charAt(i));
//            String prv = "";
//            if (i > 0) {
//                prv = String.valueOf(s.charAt(i - 1));
//            }
//            if (map.get(prv + last) != null) {
//                total = total + map.get(prv + last);
//                i--;
//            } else {
//                total += map.get(String.valueOf(s.charAt(i)));
//            }
//            i--;
//
//        }
//        return total;
//    }

    private static int romanToInt(String s) {
        int total = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('V', 5);
        map.put('I', 1);

        map.put('X', 10);

        map.put('L', 50);

        map.put('C', 100);

        map.put('D', 500);

        map.put('M', 1000);
        int i = s.length() - 1;

        while (i > -1) {
            int lastValue = map.get(s.charAt(i));
            int preValue = 0;
            if (i > 0)
                preValue = map.get(s.charAt(i - 1));
            if (preValue < lastValue) {
                total += lastValue - preValue;
                i--;
            } else {
                total += lastValue;
            }
            i--;

        }
        return total;
    }
}
