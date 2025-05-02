package com.DataStructures;

public class Euclid {
    public static void main(String[] args) {
        System.out.printf("%02d", gcd(8,5));

    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
