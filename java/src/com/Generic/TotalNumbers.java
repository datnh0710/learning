package com.Generic;

import java.util.ArrayList;

public class TotalNumbers {
    public static void main(String[] args) {
        Number[] numbers = {1, 2.4, 3, 4.1};
        ArrayList<Number> numberList = new ArrayList<>();
        for (Number element : numbers)
            numberList.add(element);
        System.out.printf("numberList contains: %s%n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f%n", sum(numberList));

        System.out.printf("Total of the elements in numberList1: %.1f%n", sum1(numberList));


        Integer[] integers = {1, 2, 3, 4, 5};
        ArrayList<Integer> integerList = new ArrayList<>();

        // insert elements in integerList
        for (Integer element : integers)
            integerList.add(element);

        System.out.printf("integerList contains: %s%n", integerList);
        System.out.printf("Total of the elements in integerList: %.0f%n%n",
                sum1(integerList));

        Integer[] integers2 = {1, 2, 3, 4, 5};
        ArrayList<Integer> integerList2 = new ArrayList<>();

        // insert elements in integerList
        for (Integer element : integers2)
            integerList2.add(element);

        System.out.printf("integerList2 contains: %s%n", integerList2);
        System.out.printf("Total of the elements in integerList2: %.0f%n%n",
                sum1(integerList2));

    }

    private static double sum(ArrayList<Number> numberList) {
        double sum = 0.0;
        for (Number value : numberList) {
            sum += value.doubleValue();
        }
        return sum;
    }

    private static double sum1(ArrayList<? extends Number> numberList) {
        double sum = 0.0;
        for (Number value : numberList) {
            sum += value.doubleValue();
        }
        return sum;
    }

    private static <T extends Number> double sum2(ArrayList<T> numberList) {
        double sum = 0.0;
        for (Number value : numberList) {
            sum += value.doubleValue();
        }
        return sum;
    }
}
