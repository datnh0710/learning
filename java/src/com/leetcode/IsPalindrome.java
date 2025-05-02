package com.leetcode;

/**
 * @author datnh0710
 * @created 06/11/2023 - 11:41 AM
 * @packege com.leetcode
 * @project java
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";

        boolean b = isPalindrome(s);
        System.out.printf(String.valueOf(b));

    }

    public static boolean isPalindrome(String s) {
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
