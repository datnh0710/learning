package com.Generic;

public class StackInheritanceTest {
    public static void main(String[] args) {
        StackInheritance<Integer> stack = new StackInheritance<>();
        stack.push(-1);
        stack.print();
        stack.push(0);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(5);
        stack.print();

        try{
            int removeItem;
            while (true){
                removeItem = stack.pop();
                System.out.printf("%n%d popped%n", removeItem);
                stack.print();
            }
        }catch (EmptyListException emptyListException){
            emptyListException.printStackTrace();
        }
    }

}
