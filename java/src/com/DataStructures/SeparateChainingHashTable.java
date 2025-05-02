package com.DataStructures;


import java.util.LinkedList;
import java.util.List;

/**
 * Class Separate chain hash table uses link list
 *
 * @param <T>
 */
public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 10;
    private List<T>[] theLists;
    private int currentSize;

    /**
     * Construct the hash table
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Contruct the hash table with new size
     *
     * @param size approximate table size
     */
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
    }

    /**
     * Insert into the hash table. if the item is
     * already present, the do nothing
     *
     * @param x
     */
    public void insert(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            // rehash
            if (++currentSize > theLists.length)
                rehash();
        }


    }

    /**
     * remove from the hash table
     *
     * @param x the item to remove
     */
    public void remove(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            --currentSize;
        }
    }

    /**
     * find an item in the hash table
     *
     * @param x the item to search for
     * @return true if x is  found
     */
    public boolean contains(T x) {
        List<T> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    /**
     * make the hash table logically empty
     */
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;

    }

    /**
     * rehashing for separate chaining hash table
     */
    private void rehash() {
        List<T>[] oldArray = theLists;

        theLists = new LinkedList[nextPrime(oldArray.length * 2)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        //copy the table
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            for (T item : oldArray[i]) {
                insert(item);
            }
        }


    }

    /**
     * hashing function
     * @param x
     * @return
     */
    private int myhash(T x) {
        int hashVal = 0;
        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
        return hashVal;

    }

    private static int nextPrime(int x) {
        return x;
    }

    private static boolean isPrime(int n) {
        return n == n;
    }

}
