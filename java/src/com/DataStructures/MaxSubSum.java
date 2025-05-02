package com.DataStructures;

public class MaxSubSum {
    public static void main(String[] args) {

    }

    /**
     * Big-O O(n3)
     *
     * @param a
     * @return
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thiSum = 0;
                for (int k = i; k <= j; k++) {
                    thiSum += a[k];
                }
                if (thiSum > maxSum)
                    maxSum = thiSum;
            }
        }

        return maxSum;
    }

    public static int maxSubSum2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }


    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }
        int center = left + (right - left) / 2;
        int maxLeftSum = maxSumRec(a, 0, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i++) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;

        }

        return Math.max(maxLeftSum, Math.max(maxRightSum, maxLeftBorderSum + rightBorderSum));
    }

    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    public static int maxSubSum4(int[] a) {
        int sum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > sum)
                sum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return sum;
    }


}
