package com.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        String[] colors = {"red", "white", "blue", "black", "yellow", "purple", "tan", "pink"};
        List<String> stringList = new ArrayList<>(Arrays.asList(colors));
        Collections.sort(stringList);
        System.out.printf("Sorted ArrayList: %s%n", stringList);


        printSearchResults(stringList, "black"); // first item
        printSearchResults(stringList, "red"); // middle item
        printSearchResults(stringList, "pink"); // last item
        printSearchResults(stringList, "aqua"); // below lowest
        printSearchResults(stringList, "gray"); // does not exist
        printSearchResults(stringList, "teal"); // does not exist
    }

    private static void printSearchResults(List<String> stringList, String key) {
        int result = 0;
        System.out.printf("%nSearching for: %s%n", key);
        result = Collections.binarySearch(stringList, key);
        if (result>=0){
            System.out.printf("Found at index %d%n", result);
        }else{
            System.out.printf("Not Found (%d)%n",result);
        }
    }
}
