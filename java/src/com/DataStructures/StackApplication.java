package com.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackApplication {
    public static void main(String[] args) {
        String s = "{{([)}}";
        System.out.printf("%b", balacingSysbols(s));

    }

    public static boolean balacingSysbols(String s) {
        if (s.isEmpty())
            return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                Character tmpC = stack.pop();
                if (c == ')' && tmpC != '(')
                    return false;
                if (c == '}' && tmpC != '{')
                    return false;
                if (c == ']' && tmpC != ']')
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;

        return true;
    }

    public static int postfixExpression(String s) {
        if (s.isEmpty())
            return -1;
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int tmp = 0;
                if (c == '*')
                    tmp = a * b;
                if (c == '-')
                    tmp = a - b;
                if (c == '+') {
                    tmp = a + b;
                }
                if (c == '/')
                    tmp = a / b;
                stack.push((char) tmp);
            }
        }

        return (int) stack.pop();

    }

    public static List infixExpression(String s) {
        if (s.isEmpty())
            return null;
        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(c);
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == '+' || c == '-') {
                    list.add(stack.pop());
                    Character tmp = stack.pop();
                    if (tmp != '(') {
                        list.add(tmp);
                    } else {
                        stack.push(tmp);
                        stack.push(c);
                    }
                }

            }

        }
        return list;
    }
}
