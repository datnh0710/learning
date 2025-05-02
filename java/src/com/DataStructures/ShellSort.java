package com.DataStructures;

public class ShellSort<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        Integer[] arr = {10, 2, 9, 5, 6, 8};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s", arr[i]);
        }
    }

    /**
     * Shell sort, using shell's(poor) increments
     *
     * @param arr an array of Comparable items
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
        if (arr.length == 0)
            return;
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < arr.length; i++) {
                T tmp = arr[i];
                for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
    }
}
