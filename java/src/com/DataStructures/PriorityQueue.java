package com.DataStructures;


import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue <T> extends AbstractCollection<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize; // Number of elements in heap
    private T[] array;
    private Comparator<? super T> cmp;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }
}
