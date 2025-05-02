package com.leetcode;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.printf("%d", countPrimes(3));
    }

    static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n ;i++){
            if(notPrime[i])
                continue;
            count++;
            for(int j = 2; i*j < n;j++)
                notPrime[i*j] = true;
        }
        return count;
    }

    private static boolean checkPrime(int n) {
        if (n % 2 == 0)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
