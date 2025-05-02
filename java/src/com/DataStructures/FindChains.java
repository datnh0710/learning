package com.DataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindChains {
    public static void main(String[] args) {

    }

    /**
     * runs the  shortest path calculation from the adjacency map, returns a List
     * that contains the sequence of word changes to get from first to second.
     * return null if no sequence can be found for any reason
     *
     * @param adjacentWords
     * @param first
     * @param second
     * @return
     */
    public static List<String> findChain(Map<String, List<String>> adjacentWords, String first, String second) {
        Map<String, String> previousWord = new HashMap<>();
        LinkedList<String> q = new LinkedList<>();
        q.addLast(first);
        while (!q.isEmpty()) {
            String current = q.removeFirst();
            List<String> adj = adjacentWords.get(current);
            if (adj != null) {
                for (String adjWord : adj) {
                    if (previousWord.get(adjWord) == null) {
                        previousWord.put(adjWord, current);
                        q.addLast(adjWord);
                    }
                }
            }
        }
        previousWord.put(first, null);
        return getChainFromPreviousMap(previousWord, first, second);
    }

    /**
     * after the shortest path calculation has run, computes the List that
     * contains the sequence of word changes to get from first to second.
     * return null if there is no path.
     *
     * @param previousWord
     * @param first
     * @param second
     * @return
     */
    private static List<String> getChainFromPreviousMap(Map<String, String> previousWord, String first, String second) {
        LinkedList<String> result = null;
        if (previousWord.get(second) != null) {
            result = new LinkedList<>();
            for (String str = second; str != null; str = previousWord.get(str)) {
                result.addFirst(str);
            }
        }
        return result;
    }
}
