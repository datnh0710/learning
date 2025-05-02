package com.DataStructures;

import java.lang.ref.PhantomReference;
import java.util.Random;
import java.util.WeakHashMap;

public class CuckooHashTable<T> {

    /**
     * construct the hash table
     *
     * @param hf the hash family
     */
    public CuckooHashTable(HashFamily<? super T> hf) {
        this(hf, DEFAULT_TABLE_SIZE);

    }

    /**
     * construct the hash table
     *
     * @param hf   the hash family
     * @param size the approximate initial size
     */
    public CuckooHashTable(HashFamily<? super T> hf, int size) {
        allocateArray(size);
        doClear();
        hashFunctions = hf;
        numHashFunctions = hashFunctions.getNumberOfFunction();
    }

    public void makeEmpty() {
        doClear();
    }

    /**
     * find an item in the hash table
     *
     * @param x the item to search for.
     * @return true if item is found
     */
    public boolean contains(T x) {
        return findPos(x) != -1;
    }

    /**
     * compute the hash code for x using specified hash function
     *
     * @param x     the item
     * @param which the hash function
     * @return the hash code
     */
    private int myhash(T x, int which) {
        int hashVal = hashFunctions.hash(x, which);
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }


    /**
     * method that searches all has function places
     *
     * @param x the item to  search for.
     * @return the position where the search terminates, or -1 if not found
     */
    private int findPos(T x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = hashFunctions.hash(x, i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }
        return -1;
    }

    /**
     * remove from the hash table
     *
     * @param x the item to remove
     * @return true if item was found and removed
     */
    public boolean remove(T x) {

        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }

        return pos != -1;
    }

    /**
     * insert into the hash table. if the item is
     * already present , return table
     *
     * @param x the item to insert
     * @return
     */
    public boolean insert(T x) {
        if (contains(x))
            return false;
        if (currentSize >= array.length * MAX_LOAD) {
            expand();
        }
        return insertHelper1(x);
    }

    private int rehashes = 0;
    private Random r = new Random();

    private boolean insertHelper1(T x) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x, i);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }
                //none of the spots are available. Evict out a random one
                int i = 0;
                do {
                    pos = myhash(x, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);

                T tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
            }
            if (++rehashes > ALLOWED_REHASHES) {
                expand(); // make the table bigger
                rehashes = 0; //reset the # of rehashes
            } else {
                rehash(); // same table size, new hash functions
            }
        }
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));

    }

    private void rehash() {
        hashFunctions.generateNewFunction();
        rehash(array.length);

    }

    private void rehash(int newLenght) {
        T[] oldArray = array;
        allocateArray(nextPrime(newLenght));
        currentSize = 0;
        for (T str : oldArray)
            if (str != null)
                insert(str);
    }

    /**
     * example next Prime == not real
     * @param newLenght
     * @return
     */
    private int nextPrime(int newLenght) {
        return newLenght + 1;
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }

    }

    private void allocateArray(int arraySize) {
        array = (T[]) new Object[arraySize];
    }

    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super T> hashFunctions;
    private final int numHashFunctions;
    private T[] array;
    private int currentSize;
}
