package com.leetcode;

public class MaxValue {
    public static void main(String[] args) {
        System.out.println(maxValue("-13", 2));
    }

    public static String maxValue(String n, int x) {
        char[] arr = n.toCharArray();
        int len = arr.length;
        char[] res = new char[len + 1];
        boolean flag = true;
        if (arr[0] == '-') {
            res[0] = arr[0];
            int j = 1;
            for (int i = 1; i < len; i++) {
                if (arr[i] - '0' > x && flag == true) {
                    res[j++] = Character.forDigit(x, 10);
                    flag = false;
                }
                res[j] = arr[i];
                j++;

            }
            if (j == len) {
                res[j] = Character.forDigit(x, 10);
            }
        } else {
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (arr[i] - '0' < x && flag == true) {
                    res[j++] = Character.forDigit(x, 10);
                    flag = false;
                }
                res[j] = arr[i];
                j++;

            }
            if (j == len) {
                res[j] = Character.forDigit(x, 10);
            }
        }


        return String.valueOf(res);
    }
    public String maxValue1(String n, int x) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(0) != '-' && n.charAt(i) - '0' < x || n.charAt(0) == '-' && n.charAt(i) - '0' > x)
                return n.substring(0, i) + x + n.substring(i);
        }
        return n + x;
    }
}
