package com.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseVowelsofaString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.printf("%s", reverseVowels(s));
    }

    static String reverseVowels(String s) {
        if (s.length() <= 1)
            return s;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (set.contains(arr[l]) && set.contains(arr[r])) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
                continue;
            }
            if (!set.contains(arr[l]))
                l++;
            if (!set.contains(arr[r]))
                r--;

        }
        return String.valueOf(arr);

    }

    static String reverseVowels1(String s) {
        if (s.length() <= 1)
            return s;
        char[] a = s.toCharArray();
        int left = 0;
        int right = a.length - 1;
        while(left < right){
            if((a[left]=='a' || a[left]=='e' || a[left]=='i' || a[left]=='o' || a[left]=='u' || a[left]=='A'  || a[left]=='E' || a[left]=='I' || a[left]=='O' || a[left]=='U')  &&  (a[right]=='a' || a[right]=='e' || a[right]=='i' || a[right]=='o' || a[right]=='u' || a[right]=='A'  || a[right]=='E' || a[right]=='I' || a[right]=='O' || a[right]=='U'))
            {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left ++;   right --;
            }
            else if((a[left]=='a' || a[left]=='e' || a[left]=='i' || a[left]=='o' || a[left]=='u' || a[left]=='A'  || a[left]=='E' || a[left]=='I' || a[left]=='O' || a[left]=='U')  &&  (a[right]!='a' || a[right]!='e' || a[right]!='i' || a[right]!='o' || a[right]!='u' || a[right]!='A'  || a[right]!='E' || a[right]!='I' || a[right]!='O' || a[right]!='U'))
                right --;
            else
                left ++;
        }
        return String.valueOf(a);

    }
}
