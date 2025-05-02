package com.DataStructures;

import java.util.PrimitiveIterator;

public class QuadraticProbingHashTable<T> {


    /**
     * construct the hash table
     */
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * construct the hash table
     *
     * @param size approximate initial size
     */
    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * make the hash table logically empty
     */
    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = null;
        }

    }


    /**
     * find an item in the hash table
     *
     * @param x item to search for
     * @return the matching item
     */
    public boolean contains(T x) {
        int currenPos = findPos(x);
        return isActive(currenPos);

    }

    /**
     * Insert into the hash table. if the item is
     * already present, do nothing
     *
     * @param x item to insert
     */
    public void insert(T x) {
        int currentPos = myhash(x);
        if (isActive(currentPos))
            return;
        arrays[currentPos] = new HashEntry<>(x, true);
        //rehash
        if (++currentPos > arrays.length / 2)
            rehash();

    }

    /**
     * remove from the hash table
     *
     * @param x the item to remove
     */
    public void remove(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            arrays[currentPos].isActive = false;

    }

    private static class HashEntry<T> {
        public T element; // the element
        public boolean isActive; // false if marked deleted

        public HashEntry(T x) {
            this(x, true);
        }

        public HashEntry(T x, boolean i) {
            element = x;
            isActive = i;
        }
    }


    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<T>[] arrays; // The array of element
    private int currentSize; //the number of occupied cells

    /**
     * internal method to allocate array
     *
     * @param arraySize arraySize the size of the array
     * @return
     */
    private void allocateArray(int arraySize) {
        arrays = new HashEntry[nextPrime(arraySize)];
    }

    /**
     * return true if currentPos exists and is active
     *
     * @param currentPos the result of a call to findPos
     * @return true if currentPos is active
     */
    private boolean isActive(int currentPos) {
        return arrays[currentPos] != null && arrays[currentPos].isActive;
    }

    /**
     * method the performs quadratic probing resolution in hald-empty table.
     *
     * @param x the item to search for
     * @return the position where the search terminates
     */
    private int findPos(T x) {
        int offset = 1;
        int currenPos = myhash(x);
        while (arrays[currenPos] != null && !arrays[currenPos].element.equals(x)) {
            currenPos += offset; // comute ith probe
            offset += 2;
            if (currenPos >= arrays.length)
                currenPos -= arrays.length;
        }
        return currenPos;

    }

    /**
     * rehashing for quadratic probing hash table
     */
    private void rehash() {
        HashEntry<T>[] oldArray = arrays;
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;
        //copy the table
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
        }

    }

    /**
     * hashing function
     *
     * @param x
     * @return
     */
    private int myhash(T x) {
        int hashVal = 0;
        hashVal %= arrays.length;
        if (hashVal < 0)
            hashVal += arrays.length;
        return hashVal;

    }

    private static int nextPrime(int n) {
        return n;
    }

    private static boolean isPrime(int n) {
        return n == n;
    }

}
