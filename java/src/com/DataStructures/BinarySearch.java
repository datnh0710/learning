package com.DataStructures;

public class BinarySearch {
    private static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.printf("%d", binarySearch(arr, 7));

    }

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (a[middle].compareTo(x) < 0) {
                left = middle + 1;
            } else if (a[middle].compareTo(x) > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return NOT_FOUND;

    }

    public static <T extends Comparable<? super T>> int binarySearchRecursive(T[] arr, T x, int left, int right) {
        int middle = left + (left) / 2;
        if (left <= right) {
            if (arr[middle].compareTo(x) < 0) {
                left = middle + 1;
            } else if (arr[middle].compareTo(x) > 0) {
                right = middle - 1;
            } else if (arr[middle] == x)
                return middle;
        } else {
            return NOT_FOUND;
        }
        return binarySearchRecursive(arr, x, left, right);


    }
}
