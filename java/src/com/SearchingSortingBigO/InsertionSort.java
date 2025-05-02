package com.SearchingSortingBigO;

import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        int data[] = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = generator.nextInt(100);
        }
        System.out.printf("Before sort: %s%n%n", Arrays.toString(data));
        insertionSort1(data);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%n%d", data[i]);
        }

    }

    public static void insertionSort(int[] arr) {
        int size = arr.length;
        if (size <= 1)
            return;
        int i = 1;
        while (i < size) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            i++;
        }
    }

    public static void insertionSort1(int[] arr) {
        int size = arr.length;
        if (size <= 1)
            return;
        int i = 1;
        while (i < size) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
                swap(arr, j + 1, j);
                j--;
            }
//            arr[j + 1] = key;
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
