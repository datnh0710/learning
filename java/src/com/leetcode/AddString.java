package com.leetcode;

public class AddString {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.printf("%s", addStrings(num1, num2));

    }

    static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            sum += (i >= 0) ? num1.charAt(i--) - '0' : 0;
            sum += (j >= 0) ? num2.charAt(j--) - '0' : 0;
            carry = sum / 10;
            stringBuilder.append(sum % 10);
        }
        if (carry == 1) {
            stringBuilder.append(carry);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
