package com.leetcode;

public class CountPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] res = countPoints(points, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            for (int i = 0; i < points.length; i++) {
                if (distance(queries[j][0], queries[j][1], points[i][0], points[i][1]) <= queries[j][2] * queries[j][2]) {
                    res[j]++;
                }
            }
        }
        return res;
    }

//    public static int distance(int x1, int y1, int x2, int y2) {
//        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//    }

//    public static int[] countPoints(int[][] points, int[][] queries) {
//        int[] res = new int[queries.length];
//        for (int j = 0; j < queries.length; j++) {
//            for (int i = 0; i < points.length; i++) {
//                if (distance(queries[j][0], queries[j][1], points[i][0], points[i][1]) <= queries[j][2]) {
//                    res[j]++;
//                }
//            }
//        }
//        return res;
//    }
}
