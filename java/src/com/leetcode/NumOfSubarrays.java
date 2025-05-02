package com.leetcode;

public class NumOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int k = 1;
        int threshold = 0;
        numOfSubarrays(arr, k, threshold);

    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i <= len - k; i++) {
            int avg = 0;
            for (int j = i; j < i + k; j++) {
                avg += arr[j];
            }
            if (avg / k >= threshold)
                count++;
        }
        return count;
    }

    public static int numOfSubarrays1(int[] arr, int k, int threshold) {
        int avg = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            avg += arr[i];

        }
        if (avg / k >= threshold)
            count++;
        int len = arr.length;
        for (int i = k; i < len; i++) {
            avg += arr[i];
            avg -= arr[i - k];
            if (avg / k >= threshold)
                count++;
        }
        return count;
    }

}
