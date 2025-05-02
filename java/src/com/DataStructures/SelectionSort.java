package com.DataStructures;

public class SelectionSort<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        Integer[] arr = {10, 2, 9, 5};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s", arr[i]);
        }
    }
    /**
     * Simple selection sort
     *
     * @param arr an array of Comparable items
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        if (arr.length == 0)
            return;
        int j;
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0)
                    min = j;
            }
            if (min != i) {
                T tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
