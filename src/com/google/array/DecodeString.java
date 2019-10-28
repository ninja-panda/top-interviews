package com.google.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class DecodeStringSolution {

    Set<Character> digits = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        Stack<Integer> frequencyStack = new Stack();
        Stack<String> alphabetStack = new Stack();
        char[] arr = s.toCharArray();
        String number = "";
        for (Character current : arr) {

            if (digits.contains(current)) {
                number = number + current;
            } else {
                if (number.length() > 0) {
                    int digit = parseInteger(number);
                    frequencyStack.push(digit);
                    number = "";
                }
                if (current != ']') {
                    alphabetStack.push(String.valueOf(current));
                } else if (current== ']') {
                    int frequency = frequencyStack.pop();
                    String temp = "";
                    while (!alphabetStack.peek().equals("[")) {
                        temp = temp + alphabetStack.pop();
                    }
                    // pop the opening [
                    alphabetStack.pop();
                   // temp = reverse(temp);
                    StringBuilder result = new StringBuilder();
                    while (frequency > 0) {
                        result.append(temp);
                        frequency--;
                    }
                    alphabetStack.push(result.toString());
                }
            }

        }
        String result = "";
        while (!alphabetStack.isEmpty()) {
            result = result + alphabetStack.pop();
        }
        result = reverse(result);
        return result;
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return String.valueOf(arr);
    }

    private int parseInteger(String num) {
        if (num == null) {
            return 0;
        }
        char[] charArray = num.toCharArray();
        int len = (charArray.length - 1);
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            int current = charArray[i] - '0';
            int radix = (int) Math.pow(10, len);
            result = result + current * radix;
            len--;
        }
        return result;
    }
}

public class DecodeString {

    public static void main(String[] args) {
        String s = "11[leetcode]";
        DecodeStringSolution decodeStringSolution = new DecodeStringSolution();
        String result = decodeStringSolution.decodeString(s);
        System.out.println(result);

        s = "3[a]2[bc]";
        result = decodeStringSolution.decodeString(s);
        System.out.println(result);

        s = "3[a2[c]]";
        result = decodeStringSolution.decodeString(s);
        System.out.println(result);

        s = "pq4[2[jk]]";
        result = decodeStringSolution.decodeString(s);
        System.out.println(result);
    }
}
