package com.leetcode;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.printf("%b", detectCapitalUse("flaG"));

    }

    static boolean detectCapitalUse(String word) {
        if (word.length() == 0)
            return false;
        boolean flag = word.charAt(0) - 'a' < 0 ? true : false;
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) - 'a' < 0) {
                sum += 1;
            } else {
                sum += 0;
            }
        }
        if (sum == word.length() || sum == 0 || (sum == 1 && flag)) {
            return true;
        }
        return false;
    }
}
