package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        generate(5);

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> step1 = new ArrayList<>(1);
        step1.add(1);
//        List<Integer> step2 = new ArrayList<>(2);
//        step2.add(1);
//        step2.add(1);
        res.add(step1);
//        res.add(step2);
        List<Integer> pre = null;

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);

            for (int j = 1; j <= i - 1; j++) {
                tmp.add(j, pre.get(j - 1) + pre.get(j));
            }
            tmp.add(1);
            res.add(tmp);
            pre = tmp;
        }

        return res;


    }
}
