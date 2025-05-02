package com.DataStructures;

public class AVLTree<T extends Comparable<? super T>> {
    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T element) {
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> leftNode, AvlNode<T> rightNode) {
            this.element = element;
            left = leftNode;
            right = rightNode;
            height = 0;
        }
    }

    private int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            return new AvlNode<T>(x);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else
            ;
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t); // case 1 in left side--> rotate left to right
            } else {
                t = doubleWithLeftChild(t); // case 2 in left side--> rotate right --> left
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t); // case 3 in right side --> rotate right  to left
            } else {
                t = doubleWithRightChild(t);// case 4 in right side --> rotate left to right
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;// update "t" height after balancing
        return t; // return "t" with new element and new height
    }

    /**
     * rotate binary tree node with left child
     * For AVL trees, this is a single rotation for case 1
     * Update height, then return new root
     *
     * @param k2
     * @return the new root of the subtree
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;


    }

    /**
     * rotate binary tree node with right child
     * For AVL trees, this is a single rotation for case 3
     * Update height, then return new root
     *
     * @param k2
     * @return the new root of the subtree
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    /**
     * Double tree binary tree node, first left child
     * with its right child, then node k3 with new left child
     * For AVL tree, this is a double rotation for case 2
     * Update height, then return new root
     *
     * @param k3
     * @return the new root of the subtree
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);

    }

    /**
     * Double tree binary tree node, first right child
     * with its left child, then node k3 with new right child
     * For AVL tree, this is a double rotation for case 4
     * Update height, then return new root
     *
     * @param k3
     * @return the new root of the subtree
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    /**
     * Internal method to remove from a subtree
     *
     * @param x the item to remove
     * @param t the node that roots the subtree.
     * @return the new root of the subtree
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {// 2 children and x equal root.element
            t.element = findMin(t.right).element; // find min of right subtree and replace it to the delete note
            t.right = remove(t.element, t.right); // remove the min of right subtree which just replaces for root
        } else
            t = (t.left != null) ? t.left : t.right; // x equal to root.element and doesn't have 2 children node
        return balance(t);
    }

    /**
     * internal method find the min node opf tree
     *
     * @param t
     * @return the min node
     */
    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null)
            return t;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * internal method find the max node of tree
     *
     * @param t
     * @return the max node
     */
    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t == null)
            return t;
        else if (t.right == null)
            return t;
        return findMax(t.right);
    }

    /**
     * internal method to check x in Avl tree or not
     *
     * @param x
     * @param t
     * @return true or false
     */
    private boolean contains(T x, AvlNode<T> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            return contains(x, t.right);
        } else if (compareResult < 0) {
            return contains(x, t.left);
        } else
            return true;
    }


}
