package com.DataStructures;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 9, 5, 6, 8};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s", arr[i]);
        }
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int middle = left + (right - left) / 2;
        mergeSort(a, left, middle);
        mergeSort(a, middle + 1, right);
        merge(a, left, right);

    }

    private static void merge(int[] a, int leftStart, int rightEnd) {
        int leftEnd = leftStart + (rightEnd - leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int[] arr = new int[a.length];

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftIndex;
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                arr[index] = a[leftIndex++];

            } else {
                arr[index] = a[rightIndex++];
            }
            index++;
        }

        System.arraycopy(a, leftIndex, arr, index, leftEnd - leftIndex + 1);
        System.arraycopy(a, rightIndex, arr, index, rightEnd - rightIndex + 1);
        System.arraycopy(arr, leftIndex, a, leftStart, size);

    }

}
