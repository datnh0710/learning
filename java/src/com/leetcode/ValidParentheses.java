package com.leetcode;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.printf("%b", isValid("(]"));

    }
    public static boolean isValid(String s) {
        if (s.length()<=1)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] =='(' || characters[i] == '[' || characters[i] == '{'){
                stack.push(characters[i]);
                continue;
            }else{
                if (!stack.isEmpty())
                    return false;
                char tmp= stack.pop();
                if (characters[i] == ')' && tmp!='(')
                    return false;
                else if(characters[i] == '}' && tmp!='{')
                    return false;
                else if (characters[i] == ']' && tmp!='[')
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;



        return true;

    }
    public static boolean isValid1(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")){
            s.replace("()","");
            s.replace("{}","");
            s.replace("[]","");
        }
        if(s.length()==0){
            return true;
        }
        return false;

    }
}
