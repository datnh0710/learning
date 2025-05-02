package com.leetcode;


import java.util.ArrayList;
import java.util.List;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    private static class Node {
        int min;
        Node next;
        int value;

        public Node() {
            this(0, 0, null);
        }

        public Node(int min, int value, Node node) {
            this.min = min;
            this.value = value;
            this.next = node;
        }
    }

    Node tail;


    public MinStack() {
        tail = null;
    }


    public void push(int x) {
        if (tail == null) {
            tail = new Node(x, x, null);
        } else {
            tail = new Node(x < tail.min ? x : tail.min, x, tail);
        }

    }

    public void pop() {
        tail = tail.next;

    }

    public int top() {
        return tail.value;
    }

    public int getMin() {
        return tail.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
}
