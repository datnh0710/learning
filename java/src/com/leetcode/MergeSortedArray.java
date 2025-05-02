package com.leetcode;

public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;
        int right1 = m - 1;
        int right2 = n - 1;
        while (right1 >= 0 && right2 >= 0) {
            int tmp1 = -1;
            int tmp2 = -1;
            if (right1 >= 0) {
                tmp1 = nums1[right1];
            }
            if (right2 >= 0) {
                tmp2 = nums2[right2];
            }
            if (tmp1 >= tmp2) {
                nums1[index] = tmp1;
                index--;
                right1--;
            } else {
                nums1[index] = tmp2;
                index--;
                right2--;
            }
        }
        while (right2 >= 0 && index >= 0) {
            nums1[index--] = nums2[right2--];
        }

    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        n--;
        m--;
        for (int i=nums1.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else if (n >= 0){
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
