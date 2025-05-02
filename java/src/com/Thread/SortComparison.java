package com.Thread;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SortComparison {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();

        int[] arr1 = secureRandom.ints(15_000_000).toArray();
        int[] arr2 = new int[arr1.length];

        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        System.out.println("Starting sort");
        Instant sortStart = Instant.now();
        Arrays.sort(arr1);
        Instant sortEnd = Instant.now();
        long sortTime = Duration.between(sortStart, sortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n%n", sortTime);


        System.out.println("Starting parallelSort");
        Instant parallelSortStart = Instant.now();
        Arrays.parallelSort(arr2);
        Instant parallelSortEnd = Instant.now();
        long parallelSortTime = Duration.between(parallelSortStart, parallelSortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n%n", parallelSortTime);

        String percentage = NumberFormat.getPercentInstance().format((double) sortTime / parallelSortTime);
        System.out.printf("%nsort took %s more time than parallelSort%n",
                percentage);


    }
}
