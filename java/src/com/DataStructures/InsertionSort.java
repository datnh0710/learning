package com.DataStructures;

public class InsertionSort<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        Integer[] arr = {10, 2, 9, 5};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s", arr[i]);
        }

    }

    /**
     * Simple insertion sort
     *
     * @param arr an array of Comparable items
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        if (arr.length == 0)
            return;
        int j;
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            for (j = i; j > 0 && (key.compareTo(arr[j - 1]) < 0); j--) {

                arr[j] = arr[j - 1];

            }
            arr[j] = key;
        }

    }
}
