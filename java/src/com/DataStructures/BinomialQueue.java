package com.DataStructures;

import javax.management.DescriptorAccess;
import java.awt.desktop.PrintFilesEvent;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinomialQueue<T extends Comparable<? super T>> {
    private static class Node<T> {
        //constructors
        Node(T theElement) {
            this(theElement, null, null);
        }

        Node(T theElement, Node<T> lt, Node<T> rt) {
            element = theElement;
            leftChild = lt;
            nextSibling = rt;
        }

        T element; // data in the node
        Node<T> leftChild; // left child
        Node<T> nextSibling; // right child
    }

    private static final int DEFAULT_TREES = 1;
    private int currentSize; //# items in priority queue
    private Node<T>[] theTrees; // An Array of tree roots

    public BinomialQueue() {
        theTrees = new Node[DEFAULT_TREES];
    }

    public BinomialQueue(T x) {
        currentSize = 0;
        theTrees = new Node[DEFAULT_TREES];
        insert(x);

    }

    /**
     * merge rhs into the priority queue
     * rhs becomes empty. Rhs must be different from this
     *
     * @param rhs the order binomial queue
     */
    public void merge(BinomialQueue<T> rhs) {
        if (rhs == null) //avoid aliasing problems
            return;
        currentSize += rhs.currentSize;
        if (currentSize > capacity()) {
            int maxLength = Math.max(theTrees.length, rhs.theTrees.length);
            expandTheTrees(maxLength + 1);
        }
        Node<T> carry = null;
        for (int i = 0, j = 1; j <= currentSize; i++, j *= 2) {
            Node<T> t1 = theTrees[i];
            Node<T> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;

            int whichCase = t1 == null ? 0 : 1;
            whichCase += t2 == null ? 0 : 2;
            whichCase += carry == null ? 0 : 4;

            switch (whichCase) {
                case 0:// no tree
                    break;
                case 1:// only this
                    break;
                case 2: //only rhs
                    theTrees[i] = t2;
                    rhs.theTrees[i] = null;
                    break;
                case 4://only carry
                    theTrees[i] = carry;
                    carry = null;
                    break;
                case 3://this and rhs
                    carry = combineTrees(t1, t2);
                    theTrees[i] = rhs.theTrees[i] = null;
                    break;
                case 5: //this and carry
                    carry = combineTrees(t1, carry);
                    theTrees[i] = null;
                    break;
                case 6: //rhs and carry
                    carry = combineTrees(t2, carry);
                    rhs.theTrees[i] = null;
                    break;
                case 7://all tree
                    theTrees[i] = carry;
                    carry = combineTrees(t1, t2);
                    rhs.theTrees[i] = null;
                    break;
            }
            for (int k = 0; k < rhs.theTrees.length; k++) {
                rhs.theTrees[k] = null;

            }
            rhs.currentSize = 0;
        }
    }

    public void insert(T x) {
        merge(new BinomialQueue<>(x));
    }

    public T findMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        else
            return theTrees[findMinIndex()].element;
    }

    /**
     * remove the smallest item from the priority queque
     *
     * @return the smallest item, or throw exception if empty
     */
    public T deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        int minIndex = findMinIndex();
        T minItem = theTrees[minIndex].element;
        Node<T> deletedTree = theTrees[minIndex].leftChild;
        //construct H'
        BinomialQueue<T> deletedQueue = new BinomialQueue<>();
        deletedQueue.expandTheTrees(minIndex + 1);
        deletedQueue.currentSize = (1 << minIndex) - 1;
        for (int i = minIndex - 1; i >= 0; i--) {
            deletedQueue.theTrees[i] = deletedTree;
            deletedTree = deletedTree.nextSibling;
            deletedQueue.theTrees[i].nextSibling = null;


        }
        //construct H'
        theTrees[minIndex] = null;
        currentSize -= deletedQueue.currentSize + 1;
        merge(deletedQueue);
        return minItem;


    }

    public boolean isEmpty() {
        return currentSize == 0;

    }

    public void makeEmpty() {
        currentSize = 0;
        theTrees = null;
    }

    private void expandTheTrees(int newNumTrees) {

    }

    /**
     * return the result of merging equal-sized t1 and t2
     *
     * @param t1
     * @param t2
     * @return
     */
    private Node<T> combineTrees(Node<T> t1, Node<T> t2) {
        if (t1.element.compareTo(t2.element) > 0) {
            return combineTrees(t2, t1);
        }
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    private int capacity() {
        return (1 << theTrees.length) - 1;
    }

    private int findMinIndex() {
        if (isEmpty())
            throw new NoSuchElementException();
        return 1;
    }

}
