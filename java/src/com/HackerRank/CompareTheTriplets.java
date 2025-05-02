package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {
    public static void main(String[] args) {

    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int value1 = 0;
        int value2 = 0;
        while (i < a.size() && i < b.size()) {
            if ((a.get(i) - b.get(i)) > 0) {
                value1++;
            } else {
                value2++;

            }
            i++;
        }
        list.add(value1);
        list.add(value2);
        return list;

    }
}
