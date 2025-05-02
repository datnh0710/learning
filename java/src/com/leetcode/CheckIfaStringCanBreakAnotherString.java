package com.leetcode;

import java.util.Arrays;

/**
 * @author datnh0710
 * @created 27/05/2022 - 11:18 AM
 * @packege com.leetcode
 * @project java
 */
public class CheckIfaStringCanBreakAnotherString {
    public static void main(String[] args) {

    }

    public boolean checkIfCanBreak(String s1, String s2) {
        int size = s1.length();

        char tempArray1[] = s1.toCharArray();
        Arrays.sort(tempArray1);

        char tempArray2[] = s2.toCharArray();
        Arrays.sort(tempArray2);

        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < size; i++) {
            if (tempArray1[i] >= tempArray2[i]) {
                counter1++;
            }
            if (tempArray2[i] >= tempArray1[i]) {
                counter2++;
            }
        }

        return counter1 == size || counter2 == size;
    }
}
