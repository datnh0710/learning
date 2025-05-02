package com.DataStructures;

public class MyTree<T extends Comparable<T>> {
    MyTreeNode<T> root;

    public MyTree() {
        root = null;
    }

    public void insertNode(T nodeData) {
        if (root == null) {
            root = new MyTreeNode<>(nodeData);
        } else {
            root.insert(nodeData);
        }

    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(MyTreeNode<T> root) {
        if (root == null)
            return;
        System.out.printf("%s", root.data);
        preorderTraversal(root.leftNode);
        preorderTraversal(root.rightNode);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(MyTreeNode<T> root) {
        if (root == null)
            return;
        inorderTraversal(root.leftNode);
        System.out.printf("%s", root.data);
        inorderTraversal(root.rightNode);
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(MyTreeNode<T> root) {
        if (root == null)
            return;
        postorderTraversal(root.leftNode);
        postorderTraversal(root.rightNode);
        System.out.printf("%s", root.data);

    }


}
