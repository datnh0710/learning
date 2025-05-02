package com.DataStructures;

import java.util.NoSuchElementException;

/**
 * for any element in array position i,
 * the left child is in position 2i
 * the right child is in position 2i+1
 * the parent is in position i/2
 * @param <T>
 */

public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize; // number of element in heap
    private T[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (T[]) new Object[capacity];
        currentSize = 0;
    }

    /**
     * construct the binary heap given an array of items
     *
     * @param items
     */
    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    /**
     * for any element in array position i,
     * the left child is in position 2i
     * the right child is in position 2i+1
     * the parent is in position i/2
     */
    /**
     * insert into the priority queue, maintaining heap order
     * duplicates are allowed.
     *
     * @param x the item to insert
     */
    public void insert(T x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) { // this strategy calls percolateUp
            array[hole] = array[hole / 2]; // ->> move up the small up
        }
        array[hole] = x;
    }

    public T findMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        return array[1];

    }

    /**
     * remove the smallest item from the priority queue.
     *
     * @return the smallest item, or throw UnderFlowException, if empty.
     */
    public T deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        T minItem = findMin();
        array[1] = array[currentSize--];

        precolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        array = null;

    }

    /**
     * internal method to percolate down in the heap
     *
     * @param hole hole the index at which the percolate begins.
     */
    private void precolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    /**
     * establish heap order property from an arbitrary
     * arrangement of item. Runs in linear time
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            precolateDown(i);
        }

    }

    private void enlargeArray(int newSize) {

    }
}
