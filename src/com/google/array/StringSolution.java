package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class StringSolution {

    public static void main(String[] args) {
       /* String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));*/
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int maxLength = -1;
        int currentLength = 0;
        char[] arr = s.toCharArray();
        Map<Character,Boolean> map = new HashMap<>();
        for(char c : arr){
            if(map.get(c) == null){
                map.put(c,true);
                currentLength ++;
            }else{
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }
        if(currentLength > maxLength){
            maxLength = currentLength;
        }
        return maxLength;
    }
}
