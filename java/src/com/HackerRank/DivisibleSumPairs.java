package com.HackerRank;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 1, 2};
        System.out.printf("%d", divisibleSumPairs(6, 3, arr));

    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        if (n == 0 || ar.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) == k || ((ar[i] + ar[j]) % k) == 0) {
                    count++;
                }

            }
        }
        return count;

    }
}
