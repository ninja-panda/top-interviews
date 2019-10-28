package com.google.array;

import java.util.HashMap;
import java.util.Map;

class StrobogrammaticNumber {

    public static void main(String[] args) {
        String number = "2323";
        Solution solution = new Solution();
        System.out.println(solution.isStrobogrammatic(number));
    }
}

class Solution {

    public boolean isStrobogrammatic(String num) {

        if (num == null || num.length() == 0) {
            return false;
        }
        Map<Character, Character> dictionary = new HashMap<>();
        dictionary.put('0', '0');
        dictionary.put('1', '1');
        dictionary.put('6', '9');
        dictionary.put('8', '8');
        dictionary.put('9', '6');

        char[] arr = num.toCharArray();
        for (int i = 0, j = (arr.length - 1); i < j; i++, j--) {
            char current = arr[i];
            Character value = dictionary.get(current);
            if (value == null) {
                return false;
            }
            if (value != arr[j]) {
                return false;
            }
        }
        return true;
    }
}
