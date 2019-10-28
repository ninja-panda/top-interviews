package com.google.array;

import java.util.*;

public class AnagramSet {

    public static void main(String[] args) {
        String[] StrArr = {"star", "dog", "car", "rats", "ars", "rca"};
        Map<String, List<String>> anagramGroup = getAnagramSet(StrArr);
        printAnagramGroup(anagramGroup);
    }

    public static Map<String, List<String>> getAnagramSet(String[] arr) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        if (arr == null || arr.length == 1) {
            return anagramMap;
        }
        for (String word : arr) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.copyValueOf(charArray);
            List<String> wordList = anagramMap.get(sorted);
            if (wordList == null) {
                wordList = new ArrayList<>();
                wordList.add(word);
                anagramMap.put(sorted, wordList);
            } else {
                anagramMap.get(sorted).add(word);
            }
        }
        return anagramMap;
    }

    public static void printAnagramGroup(Map<String, List<String>> map) {
        map.forEach((key, value) -> {
            if (value.size() > 1)
                System.out.println("Anagram Group :" + value);
        });
    }
}
