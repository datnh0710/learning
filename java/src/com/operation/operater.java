package com.operation;

public class operater {
    public static void main(String[] args) {

        int c = 0;
        while (c < 10) {
            System.out.println("Before ++C: " + c);
            ++c;

            System.out.println("After ++C: " + c);
        }

        int d = 0;
        while (d < 10) {
            System.out.println("S ++D: " + d);
            d++;
            System.out.println("S1 ++D: " + d);

        }


        // prefix
        int i = 0;

        System.out.printf("prefix i: %d%n", ++i);
        System.out.printf("prefix i: %d%n", i);

        //postfix

        System.out.printf("postfix i: %d%n", i++);
        System.out.printf("postfix i: %d%n", i);
        System.out.println("----------------");

        int j = 2;

        System.out.printf("prefix j: %d%n", --j);
        System.out.printf("prefix j: %d%n", j);

        System.out.printf("postfixj: %d%n", j--);
        System.out.printf("postfix j: %d%n", j);
    }
}
