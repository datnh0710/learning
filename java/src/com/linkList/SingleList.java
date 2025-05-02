package com.linkList;

import java.util.LinkedList;

public class SingleList {
    Node head;

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void addFirst(int d) {
        Node n = head;
        if (n == null) {
            head = new Node(d);
            return;
        } else {
            Node new_head = new Node(d);
            new_head.next = head;
            head = new_head;
        }
        return;


    }

    public void addLast(int d) {
        Node n = head;
        if (n == null) {
            head = new Node(d);
            return;
        } else {
            while (n.next != null) {
                n = n.next;
            }
            Node last_node = new Node(d);
            n.next = last_node;
        }
    }

    public Boolean remove(int d) {
        Node temp = head, prev = temp;

        if (temp.data == d) {
            head = head.next;
            return true;
        }
        while (temp != null && temp.data != d) {
            prev = temp;
            temp = temp.next;
        }
        // check if the key was not present in the list
        if (temp == null) {
            return false;
        }
        prev.next = temp.next;


        return true;
    }
    public Boolean removeIndex(int index){
        //check list == null
        if (head== null){
            return false;
        }
        Node temp = head;
        // check index == 0
        if (index==0){
            head=temp.next;
        }
        for (int i = 0; temp!=null && i < index-1 ; i++) {
            temp=temp.next;
        }
        // check over index
        if (temp==null || temp.next == null){
            return false;
        }
        Node next = temp.next.next;
        temp.next = next;
        return true;
    }

    public static void main(String[] args) {
        SingleList ll = new SingleList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);


        ll.head.next = second;
        second.next = third;

        ll.addFirst(0);
        ll.addLast(4);
        ll.remove(3);

//        ll.printList();

//        ll.removeIndex(3);

        ll.printList();



    }

}

