package com.leetcode;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.printf("%b", isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                fre[s.charAt(i) - 'a']++;
            } else {
                return false;
            }

        }
        for (int i = 0; i < t.length(); i++) {
            if (--fre[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.length() ==0 && t.length() ==0)
            return true;
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); i++) {

                fre[s.charAt(i) - 'a']++;

        }
        for (int i = 0; i < t.length(); i++) {
            if (--fre[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] alpha=new int[26];
        for (int i=0;i<s.length();i++){
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        for (int i=0;i<26;i++){
            if (alpha[i] != 0) return false;
        }
        return true;

    }

}
