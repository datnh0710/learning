package com.Generic;

public class List<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name;

    public List() {
        this("list");

    }

    public List(String listName) {
        this.name = listName;
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void insertAtFront(T insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<T>(insertItem);
            return;
        } else {
            firstNode = new ListNode<>(insertItem, firstNode);
        }
    }

    public void insertAtBack(T insertItem) {
        if (isEmpty())
            firstNode = lastNode = new ListNode<>(insertItem);
        else {
            lastNode = lastNode.nextNode = new ListNode<>(insertItem);
        }
    }

    public T removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);
        T removeItem = firstNode.data;

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;
        return removeItem;
    }

    public T removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);
        T removeItem = lastNode.data;
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            ListNode<T> curr = firstNode;
            while (curr.nextNode != lastNode) {
                curr = curr.nextNode;
            }
            lastNode = curr;
            curr.nextNode = null;
        }
        return removeItem;
    }

    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }
        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
        System.out.println() ;
    }

}
