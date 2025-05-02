package com.SearchingSortingBigO;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.printf("%n%d",linearSearch(20, arr));

    }

    public static int linearSearch(int value, int[] arr) {
        if (arr.length == 0)
            return -1;
        int size = arr.length - 1;
        while (size >= 0) {
            if (arr[size] == value) {
                System.out.printf("%n%s%d", "Found value at index: ", size);
                return size;
            }
            --size;
        }
        return -1;
    }

    public static int linearSearchFor(int value, int[] arr) {
        if (arr.length == 0)
            return -1;
        int size = arr.length - 1;
        for (int i = 0; i < size; i++) {
            if (size >= 0) {
                if (arr[size] == value) {
                    System.out.printf("%n%s%d", "Found value at index: ", size);
                    return i;
                }
            }
        }
        return -1;
    }

}
