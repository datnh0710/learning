package com.DataStructures;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T data) {
            this(data, null, null);
        }

        BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = data;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    private int height(BinaryNode<T> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty())
            throw new NoSuchElementException();
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {

    }

    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            return contains(x, t.right);
        } else if (compareResult < 0) {
            return contains(x, t.left);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        return findMin(root.left);
    }

    private BinaryNode<T> findMin1(BinaryNode<T> root) {
        if (root == null)
            return null;
        else {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root == null)
            return null;
        else if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    private BinaryNode<T> findMax1(BinaryNode<T> root) {
        if (root == null)
            return null;
        else {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }


    private BinaryNode<T> insert(T x, BinaryNode<T> root) {
        if (root == null)
            return new BinaryNode<>(x, null, null);
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            root.left = insert(x, root.left);
        } else if (compareResult > 0) {
            root.right = insert(x, root.right);
        } else
            ;
        return root;

    }

    /**
     * @param x    the item to remove
     * @param root the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> root) {
        if (root == null)
            return root; // item not found, do nothing
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0)
            root.left = remove(x, root.left);
        else if (compareResult > 0)
            root.right = remove(x, root.right);
        else if (root.left != null && root.right != null) { // 2 children and x equal root.element
            root.element = findMin(root.right).element; // find min of right subtree and replace it to the delete note
            root.right = remove(root.element, root.right);
        } else {
            root = (root.left != null) ? root.left : root.right;// x equal to root.element and doesn't have 2 children node
        }

        return root;


    }

    private void printTree(BinaryNode<T> t) {
        if (t == null)
            return;
        else {
            printTree(t.left);
            System.out.printf("%d", t.element);
            printTree(t.right);
        }

    }


}
