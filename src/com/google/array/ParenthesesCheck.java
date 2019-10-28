package com.google.array;

import java.util.Stack;

public class ParenthesesCheck {

    public static void main(String[] args) {
        String s = "[])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char inChar : arr) {
            if (inChar == '(' || inChar == '{' || inChar == '[') {
                stack.push(inChar);
            } else {
                //')' or '}' or ']' occurred before a opening
                if (stack.isEmpty()) {
                    return false;
                }
                char fromStack = stack.pop();
                if (inChar == ')' && fromStack != '(') {
                    return false;
                } else if (inChar == '}' && fromStack != '{') {
                    return false;
                } else if (inChar == ']' && fromStack != '[') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
