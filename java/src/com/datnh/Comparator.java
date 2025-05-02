package com.datnh;

import java.util.HashSet;

public class Comparator {
    boolean compare(int val1, int val2) {
        return val1 == val2 ? true : false;
    }

    boolean compare(String s1, String s2) {
        return s1.equals(s2);
    }

    boolean compare(int[] arr1, int[] arr2) {
        return arr1.toString() == arr2.toString() && arr1.length == arr2.length ? true : false;
    }
}
