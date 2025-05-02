package com.homework;

public class hw {
    public static void main(String[] args) {
        double amount = 1000;
        double sum = 0;
        double rate = 0.05;


        for (int i = 1; i <= 10; i++) {
            sum = amount * Math.pow(1.0 + rate, i);
            System.out.printf("Amount for year: %,20.2f%n", sum);
        }
        print1(10);
        System.out.println("-------4");
        print4(10);
        System.out.println("-------2");
        print2(10);
        System.out.println("-------3");
        print3(10);

    }
    public static void printTriangle(int style, int d){
        switch (style){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    public static void print2(int d){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++) {
            s.append("*");
        }
        for (int i = 0; i < d; i++) {
            System.out.printf("%s%n",s);
            s.replace(i,i+1," ");
        }
    }

    public static void print3(int d){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++) {
            s.append("*");
        }
        for (int i = d; i >=0; i--) {
            System.out.printf("%s%n",s);
            s.replace(i,i+1," ");
        }

    }

    public static void print1(int d){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i< d;i++){
            s.append("*");
            System.out.printf("%s%n",s);
        }
    }



    public static void print4(int d){
        StringBuilder s = new StringBuilder();

        for (int i = d; i>0;i--){
            s.append("*");
            System.out.printf("%10s%n",s);
        }
    }


}
