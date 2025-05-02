package com.homework;

public class HW4 {
    public static void main(String[] args) {
        System.out.printf("GCD: %d", GCD(-20,8));
    }

    public static int GCD(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        do {
            int n = x % y;

            x = y;
            y = n;

        } while (y > 0);
        return x;
    }
}
