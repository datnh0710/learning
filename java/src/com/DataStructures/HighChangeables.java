package com.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HighChangeables {
    public static void main(String[] args) {

    }

    public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {

        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();
            if (words.size() >= minWords) {
                System.out.print(entry.getKey() + " (");
                System.out.print(words.size() + "):");
                for (String w : words)
                    System.out.print(" " + w);
                System.out.println();
            }
        }
    }

    private static boolean oneCharOff(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int diffs = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i))
                if (++diffs > 1)
                    return false;

        }
        return diffs == 1;
    }

    public static Map<String, List<String>> computeAdjacentWords(List<String> theWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();
        String[] words = new String[theWords.size()];

        theWords.toArray(words);

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (oneCharOff(words[i], words[j])) {
                    update(adjWords, words[i], words[j]);
                    update(adjWords, words[j], words[i]);
                }
            }
        }
        return adjWords;
    }

    private static <T> void update(Map<T, List<String>> m, T key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }
}
