package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        getRow(4);

    }

    public static List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> res = new ArrayList<>();
        List<Integer> step1 = new ArrayList<>(1);
        step1.add(1);
//        res.add(step1);
        if (rowIndex == 0)
            return step1;
        List<Integer> pre = null;

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);

            for (int j = 1; j <= i - 1; j++) {
                tmp.add(j, pre.get(j - 1) + pre.get(j));
            }
            tmp.add(1);
//            res.add(tmp);
            pre = tmp;
        }

        return pre;

    }
}
