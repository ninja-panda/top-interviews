package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class StringProblem1 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] arr = s.toCharArray();
        int maxLength = 0;
        int curlen = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            char current = arr[i];
            Integer index = seen.get(current);
            if (index == null) {
                seen.put(current, i + 1);
                curlen++;
            } else {
                curlen = curlen - index;
            }
        }
        return curlen;
    }
}
