package com.leetcode;

/**
 * @author datnh0710
 * @created 10/01/2022 - 1:21 PM
 * @packege com.leetcode
 * @project java
 */
public class myAtoi {
    public static void main(String[] args) {
        int a = '1' - '0';
        System.out.print(a);
    }

    public static int myAtoi(String s) {

        int res = 0;
        int flag = 1;
        int index = 0;
        int size = s.length();
        while (index < size && s.charAt(index) == ' ') {
            index++;
        }
        if (index < size && s.charAt(index) == '-'){
            flag = -1;
            index++;
        }else if(index < size && s.charAt(index) == '+') {
            index++;
        }

        while (index < size && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }


        return flag * res;
    }
}
