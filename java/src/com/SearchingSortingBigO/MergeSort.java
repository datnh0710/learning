package com.SearchingSortingBigO;

import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        int data[] = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = generator.nextInt(100);
        }
        System.out.printf("Before sort: %n%s%n%n", Arrays.toString(data));

        mergeSort(data);
        System.out.printf("Sorted array: %n%s%n%n", Arrays.toString(data));

    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;
        int middle = leftStart + (rightEnd - leftStart) / 2;
        System.out.printf("split: %s%n", subarrayString(arr, leftStart, rightEnd));
        System.out.printf("       %s%n", subarrayString(arr, leftStart, middle));
        System.out.printf("       %s%n%n", subarrayString(arr, middle + 1, rightEnd));

        mergeSort(arr, leftStart, middle);
        mergeSort(arr, middle + 1, rightEnd);
        merge1(arr, leftStart, rightEnd);
    }

    private static void merge(int[] arr, int leftStart, int rightEnd) {

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int[] res = new int[arr.length];

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                res[index] = arr[left];
                left++;
            } else {
                res[index] = arr[right];
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, res, index, leftEnd - left + 1);
        System.arraycopy(arr, right, res, index, rightEnd - right + 1);
        System.arraycopy(res, leftStart, arr, leftStart, size);


    }

    private static void merge1(int[] arr, int leftStart, int rightEnd) {
        int middle = (leftStart + rightEnd) / 2;

        int left = leftStart;
        int right = middle + 1;
        int[] tmpArr = new int[leftStart + rightEnd + 1];

        int index = left;

        System.out.printf("merge: %s%n", subarrayString(arr, leftStart, middle));
        System.out.printf("       %s%n", subarrayString(arr, middle + 1, rightEnd));

        while (left <= middle && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                tmpArr[index++] = arr[left++];
            } else {
                tmpArr[index++] = arr[right++];
            }
        }
        if (left == middle + 1) {
            while (right <= rightEnd) {
                tmpArr[index++] = arr[right++];
            }
        } else {
            while (left <= middle) {
                tmpArr[index++] = arr[left++];
            }
        }

        for (int i = leftStart; i <= rightEnd; i++) {
            arr[i] = tmpArr[i];
        }
        // output merged array
        System.out.printf(" %s%n%n", subarrayString(arr, leftStart, rightEnd));


    }

    static String subarrayString(int[] arr, int left, int right) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < left; i++) {
            stringBuilder.append("  ");
        }
        for (int j = left; j <= right; j++) {
            stringBuilder.append(" " + arr[j]);
        }

        return stringBuilder.toString();
    }


}
