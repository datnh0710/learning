package com.leetcode;

public class HourglassSum {
    public static void main(String[] args) {

    }

    private static int hourglassSum(int[][] arr) {
        int maxX = 3;
        int maxY = 3;
        int totalSum = Integer.MIN_VALUE;
        for (int i = 0; i <=maxY; i++) {
            for (int j = 0; j <= maxX; j++) {

                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];// first row
                sum += arr[i + 1][j + 1];//middle row
                sum += arr[i+2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];//third row

                if (totalSum<sum)
                    totalSum=sum;
            }

        }
        return totalSum;
    }
}
