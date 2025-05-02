package com.print;

import java.util.Scanner;

public class print {
    public static void main(String[] args) {
        System.out.println("OK man!!");
        System.out.print("ok ok ok ");
        System.out.print("ok! ok! ok! ");
        System.out.print("\nusing \n new \n line \n");
        System.out.print("using \t new \t tab \n");
        System.out.println("\" quote \" ");
        Scanner input = new Scanner(System.in);
        int m1,m2,sum;
        System.out.println("Enter number 1: ");
        m1 = input.nextInt();

        System.out.println("Enter number 2: ");
        m2 = input.nextInt();

        sum= m1+ m2;
        System.out.println("Result: " + sum);
        System.out.printf("Result: %d%n", sum);

    }
}
