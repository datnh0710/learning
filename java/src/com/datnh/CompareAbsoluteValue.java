package com.datnh;

import java.util.*;
import java.util.Comparator;

public class CompareAbsoluteValue {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(Math.abs(a), Math.abs(b));
            }
        };
//        int[] arr = {-1,4,5,10,-19,100};
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(-19);
        list.add(100);

        Collections.sort(list, comparator);
        for (Integer integer : list) {
            System.out.printf("%d%n", integer);
        }

    }
}
