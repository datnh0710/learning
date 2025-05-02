package com.Collection;


import java.util.Arrays;
import java.util.LinkedList;


public class UsingToArray {
    public static void main(String[] args) {
        String[] colors = {"black", "blue", "yellow"};
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(colors));
        linkedList.addLast("red"); // add as last item
        linkedList.add("pink");// add to the end
        linkedList.add(3, "green"); //add at 3rd index
        linkedList.addFirst("cyan");// add first

        colors = linkedList.toArray(new String[linkedList.size()]);
        System.out.println("colors: ");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
