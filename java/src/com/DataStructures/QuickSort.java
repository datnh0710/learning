package com.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort<T> {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(7);
        arr.add(10);
        arr.add(9);
        arr.add(3);
        quickSort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%s", arr.get(i));
        }
    }

    public static void quickSort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer i : items) {
                if (i < chosenItem)
                    smaller.add(i);
                else if (i == chosenItem)
                    same.add(i);
                else
                    larger.add(i);
            }
            quickSort(smaller);
            quickSort(larger);


            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    /**
     * quick sort
     *
     * @param a   an array of Comparable items
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static final int CUTOFF = 10;

    /**
     * internal quicksort method that makes recursive calls
     * Use median-of-three partitioning and cutoff of 10
     *
     * @param a     an array of comparable items
     * @param left  the left-most index of sub-array
     * @param right the right-most index of sub-array
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
        if (left + 10 <= right) {
            T pivot = median3(a, left, right);

            //begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    swapReference(a, i, j);
                } else {
                    break;
                }
            }
            swapReference(a, i, right - 1); // restore pivot
            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        } else { // do an insertion sort on the sub-array
            insertionSort(a, left, right);
        }
    }

    /**
     * internal selection method that makes recursive calls
     * uses median-of-three partitioning and a cutoff of 10
     * places the kth smallest item in a[k-1]
     *
     * @param a     an array of comparable item
     * @param left  the left-most index of the sub-array
     * @param right the right-most index of the sub-array
     * @param k     the desired index (1 is minimum) in the entire array
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            //Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while ((a[--j].compareTo(pivot) > 0)) {
                }
                if (i < j)
                    swapReference(a, i, j);
                else
                    break;
            }
            //restore pivot
            swapReference(a, i, right - 1);

            if (k <= i)
                quickSelect(a, left, i - 1, k);
            else
                quickSelect(a, i + 1, right, k);
        } else
            //do an insertion sort on the array
            insertionSort(a, left, right);

    }

    /**
     * interal method for insertion sort
     *
     * @param a     an array
     * @param left  left-index
     * @param right right-index
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        int j;
        for (int i = left; i < right; i++) {
            T key = a[i];
            for (j = i + 1; j > 0 && key.compareTo(a[j]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = key;
        }

    }


    /**
     * return median of left, center, and right
     * order these and hide the pivot
     *
     * @param a
     * @param left
     * @param right
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0) {
            swapReference(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReference(a, left, right);
        }
        if (a[center].compareTo(a[right]) < 0) {
            swapReference(a, center, right);
        }
        //place pivot at position -1
        swapReference(a, center, right - 1);
        return a[right - 1];

    }

    /**
     * internal swap method
     *
     * @param a
     * @param left
     * @param center
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void swapReference(T[] a, int left, int center) {
        T tmp = a[left];
        a[left] = a[center];
        a[center] = a[left];

    }


}
