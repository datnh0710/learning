package com.Collection;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        String[] colors = {"black", "yellow", "green", "blue", "violet", "silver"};

        List<String> list1 = new LinkedList<>();

        for (String color : colors) {
            list1.add(color);
        }

        String[] color2 = {"gold", "white", "brown", "blue", "gray", "silver"};

        List<String> list2 = new LinkedList<>();
        for (String color : color2) {
            list2.add(color);
        }

        list1.addAll(list2);
        list2 = null;

        convertToUppercaseStrings(list1);
        printList(list1); // print list1 elements

        System.out.printf("%nDeleting elements 4 to 6...");

        removeItems(list1, 4, 7); // remove items 4-6 from list

        printList(list1);

        printReversedList(list1); // print list in reverse order
    }

    private static void printReversedList(List<String> list1) {
        ListIterator<String> iterator = list1.listIterator(list1.size());
        System.out.printf("%nReversed List:%n");
        while (iterator.hasPrevious()) {
            System.out.printf("%s ", iterator.previous());
        }

    }

    private static void removeItems(List<String> list1, int start, int end) {
        list1.subList(start, end).clear();
    }

    private static void printList(Collection<String> list1) {
        System.out.printf("%nlist:%n");
        for (String color : list1) {
            System.out.printf("%s ", color);
        }
        System.out.printf("%n");
    }

    private static void convertToUppercaseStrings(List<String> list1) {
        ListIterator<String> iterator = list1.listIterator();
        while (iterator.hasNext()) {
            String color = iterator.next();
            iterator.set(color.toUpperCase());
        }

    }


}
