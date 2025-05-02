package com.Collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sort1 {
    public static void main(String[] args) {
        String[] colors = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> list = Arrays.asList(colors);
        System.out.printf("Unsorted array elements: %s%n", list);
        //Ascending sort
        Collections.sort(list);
        System.out.printf("Ascending Sorted array elements: %s%n", list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.printf("descendingSorted array elements: %s%n", list);
        //

    }
}
