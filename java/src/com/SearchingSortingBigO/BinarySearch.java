package com.SearchingSortingBigO;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 15, 19, 20};
        System.out.printf("%d", binarySearchRecurrisve(12, arr, 0, arr.length-1));

//        System.out.printf("%d", binarySearch(21,arr));


    }

    public static int binarySearchRecurrisve(int value, int[] arr, int left, int right) {

        int mid = left + ((right - left) / 2);
        if (left <= right) {
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            return -1;
        }

        return binarySearchRecurrisve(value, arr, left, right);

    }

    public static int binarySearch(int value, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (arr[mid] == value)
                return mid;
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
