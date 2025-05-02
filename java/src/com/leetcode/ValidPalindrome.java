package com.leetcode;

import javax.xml.stream.events.Characters;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "";
        String s1 = "race a car";
//        String s2 = "1a2";
        String s2 = "A man, a plan, a_ canal: Panama";
//        System.out.printf("%n%b ", isPalindrome(s));
//        System.out.printf("%n%b ", isPalindrome(s1));
        System.out.printf("%n%b ", isPalindrome1(s2));


    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome1(String s) {
        if (s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;


        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (!(l >= 'a' && l <= 'z') && !(l >= 'A' && l <= 'Z') && !(l >= '0' && l <= '9')) {
                i++;
                continue;
            }
            if (!(r >= 'a' && r <= 'z') && !(r >= 'A' && r <= 'Z') && !(r >= '0' && r <= '9')) {
                j--;
                continue;
            }
            if(l>='A' && l<='Z')
            {
                l=Character.toLowerCase(l);
            }
            if(r>='A' && r<='Z')
            {
                r=Character.toLowerCase(r);
            }
            if (l != r)
                return false;
            j--;
            i++;
        }


        return true;
    }
}
