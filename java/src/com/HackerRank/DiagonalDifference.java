package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(11);
        l2.add(2);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);
        l3.add(6);
        List<Integer> l4 = new ArrayList<>();
        l4.add(10);
        l4.add(8);
        l4.add(-12);

        arr.add(l1);
        arr.add(l2);
        arr.add(l3);
        arr.add(l4);

        System.out.printf("%d", diagonalDifference(arr));

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int i = 1;
        int num1 = 0, num2 = 0;
        while (i < arr.size()) {
            List<Integer> lst = arr.get(i);
//            if (i % 2 == 0) {
//                num1 += lst.get(1);
//                num2 += lst.get(1);
//            } else {
//                num1 += lst.get(i-1);
//                num2 += lst.get(arr.size() - 1 - i);
//            }
            num1 += lst.get(i-1);
            num2 += lst.get(arr.size() - 1 - i);
            i++;
        }


        return Math.abs(num1 - num2);

    }
}
