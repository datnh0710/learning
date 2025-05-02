package com.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        String s = "1010";
        String s1 = "1011";
        System.out.printf("%s", addBinary(s,s1));
        System.out.printf("%n%s", '1' - '0');
        System.out.printf("%n%s", '1' - '0');

    }

    static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0 || sum == 1) {


            sum += ((i >= 0) ? a.charAt(i--) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j--) - '0' : 0);

            stringBuilder.append(sum % 2);
            sum /= 2;


        }
        return stringBuilder.reverse().toString();
    }
}
