package com.DataStructures;

import java.util.NoSuchElementException;

public class LeftistHeap<T extends Comparable<? super T>> {
    private static class Node<T> {
        T element;// data of node
        Node<T> left; // left child of node
        Node<T> right; // right child of node
        int nlp; //null path length

        Node(T x) {
            this(x, null, null);
        }

        Node(T x, Node<T> lt, Node<T> rt) {
            element = x;
            left = lt;
            right = rt;
            nlp = 0;
        }
    }

    private Node<T> root;

    public LeftistHeap() {
        root = null;
    }

    /**
     * merge rhs into the priority queue
     * rhs becomes empty. rhs must be different from this
     *
     * @param rhs the other leftist heap
     */
    public void merge(LeftistHeap<T> rhs) {
        if (this == rhs)
            return; // avoid aliasing problems
        root = merge(root, rhs.root);
        rhs.root = null;

    }

    /**
     * insert into the priority queue, maintaining heap order
     *
     * @param x the item to insert
     */
    public void insert(T x) {
        root = merge(new Node<>(x), root);
    }

    /**
     * remove the smallest item from the priority queue
     *
     * @return the smallest item, or throw exception if empty
     */
    public T deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        T minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;

    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    /**
     * @return the element min
     */
    public T findMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        return findMin(root).element;
    }

    private Node<T> findMin(Node<T> root) {
        if (root == null)
            return root;
        else if (root.left == null)
            return root.left;
        return findMin(root.left);
    }


    /**
     * internal method  to merge two roots
     * deals with deviant cases and calls recursive merge1
     *
     * @param h1
     * @param h2
     * @return
     */
    private Node<T> merge(Node<T> h1, Node<T> h2) {
        if (h1 == null)
            return h2;
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        } else
            return merge1(h2, h1);

    }

    /**
     * internal method to merge two roots
     * Assumes trees are not empty, and h1's root contains smallest item.
     *
     * @param h1
     * @param h2
     * @return
     */
    private Node<T> merge1(Node<T> h1, Node<T> h2) {
        if (h1.left == null) // single node
            h1.left = h2; //other fields in all h1 already accurate
        else {
            h1.right = merge(h1.right, h2);
            if (h1.left.nlp < h1.right.nlp) {
                swapChildren(h1);
            }
            h1.nlp = h1.right.nlp + 1;
        }
        return h1;

    }

    private void swapChildren(Node<T> t) {

    }
}
