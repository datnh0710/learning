package com.leetcode;

public class MaximumTime {
    public static void main(String[] args) {
        System.out.printf(maximumTime("00:??"));
    }

    //example 2?:?0
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            if (arr[1] == '?') {
                arr[0] = '2';
                arr[1] = '3';
            } else if (arr[1] - '0' >= 4) {
                arr[0] = '1';
            } else {
                arr[0] = '2';
            }
        } else if (arr[1] == '?') {
            if (arr[0] - '0' == 2) {
                arr[1] = '3';
            } else {
                arr[1] = '9';
            }
        }
        if (arr[3] == '?') {
            if (arr[4] == '?') {
                arr[3] = '5';
                arr[4] = '9';
            }else{
                arr[3] = '5';
            }

        } else if (arr[4] == '?') {
            arr[4] = '9';
        }

        return String.copyValueOf(arr);
    }
}
