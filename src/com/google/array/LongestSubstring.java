package com.google.array;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringSolution {

    // abcabcbb
    public String getLongestSubstring(String s) {
        if (s == null) {
            return null;
        }
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (!set.contains(current)) {
                set.add(current);
            } else if (set.iterator().next().equals((Character) current)) {
                set.remove(current);
                set.add(current);
            }
        }
        return set.toString();
    }
}

public class LongestSubstring {
}
