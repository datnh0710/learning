package com.Bitwise;

public class Bitwises {
    public static void main(String[] args) {
        //Initial values
        int a = 1;
        int b = 3;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.printf("a %d & b %d = %d%n",a,b,bitWiseAnd(a,b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.printf("a %d | b %d = %d%n",a,b, bitWiseOr(a,b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.printf("a %d ^ b %d = %d%n",a,b, bitWiseXor(a,b));

        // bitwise and
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.printf("~a %d = %d%n",a, bitWiseComplement(a));

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b

        System.out.printf("a %d &= b %d --> a= %d%n",a,b,a &= b);


        //bitwise left shift
        // not use for negative number
        // a = 1 = 0001 --> left shift: 0010 =2

        System.out.printf("a %d << 1: %d%n", a, bitWiseLeftShift(a));

        //bitwise right shift
        // not use for negative number
        // a = 1 = 0001 --> right shift: 0000 =0
        System.out.printf("a %d >> 1: %d%n", a, bitWiseRightShift(a));

    }

    public static int bitWiseOr(int num1, int num2){
        return num1|num2;
    }

    public static int bitWiseAnd(int num1, int num2){
        return num1&num2;
    }

    public static int bitWiseXor(int num1, int num2){
        return num1^num2;
    }

    public static int bitWiseComplement(int num1){
        return ~num1;
    }

    public static int bitWiseLeftShift(int num){ return num<<1;}
    public static int bitWiseRightShift(int num){ return num>>1;}
}
