package com.leetcode;

import java.util.HashMap;
import java.util.Hashtable;

public class RansomNote {
    public static void main(String[] args) {
        String a = "bg";
        String b = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.printf("%b", canConstruct(a, b));

    }

    static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        HashMap<Character, Integer> hashtable = new HashMap<>();
        int j = 0;
        while (j < magazine.length()) {
            if (!hashtable.containsKey(magazine.charAt(j))) {
                hashtable.put(magazine.charAt(j), 1);

            } else {
                hashtable.put(magazine.charAt(j), hashtable.get(magazine.charAt(j)) + 1);
            }
            j++;

        }
        j = 0;
        while (j < ransomNote.length()) {
            if (!hashtable.containsKey(ransomNote.charAt(j))) {
                return false;
            } else {
                int val = hashtable.get(ransomNote.charAt(j)) - 1;
                if (val == 0) {
                    hashtable.remove(ransomNote.charAt(j));
                } else {
                    hashtable.put(ransomNote.charAt(j), val);
                }
            }
            j++;
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!hashmap.containsKey(magazine.charAt(i)))
                hashmap.put(magazine.charAt(i), 1);
            else
                hashmap.put(magazine.charAt(i), hashmap.get(magazine.charAt(i)) + 1);
        }

        int start = 0;
        while (start < ransomNote.length()) {
            if (!hashmap.containsKey(ransomNote.charAt(start)))
                return false;
            else {
                hashmap.put(ransomNote.charAt(start), hashmap.get(ransomNote.charAt(start)) - 1);
                if (hashmap.get(ransomNote.charAt(start)) == 0)
                    hashmap.remove(ransomNote.charAt(start));
            }

            start++;
        }

        //Never Accessed
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] count=new int[26];
        for (char c:magazine.toCharArray()) count[c-'a']++;
        for (char c:ransomNote.toCharArray()){
            if (--count[c-'a']<0) return false;
        }
        return true;
    }


}
