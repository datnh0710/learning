package com.DataStructures;

public class MyTreeNode<T extends Comparable<T>> {
    T data;
    MyTreeNode<T> leftNode;
    MyTreeNode<T> rightNode;

    public MyTreeNode(T nodeData) {
        this.data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(T nodeData) {
        if (data.compareTo(nodeData) < 0) {
            if (leftNode == null) {
                leftNode = new MyTreeNode<>(nodeData);
            } else {
                leftNode.insert(nodeData);
            }
        } else {
            if (rightNode == null) {
                rightNode = new MyTreeNode<>(nodeData);
            } else {
                rightNode.insert(nodeData);
            }
        }
    }

    public MyTreeNode findMin() {
        return findMin(leftNode);
    }

    private MyTreeNode findMin(MyTreeNode<T> node) {
        if (node == null)
            return null;
        if (node.leftNode == null)
            return node;
        return findMin(node.leftNode);
    }


}
