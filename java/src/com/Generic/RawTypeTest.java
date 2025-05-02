package com.Generic;

public class RawTypeTest {
    public static void main(String[] args) {

        Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8};
        Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Stack rawTypeStack1 = new Stack(8);
        Stack rawTypeStack2 = new Stack<>(8);
        Stack<Integer> integerStack = new Stack<>(10);

        testPush("rawTypeStack1", rawTypeStack1, doubleElements);
        testPop("rawTypeStack1", rawTypeStack1);

        testPush("rawTypeStack2", rawTypeStack2, doubleElements);
        testPop("rawTypeStack2", rawTypeStack2);

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
}
