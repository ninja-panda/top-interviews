package com.google.array;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringSolution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        // The set will be used as a Sliding Window
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            char current = s.charAt(right);
            /**
             *  If right is not in the Window then add
             *  it to current Window and calculate the
             *  current max length
             */
            if (!set.contains(current)) {
                set.add(current);
                right++;
                maxLength = Math.max(maxLength, (right - left));
            } else {
                /**
                 *  If duplicate character is found in the right side,
                 *  then remove one from character from left and side
                 *  and advance the left pointer by 1
                 */

                char toRemove = s.charAt(left);
                set.remove(toRemove);
                left++;
            }
        }
        return maxLength;
    }
}

public class LongestSubstring {
}
