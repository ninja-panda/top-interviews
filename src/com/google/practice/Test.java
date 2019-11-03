package com.google.practice;

import java.util.Collections;
import java.util.HashMap;


public class Test {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
       if(s == null || s.length() == 0){
           return 0;
       }
       if(s.length() < 3){
           return s.length();
       }
    }


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
