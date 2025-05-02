package com.leetcode;

/**
 * @author datnh0710
 * @created 12/01/2022 - 12:36 PM
 * @packege com.leetcode
 * @project java
 */
public class CheckABeforeB {
    public static void main(String[] args) {

    }

    public static boolean checkString(String s) {
        return s.contains("ba");

    }

    public boolean checkString1(String s) {
        if (s.lastIndexOf('a')==-1 || s.indexOf('b')==-1 )
            return true;
        if (s.lastIndexOf('a') < s.indexOf('b'))
            return true ;
        else
            return false;
    }
}
