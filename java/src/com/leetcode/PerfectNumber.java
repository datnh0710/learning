package com.leetcode;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.printf("%b", checkPerfectNumber(8128));

    }

    static boolean checkPerfectNumber(int num) {
        if (num <= 3) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0)
                sum += i;

        }

        return sum == num ? true : false;
    }

    static boolean checkPerfectNumber1(int num) {
        if (num <= 3) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= num / 2; i += 2) {
            if (num % i == 0)
                sum -= i;
            if (sum > num)
                return false;

        }

        return sum == num ? true : false;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;

    }

    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public boolean checkPerfectNumber3(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }
}
