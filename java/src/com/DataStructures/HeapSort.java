package com.DataStructures;

public class HeapSort<T extends Comparable<? super T>> {
    public static void main(String[] args) {

    }

    /**
     * internal method for heapsort
     *
     * @param i the index of an item in the heap
     * @return the index of the left child
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {// build heap
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swapReference(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private static <T extends Comparable<? super T>> void swapReference(T[] a, int i, int i1) {
        T tmp = a[i];
        a[i] = a[i1];
        a[i1] = tmp;
    }

}
