package com.google.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class IsomorphicStringUtil {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character,Character> map = new HashMap<>();
        Set<Character> uniqueFromT = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            char fromS = s.charAt(i);
            char fromT = t.charAt(i);
            Character mapping = map.get(fromS);
            if(mapping == null){
                if(!uniqueFromT.add(fromT)){
                    return false;
                }
                map.put(fromS,fromT);
            }
            else if(!mapping.equals(fromT)){
                return false;
            }
        }
        return true;
    }
}

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "ab" , t ="aa";
        IsomorphicStringUtil isomorphicStringUtil = new IsomorphicStringUtil();
        System.out.println(isomorphicStringUtil.isIsomorphic(s,t));
    }
}
