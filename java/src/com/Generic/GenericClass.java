package com.Generic;


public class GenericClass {
    public static void main(String[] args) {
//        printT(new Integer[]{1, 2, 3, 4, 5, 6});
//        System.out.printf("Max of %d %d %d is: %d", 1,2,3,maximum(1,2,3));

//        double[] doubleElements = {1, 2, 3, 4, 5, 6, 7, 8};
        Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8};
//        int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

//        Stack<Double> doubleStack = new Stack<>(8);
        Stack doubleStack = new Stack<>(8);
        Stack<Integer> integerStack = new Stack<>();
//        testPushDouble(doubleStack, doubleElements);
//        testPopDouble(doubleStack);
//
//        testPushInteger(integerStack, integerElements);
//        testPopInteger(integerStack);
        testPush("doubleStack", doubleStack, doubleElements);
        testPop("doubleStack", doubleStack);

        testPush("integerStack", integerStack, integerElements);
        testPop("integerStack", integerStack);
    }

    private static <T> void testPush(String name, Stack<T> stack, T[] elements) {
        System.out.printf("%nPushing elements onto integerStack %s%n", name);
        for (T value : elements) {
            System.out.printf("%s ", value);
            stack.push(value);

        }
    }

    private static <T> void testPop(String name, Stack<T> stack) {
        try {
            System.out.printf("%nPopping elements from integerStack %s%n", name);
            T popValue;
            while (true) {
                popValue = stack.pop();
                System.out.printf("%s ", popValue);
            }
        } catch (EmptyStackException emptyStackException) {
            System.err.println();
            emptyStackException.printStackTrace();

        }
    }

    private static void testPopInteger(Stack<Integer> integerStack) {
        try {
            System.out.printf("%nPopping elements from integerStack%n");
            int popValue;
            while (true) {
                popValue = integerStack.pop();
                System.out.printf("%d ", popValue);
            }
        } catch (EmptyStackException emptyStackException) {
            System.err.println();
            emptyStackException.printStackTrace();

        }
    }

    private static void testPushInteger(Stack<Integer> integerStack, int[] integerElements) {
        System.out.printf("%nPushing elements onto integerStack%n");
        for (Integer integer : integerElements) {
            System.out.printf("%d ", integer);
            integerStack.push(integer);

        }
    }

    private static void testPopDouble(Stack<Double> doubleStack) {
        try {
            System.out.printf("%nPopping elements from doubleStack%n");
            double popValue;
            while (true) {
                popValue = doubleStack.pop();
                System.out.printf("%.1f ", popValue);
            }
        } catch (EmptyStackException emptyStackException) {
            System.err.println();
            emptyStackException.printStackTrace();

        }
    }

    private static void testPushDouble(Stack<Double> doubleStack, double[] doubleElements) {
        System.out.printf("%nPushing elements onto doubleStack%n");
        for (double value : doubleElements) {
            System.out.printf("%.1f ", value);
            doubleStack.push(value);
        }
    }


    static <T> void printT(T[] arr) {
        for (T val : arr) {
            System.out.printf("%s ", val);
        }
        System.out.printf("%n");
    }

    static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0)
            max = y;
        if (z.compareTo(max) > 0)
            max = z;
        return max;
    }
}
