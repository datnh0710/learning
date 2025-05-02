package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] arr = {"bella", "label", "roller"};
        System.out.printf("%s", commonChars(arr));

    }

//    static List<String> commonChars(String[] A) {
//        HashMap<Character, Integer> hashtable = new HashMap<>();
//
//        for (String str : A) {
//            int i = 0;
//            while (i < str.length()) {
//                char c = str.charAt(i++);
//                if (hashtable.containsKey(c)) {
//                    hashtable.put(c, hashtable.get(c) + 1);
//                }else{
//                    hashtable.put(c, 1);
//                }
//
//
//            }
//        }
//        List<String> list = new ArrayList<>();
//        for (Character c : hashtable.keySet()) {
//            int size = hashtable.get(c) / A.length;
//            for (int i = 0; i < size; i++) {
//                list.add(c.toString());
//            }
//
//        }
//        return list;
//    }

    static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[][] arr = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (Character ch : A[i].toCharArray()) {
                arr[i][ch - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < A.length; j++) {
                arr[0][i] = Math.min(arr[0][i], arr[j][i]);
            }
            for (int j = 0; j < arr[0][i]; j++) {
                list.add(Character.toString('a' + i));
            }
        }


        return list;
    }
}
