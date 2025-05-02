package com.SearchingSortingBigO;

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
//        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        SecureRandom generator = new SecureRandom();
        int data[] = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = generator.nextInt(100);
        }
        System.out.printf("Before sort: %s%n%n", Arrays.toString(data));
        selectionSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%n%d", data[i]);
        }

    }

    public static void selectionSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
