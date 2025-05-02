package com.DataStructures;

public class MergeSort1<T> {
    public static void main(String[] args) {

    }

    /**
     * internal method that makes recursive calls
     *
     * @param a        an array of Comparable items
     * @param tmpArray an array to place the merged result
     * @param left     left-most index of the sub array
     * @param right    right-most index of the sub array
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = left + (right - left) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }

    }

    /**
     * internal method that merges two sorted halves of a sub array
     *
     * @param a        an array of Comparable items
     * @param tmpArray an array to place the merged result
     * @param leftPos  the left-most index of the sub array
     * @param rightPos the index of the start of the second half
     * @param rightEnd the right-most index of the sub array
     */
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numsELement = rightEnd - leftPos + 1;

        //main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) < 0) {
                tmpArray[tmpPos++] = a[leftPos++];

            } else {
                tmpArray[tmpPos++] = a[rightPos];
            }
        }
        while (leftPos <= leftEnd) { // copy rest of first half
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while ((rightPos <= rightEnd)) {// copy rest of second half
            tmpArray[tmpPos++] = a[rightPos++];
        }
        //copy tmpArray back
        for (int i = 0; i < numsELement; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }

    }

    /**
     * mergesort algorithm
     *
     * @param a   an array of Comparable items
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);

    }
}
