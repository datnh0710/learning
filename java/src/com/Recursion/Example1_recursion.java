package com.Recursion;

import java.math.BigInteger;

public class Example1_recursion {
    public static void main(String[] args) {
        System.out.printf("%n%d", recursion(5));
    }

    private static int recursion(int number) {
        System.out.printf("%d", number);
        ;
        if (number == 1) {
            return 1;
        }
        return number * recursion(number - 1);
    }

    private static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        } else {
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        }
    }
}
