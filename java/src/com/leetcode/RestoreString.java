package com.leetcode;

/**
 * @author datnh0710
 * @created 14/11/2023 - 4:16 PM
 * @packege com.leetcode
 * @project java
 */
public class RestoreString {
    public static void main(String[] args) {
        String s = "codeleet";
        int []indices = new int[]{4,5,6,7,0,2,1,3};
        restoreString(s,indices);
    }

    public static String restoreString(String s, int[] indices) {
        int size = indices.length;
        char[] res = new char[size];
        char[] sc = s.toCharArray();

        for (int i = 0; i < size; i++) {
            res[indices[i]] = sc[i];
        }

        return String.valueOf(res);

    }
}
