package com.Generic;

class ListNode<T> {
    T data;
    ListNode<T> nextNode;

    ListNode(T data) {
        this(data, null);
    }

    public ListNode(T data, ListNode<T> node) {
        this.data = data;
        nextNode = node;
    }

    T getData() {
        return data;
    }

    ListNode<T> getNext() {
        return this.nextNode;
    }
}
