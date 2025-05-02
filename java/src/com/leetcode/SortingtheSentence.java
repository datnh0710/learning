package com.leetcode;

import com.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author datnh0710
 * @created 12/01/2022 - 12:45 PM
 * @packege com.leetcode
 * @project java
 */
public class SortingtheSentence {
    public static void main(String[] args) {

    }

    public static String sortSentence(String s) {
        String[] tmp = s.split(" ");
        String[] res = new String[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            int index = tmp[i].charAt(tmp[i].length() - 1) - '0';
            res[index - 1] = tmp[i].substring(0, tmp[i].length() - 2);
        }

        return String.join(" ",res);
    }
}
