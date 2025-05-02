package com.Collection;

import java.util.*;

public class WordTypeCount {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        createMap(map); // create map based on user input
        displayMap(map); // display map content
    }

    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet(); // get keys

        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));
        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Enter a string:"); // prompt for user input
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase(); // get lowercase word
             // if the map contains the word
            if (map.containsKey(word)) // is word in map
            {
                int count = map.get(word); // get current count
                map.put(word, count + 1); // increment count
            } else
                map.put(word, 1);
        }
    }
}
