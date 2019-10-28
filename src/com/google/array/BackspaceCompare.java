package com.google.array;

import java.util.Stack;

/**
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 */

class BackspaceCompareSolution {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = getStack(S);
        Stack<Character> stack2 = getStack(T);
        return stack1.equals(stack2);
    }

    private Stack<Character> getStack(String s) {
        Stack<Character> stack = new Stack<>();
        char arr[] = s.toCharArray();
        for (char current : arr) {
            if (current != '#') {
                stack.push(current);
            } else if (current == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }
}

public class BackspaceCompare {
}
