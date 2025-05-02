package com.Recursion;

public class FindBinary {
    public static void main(String[] args) {
        System.out.printf("%n%6d", findBinary(10));
    }

    private static int findBinary(int number) {
        if (number == 0) {
            return 0;
        } else {
            return number % 2 + 10 * (findBinary(number / 2));
        }
    }
}
