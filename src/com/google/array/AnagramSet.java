package com.google.array;

import java.util.*;

public class AnagramSet {

    public static void main(String[] args) {
        String[] StrArr = {"star", "dog", "car", "rats", "ars", "rca"};
        List<List<String>>  anagramGroup= getAnagramSet(StrArr);
        System.out.println(anagramGroup);
    }

    public static List<List<String>> getAnagramSet(String[] arr) {
        List<List<String>> anagramGroup = new ArrayList<>();
        if (arr == null || arr.length == 1) {
            return anagramGroup;
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
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
        return new ArrayList(anagramMap.values());
    }
}
