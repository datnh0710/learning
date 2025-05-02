package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        lengthOfLongestSubstring1("pwwkew");

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int current = 0;
        char[] c = s.toCharArray();
        for (char cc : c) {
            if (map.containsKey(cc)) {
                if (count <= current)
                    count = current;
                map.clear();
                map.put(cc, 0);
                current = 1;
            } else {
                map.put(cc, 0);
                current++;
            }
        }
        return count >= current ? count : current;

    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (set.contains(cc)) {
                if (count <= set.size())
                    count = set.size();
                set.remove(cc);
            } else {
                set.add(cc);
//                current++;
            }
        }
        return count >= set.size() ? count : set.size();

    }
}
